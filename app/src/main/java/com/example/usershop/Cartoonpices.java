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

public class Cartoonpices extends AppCompatActivity {
    ImageView imageView;
    TextView txtname;
    TextView txtbrand;
    TextView txtprice;
    TextView txtweight;
    TextView txtdescription;
    TextView txtonecartoonprice;
    TextView txtonecartoonweight;
     ElegantNumberButton elegantNumberButton,elegantNumberButton1;
    TextView numberofpice,piceprice;
    TextView numberofcartoon,cartoonprice;
    TextView totalprice;

    ArrayList<Addtocartitem> list=new ArrayList<>();
    String noofbox1,noofcartoon1;
    String itemid,itemcategory;
    int k=0;
    TextView addtocartcartoonpices;

    AddtocartDB addtocartDB;

    String pin;

    String Image;
    String name;
    String brand;
    String price;
    String weight;
    String unit;
    String description;

    String onecartoonprice;
    String onecartoonweight;
    String onecartoonunit;
    int total,sum1=0,sum2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoonpices);

        Intent intent=getIntent();
        pin=intent.getStringExtra("pin");
        Image=intent.getStringExtra("image");
        name=intent.getStringExtra("itemname");
        brand=intent.getStringExtra("brandname");
        price=intent.getStringExtra("itempriceperpices");
        weight =intent.getStringExtra("itemweight");
        unit=intent.getStringExtra("itemunit");

        itemcategory=intent.getStringExtra("itemcategory");
        itemid=intent.getStringExtra("itemid11");

        Toast.makeText(getApplicationContext(),itemcategory,Toast.LENGTH_LONG).show();

        description=intent.getStringExtra("itemdescription");

        onecartoonprice=intent.getStringExtra("onecartoonprice");
        onecartoonweight=intent.getStringExtra("onecartoonquantity");
        onecartoonunit=intent.getStringExtra("onecartoonunit");

        imageView=findViewById(R.id.image);
        txtname=findViewById(R.id.txtname);
        txtbrand=findViewById(R.id. txtbrand);
        txtprice=findViewById(R.id.txtprice);
        txtweight=findViewById(R.id.txtweight);
        txtdescription=findViewById(R.id.txtdescription);
        txtonecartoonprice=findViewById(R.id.txtonecartoonprice);
        txtonecartoonweight=findViewById(R.id.txtonecartoonweight);
        numberofpice=findViewById(R.id.numberofpice);
        piceprice=findViewById(R.id.piceprice);
        numberofcartoon=findViewById(R.id.numberofcartoon);
        cartoonprice=findViewById(R.id.cartoonprice);
        totalprice=findViewById(R.id.totalprice);

        addtocartcartoonpices=findViewById(R.id.addtocartcartoonpices);

        elegantNumberButton=findViewById(R.id.numberbutton1);
        elegantNumberButton1=findViewById(R.id.numberbutton2);

        elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

                // int n=Integer.parseInt(elegantNumberButton.getNumber());
                int p=Integer.parseInt(price);
                sum1=p*newValue;

                noofbox1=String.valueOf(newValue);
                numberofpice.setText(" "+newValue);
                piceprice.setText("₹ "+sum1);
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

        addtocartDB=new AddtocartDB(this);
        addtocartDB.getAlldata();;
        list=addtocartDB.getItem();

        for(Addtocartitem b:list) {

            if(b.getItemid().trim().equals(itemid.trim()))
            {
                addtocartcartoonpices.setText("Go To Cart");
                k=1;
            }

        }


        addtocartcartoonpices.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if(k==0) {



                     addtocartDB.insertdata(name, itemid, brand, Image, description, "", "", "", onecartoonprice, onecartoonweight, onecartoonunit, "", "", "", "",
                             "", "", "", "", "", price, weight, unit, itemcategory, "", noofbox1, noofcartoon1, "" + sum1, "" + sum2, "" + total);

                     Toast.makeText(getApplicationContext(),"data is insert",Toast.LENGTH_LONG).show();
                     k=1;
                     addtocartcartoonpices.setText("go to cart");

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
        txtweight.setText(weight+""+unit);
        txtdescription.setText(description);
        txtonecartoonprice.setText("₹ "+onecartoonprice);
        txtonecartoonweight.setText(onecartoonweight+" "+onecartoonunit);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Cartoonpice");
        mToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cartoonpices.this, SearchItem.class);
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
            Intent intent = new Intent(Cartoonpices.this, SearchItem.class);
            intent.putExtra("pincode",pin);
            startActivity(intent);
            finish();

            return true;
        }

        if (id==R.id.myCart){
            Intent i=new Intent(Cartoonpices.this,MyCart.class);
            startActivity(i);



            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
