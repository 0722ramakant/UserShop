package com.example.usershop;

import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
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

public class CartoonBoxPice extends AppCompatActivity {

    ImageView imageView;
    TextView txtname;
    TextView txtbrand;
    TextView txtprice;
    TextView txtweight;
    TextView txtdescription;
    TextView txtoneboxprice;
    TextView txtoneboxweight;
    TextView txtonecartoonprice;
    TextView txtonecartoonweight;
    ElegantNumberButton elegantNumberButton,elegantNumberButton1;
    TextView numberofbox,boxprice;
    TextView numberofcartoon,cartoonprice;
    TextView totalprice;

    TextView addtocartcbp;

    ArrayList<Addtocartitem> list=new ArrayList<>();


    String pin;

    String Image;
    String name;
    String brand;
    String price;
    String weight;
    String unit;
    String description;
    String oneboxprice;
    String oneboxweight;
    String oneboxunit;
    String onecartoonprice;
    String onecartoonweight;
    String onecartoonunit;
    String itemid,itemcategory;
    String noofbox1,noofcartoon1;
    int total,sum1=0,sum2=0;
    int k=0;
     AddtocartDB addtocartDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catoon_box_pice);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Cartoonboxpice");
        mToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartoonBoxPice.this, SearchItem.class);
                intent.putExtra("pincode",pin);
                startActivity(intent);
                finish();
            }
        });


        Intent intent=getIntent();
        pin=intent.getStringExtra("pin");
        itemcategory=intent.getStringExtra("itemcategory");

        Toast.makeText(getApplicationContext(),itemcategory,Toast.LENGTH_LONG).show();


        itemid=intent.getStringExtra("itemid11");
        Image=intent.getStringExtra("image");
        name=intent.getStringExtra("itemname");
        brand=intent.getStringExtra("brandname");
        price=intent.getStringExtra("itempriceperpices");
        weight =intent.getStringExtra("itemweight");
        unit=intent.getStringExtra("itemunit");

        description=intent.getStringExtra("itemdescription");
        oneboxprice=intent.getStringExtra("oneboxprice");
        oneboxweight=intent.getStringExtra("oneboxquantity");
        oneboxunit=intent.getStringExtra("oneboxunit");
        onecartoonprice=intent.getStringExtra("onecartoonprice");
        onecartoonweight=intent.getStringExtra("onecartoonquantity");
        onecartoonunit=intent.getStringExtra("onecartoonunit");

        imageView=findViewById(R.id.image);
        txtname=findViewById(R.id.txtname);
        txtbrand=findViewById(R.id. txtbrand);
        txtprice=findViewById(R.id.txtprice);
        txtweight=findViewById(R.id.txtweight);
        txtdescription=findViewById(R.id.txtdescription);
        txtoneboxprice=findViewById(R.id.txtoneboxprice);
       txtoneboxweight=findViewById(R.id.txtoneboxweight);
        txtonecartoonprice=findViewById(R.id.txtonecartoonprice);
        txtonecartoonweight=findViewById(R.id.txtonecartoonweight);
        numberofbox=findViewById(R.id.numberofbox);
       boxprice=findViewById(R.id.boxprice);
        numberofcartoon=findViewById(R.id.numberofcartoon);
        cartoonprice=findViewById(R.id.cartoonprice);
        totalprice=findViewById(R.id.totalprice);

        addtocartcbp=findViewById(R.id.addtocartcbp);



        Picasso.with(this).load(Image)
                .into(imageView);
        txtname.setText(name);
        txtbrand.setText(brand);
        txtprice.setText("₹ "+price);
        txtweight.setText(weight+" "+unit);
        txtdescription.setText(description);
       txtoneboxprice.setText("₹ "+oneboxprice);
        txtoneboxweight.setText(oneboxweight+" "+oneboxunit);
        txtonecartoonprice.setText("₹ "+onecartoonprice);
        txtonecartoonweight.setText(onecartoonweight+" "+onecartoonunit);


        elegantNumberButton=findViewById(R.id.numberbutton1);
        elegantNumberButton1=findViewById(R.id.numberbutton2);

        elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

                // int n=Integer.parseInt(elegantNumberButton.getNumber());
                int p=Integer.parseInt(oneboxprice);
                sum1=p*newValue;

                noofbox1=String.valueOf(newValue);
                numberofbox.setText(" "+newValue);
                boxprice.setText("₹ "+sum1);
                total=sum1+sum2;
                totalprice.setText("Total ₹ "+total);
            }
        });

        elegantNumberButton1.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

                // int n=Integer.parseInt(elegantNumberButton.getNumber());
                int p=Integer.parseInt(onecartoonprice);
                sum2=p*newValue;
                noofcartoon1=String.valueOf(newValue);
                numberofcartoon.setText(" "+newValue);
                cartoonprice.setText("₹ "+sum2);
                total=sum1+sum2;
                totalprice.setText("Total ₹ "+total);





            }
        });









        // String itemname,itemid,brandname,itemimageurl,itemdescription,onelariprice,onelariquantity,onelariunit,onecartoonprice,onecartoonquantity,
        // onecartoonunit,onecartoonweight, oneboxprice,oneboxquantity,oneboxunit,onebagprice,onebagquantity,onebagweight,onebagunit,itempriceperkg,
        // itempriceperpice,itemweight, itemunit,itemCategory, itemquantity,noofbox_pices_kg,noof_bag_cartoon,noofbox_pices_kg_price, noof_bag_cartoon_price,totalprice;


        addtocartDB=new AddtocartDB(this);
        addtocartDB.getAlldata();;
        list=addtocartDB.getItem();
        for(Addtocartitem b:list) {

            if(b.getItemid().trim().equals(itemid.trim()))
            {
               addtocartcbp.setText("Go To Cart");
                k=1;
            }

        }
        addtocartcbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(k==0) {


                    addtocartDB.insertdata(name, itemid, brand, Image, description, "", "", "", onecartoonprice, onecartoonweight, onecartoonunit, "", oneboxprice, oneboxweight, oneboxunit,
                            "", "", "", "", "", price, weight, unit, itemcategory, "", noofbox1, noofcartoon1, "" + sum1, "" + sum2, "" + total);

                    Toast.makeText(getApplicationContext(),"data is insert",Toast.LENGTH_LONG).show();
                   k=1;
                   addtocartcbp.setText("go to cart");

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
            Intent intent = new Intent(CartoonBoxPice.this, SearchItem.class);
            intent.putExtra("pincode",pin);
            startActivity(intent);
            finish();

            return true;
        }

        if (id==R.id.myCart){
            Intent i=new Intent(CartoonBoxPice.this,MyCart.class);
            startActivity(i);



            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
