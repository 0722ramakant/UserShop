package com.example.usershop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class OnlyCartoon extends AppCompatActivity {
    ImageView imageView;
    TextView txtname;
    TextView txtbrand;
    TextView txtprice;
    TextView txtweight;
    TextView txtdescription;
    TextView numberofcartoon,cartoonprice;

    TextView totalprice;
    ElegantNumberButton elegantNumberButton;
    String pin;


    ArrayList<Addtocartitem> list=new ArrayList<>();
    String noofbox1,noofcartoon1;
    String itemid,itemcategory;
    int k=0;
    AddtocartDB addtocartDB;
    TextView addtocartonlycartoon;

    String Image;
    String name;
    String brand;
    String price;
    String weight;
    String description;
    String unit;
    int total,sum1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_catoon);

        Intent intent=getIntent();
        pin=intent.getStringExtra("pin");
        Image=intent.getStringExtra("image");
        itemcategory=intent.getStringExtra("itemcategory");
        itemid=intent.getStringExtra("itemid11");

        Toast.makeText(getApplicationContext(),itemcategory,Toast.LENGTH_LONG).show();

        name=intent.getStringExtra("itemname");
        brand=intent.getStringExtra("brandname");
        price=intent.getStringExtra("onecartoonprice");
        weight=intent.getStringExtra("onecartoonweight");
        description=intent.getStringExtra("itemdescription");
        unit=intent.getStringExtra("onecartoonunit");


        imageView=findViewById(R.id.imagec);
        txtname=findViewById(R.id.txtname);
        txtbrand=findViewById(R.id. txtbrand);
        txtprice=findViewById(R.id.txtprice);
        txtweight=findViewById(R.id.txtweight);
        txtdescription=findViewById(R.id.txtdescription);

      numberofcartoon=findViewById(R.id.numberofcartoon);
      cartoonprice=findViewById(R.id.cartoonprice);

        totalprice=findViewById(R.id.totalprice);
        totalprice=findViewById(R.id.totalprice);

        addtocartonlycartoon=findViewById(R.id.addtocartonlycartoon);

        addtocartDB=new AddtocartDB(this);
        addtocartDB.getAlldata();;
        list=addtocartDB.getItem();
        for(Addtocartitem b:list) {

            if(b.getItemid().trim().equals(itemid.trim()))
            {
                addtocartonlycartoon.setText("Go To Cart");
                k=1;
            }

        }

        elegantNumberButton=findViewById(R.id.numberbutton1);
        elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

                // int n=Integer.parseInt(elegantNumberButton.getNumber());
                int p=Integer.parseInt(price);
                sum1=p*newValue;
                noofbox1=String.valueOf(newValue);
                numberofcartoon.setText(" "+newValue);
               cartoonprice.setText("₹ "+sum1);
                total=sum1;
                totalprice.setText("Total ₹ "+total);
            }
        });



        addtocartonlycartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k==0) {




                    addtocartDB.insertdata(name, itemid, brand, Image, description, "", "", "", price, weight, unit, "", "", "", "",
                            "", "", "", unit, "", "", "", "", itemcategory, "", noofbox1, "", "" + sum1, "" + "", "" + total);

                    Toast.makeText(getApplicationContext(),"data is insert",Toast.LENGTH_LONG).show();
                    k=1;
                    addtocartonlycartoon.setText("go to cart");

                }
                else {

                    addtocartDB.getAlldata();;
                    list=addtocartDB.getItem();

                    for(Addtocartitem b:list) {

                        if(b.getItemid().trim().equals(itemid.trim()))
                        {

                            String itemid1=b.getItemid();
                            addtocartDB.update(itemid1,noofbox1,""+sum1,"","",""+total);
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
        txtweight.setText(weight+" "+unit);
        txtdescription.setText(description);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("OnlyCartoon");
        mToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnlyCartoon.this, SearchItem.class);
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
            Intent intent = new Intent(OnlyCartoon.this, SearchItem.class);
            intent.putExtra("pincode",pin);
            startActivity(intent);
            finish();

            return true;
        }

        if (id==R.id.myCart){
            Intent i=new Intent(OnlyCartoon.this,MyCart.class);
            startActivity(i);



            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
