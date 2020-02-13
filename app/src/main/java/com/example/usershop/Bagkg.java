package com.example.usershop;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Bagkg extends AppCompatActivity {
    ImageView imageView;
    TextView txtname;
    TextView txtbrand;
    TextView txtprice;

    TextView txtdescription;
    TextView txtonebagprice;
    TextView txtonebagweight;
    TextView addtocartbagkg;

    ElegantNumberButton elegantNumberButton,elegantNumberButton1;
    String pin;
    ArrayList<Addtocartitem> list=new ArrayList<>();
    String noofbox1,noofcartoon1;
    String itemid,itemcategory;

    String Image;
    String name;
    String brand;
    String price;
    TextView numberofkg,kgprice;
    TextView numberofbag,Bagprice;
    TextView totalprice;

    String description;
    String onebagprice;
    String onebagweight;
    String onebagunit;
    int total,sum1=0,sum2=0;
    int k=0;
    AddtocartDB addtocartDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagkg);
        Intent intent=getIntent();
        pin=intent.getStringExtra("pin");

        itemcategory=intent.getStringExtra("itemcategory");
        itemid=intent.getStringExtra("itemid11");

        Toast.makeText(getApplicationContext(),itemcategory,Toast.LENGTH_LONG).show();


        Image=intent.getStringExtra("image");
        name=intent.getStringExtra("itemname");
        brand=intent.getStringExtra("brandname");
        price=intent.getStringExtra("itemprice");

        description=intent.getStringExtra("itemdescription");
        onebagprice=intent.getStringExtra("onebagprice");
        onebagweight=intent.getStringExtra("onebagweight");
        onebagunit=intent.getStringExtra("onebagunit");

        imageView=findViewById(R.id.image);
        txtname=findViewById(R.id.txtname);
        txtbrand=findViewById(R.id. txtbrand);
        txtprice=findViewById(R.id.txtprice);



        txtdescription=findViewById(R.id.txtdescription);
        txtonebagprice=findViewById(R.id.txtonebagprice);
        txtonebagweight=findViewById(R.id.txtonebagweight);

        numberofkg=findViewById(R.id.numberofkg);
        kgprice=findViewById(R.id.kgprice);
        numberofbag=findViewById(R.id.numberofbag);
        Bagprice=findViewById(R.id.bagprice);
        totalprice=findViewById(R.id.totalprice);

        addtocartbagkg=findViewById(R.id.addtocartbagkg);



        elegantNumberButton=findViewById(R.id.numberbutton1);
        elegantNumberButton1=findViewById(R.id.numberbutton2);


        addtocartDB=new AddtocartDB(this);
        addtocartDB.getAlldata();;
        list=addtocartDB.getItem();

        for(Addtocartitem b:list) {

            if(b.getItemid().trim().equals(itemid.trim()))
            {
                addtocartbagkg.setText("Go To Cart");
                k=1;
            }

        }

        elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

               // int n=Integer.parseInt(elegantNumberButton.getNumber());
                int p=Integer.parseInt(price);
                sum1=p*newValue;
                noofbox1=String.valueOf(newValue);
                numberofkg.setText(" "+newValue);
                kgprice.setText("₹ "+sum1);
                total=sum1+sum2;
                totalprice.setText("Total ₹ "+total);
            }
        });

        elegantNumberButton1.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

                // int n=Integer.parseInt(elegantNumberButton.getNumber());
                int p=Integer.parseInt(onebagprice);
                sum2=p*newValue;
                noofcartoon1=String.valueOf(newValue);


                numberofbag.setText(" "+newValue);
                Bagprice.setText("₹ "+sum2);

                total=sum1+sum2;
                totalprice.setText("Total ₹ "+total);
            }
        });


        addtocartbagkg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(k==0) {



                    addtocartDB.insertdata(name, itemid, brand, Image, description, "", "", "", "", "", "", "", "", "", "",
                            onebagprice, onebagweight, "", onebagunit, price, "", "", "", itemcategory, "", noofbox1, noofcartoon1, "" + sum1, "" + sum2, "" + total);

                    Toast.makeText(getApplicationContext(),"data is insert",Toast.LENGTH_LONG).show();
                    k=1;
                    addtocartbagkg.setText("go to cart");

                }
                else {

                    addtocartDB.getAlldata();;
                    list=addtocartDB.getItem();

                    for(Addtocartitem b:list) {

                        if(b.getItemid().trim().equals(itemid.trim()))
                        {

                            String itemid1=b.getItemid();
                            addtocartDB.update(itemid1,noofbox1,""+sum1,noofcartoon1,""+sum2,""+total);
                            Toast.makeText(getApplicationContext(),"  cart update",Toast.LENGTH_LONG).show();
                        }

                    }




                }
            }

        });


        Picasso.with(this).load(Image)
                .into(imageView);
        txtname.setText(name);
        txtbrand.setText(brand);
        txtprice.setText("₹ "+price);
        txtdescription.setText(description);
        txtonebagprice.setText("₹ "+onebagprice);
        txtonebagweight.setText(onebagweight+" "+onebagunit);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Bagkg");
        mToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bagkg.this, SearchItem.class);
                intent.putExtra("pincode",pin);

                startActivity(intent);
                finish();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Intent intent = new Intent(Bagkg.this, SearchItem.class);
            intent.putExtra("pincode",pin);
            startActivity(intent);
            finish();

            return true;
        }

        if (id==R.id.myCart){
            Intent i=new Intent(Bagkg.this,MyCart.class);
            startActivity(i);



            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
