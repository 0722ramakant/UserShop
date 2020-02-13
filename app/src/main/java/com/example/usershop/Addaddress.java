package com.example.usershop;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Addaddress extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    String phoneNumber;
   private Date date;
    private   SimpleDateFormat  simpleDateFormat;
    private    String currenttime;
    FirebaseAuth firebaseAuth;
    public String status="0";
    public TextInputLayout Name;
    public TextInputLayout  mobile_no;
    public TextInputLayout  zipcode;
    public TextInputLayout shopname;
    public TextInputLayout  roadname;
    public TextInputLayout city;
    public TextInputLayout  state;
    public TextInputLayout landmark;


    Placeaddress placeaddress;
    CardView Currentlocation;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference mDatabase;
    int a;
    TextView order;
    int k;
    ArrayList<Addtocartitem> list=new ArrayList<>();
    AddtocartDB addtocartDB;
    private static final int GOOGLE_API_CLIENT_ID = 0;
    protected GoogleApiClient mGoogleApiClient;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaddress);




        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, GOOGLE_API_CLIENT_ID /* clientId */, this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .build();


        Name=findViewById(R.id.edtname);
        mobile_no=findViewById(R.id.edtmobile);
        zipcode=findViewById(R.id.edtpincode);
        shopname=findViewById(R.id.edtshop);
        roadname=findViewById(R.id.edtroad);
        city=findViewById(R.id.edtcity);
        state=findViewById(R.id.edtstate);
        landmark=findViewById(R.id.edtlandmark);
        Currentlocation=findViewById(R.id.currentlocation);

        Currentlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                location();

            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference().child("uploadedItemDetails").child("249410");

        firebaseAuth=FirebaseAuth.getInstance();
        phoneNumber=firebaseAuth.getCurrentUser().getPhoneNumber();
      //  Toast.makeText(getApplicationContext(),d,Toast.LENGTH_SHORT).show();



        order=findViewById(R.id.order);
       String pattern = "yyyy-MM-dd HH:mm:ss";
          simpleDateFormat = new SimpleDateFormat(pattern);
        date = new Date();
         currenttime=simpleDateFormat.format(date).trim();


        addtocartDB=new AddtocartDB(this);
        addtocartDB.getAlldata();
        list=addtocartDB.getItem();
        k=list.size();
       Toast.makeText(getApplicationContext()," value"+k,Toast.LENGTH_SHORT).show();

        addtocartDB.getsum();
         a=addtocartDB.getTotal();
       final String id=mDatabase.push().getKey();

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                   placeaddress=new Placeaddress(currenttime,status,Name.getEditText().getText().toString(),
                           mobile_no.getEditText().getText().toString(),zipcode.getEditText().getText().toString()
                           ,shopname.getEditText().getText().toString(),roadname.getEditText().getText().toString(),
                           city.getEditText().getText().toString(),state.getEditText().getText().toString(),
                           landmark.getEditText().getText().toString(),
                           "Cash on delivery",""+k,""+a,list);



                   mDatabase.child("request").child(phoneNumber).child(currenttime).setValue(placeaddress);
                     Toast.makeText(Addaddress.this,"Thankyou",Toast.LENGTH_SHORT).show();

                mDatabase.child("allorder").child(currenttime).setValue(placeaddress);
                Toast.makeText(Addaddress.this,"Thankyou",Toast.LENGTH_SHORT).show();


                }


        });


        Toast.makeText(getApplicationContext()," total price  "+a+" size  "+list.size(),Toast.LENGTH_SHORT).show();
    }



    void location() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }
        PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi
                .getCurrentPlace(mGoogleApiClient, null);
        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
            @Override
            public void onResult(PlaceLikelihoodBuffer likelyPlaces) {


                if (!likelyPlaces.getStatus().isSuccess()) {
                    // Request did not complete successfully
                    //  Log.e(TAG, "Place query did not complete. Error: " + likelyPlaces.getStatus().toString());
                    likelyPlaces.release();
                    return;
                }


                zip(likelyPlaces.get(0).getPlace().getLatLng());
                likelyPlaces.release();
            }
        });


    }
    Address address1=null;
    String addr="";
    String zipcode1="";
    String city1="";
    String state1="";
    void  zip(LatLng latLng)
    {
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.ENGLISH);
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(latLng.latitude,latLng.longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (addresses != null && addresses.size() > 0){

           // addr=addresses.get(0).getAddressLine(0);
            city1=addresses.get(0).getLocality();
            state1=addresses.get(0).getAdminArea();


            for(int i=0 ;i<addresses.size();i++){
                address1 = addresses.get(i);
                if(address1.getPostalCode()!=null){
                    zipcode1=address1.getPostalCode();

                    Toast.makeText(getApplicationContext(),zipcode1,Toast.LENGTH_LONG).show();


                    break;
                }

            }

            zipcode.getEditText().setText(zipcode1);
            city.getEditText().setText(city1+" , "+addresses.get(0).getSubAdminArea());
            state.getEditText().setText(state1);
            roadname.getEditText().setText(addresses.get(0).getSubLocality());
            // pin.setText(zipcode);

        }
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
