package com.example.usershop;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {

    List<Addtocartitem> list1=new ArrayList<>();
    RecyclerView recycleaddtoitem;

    RecyclerAdapterAddtocart recyclerAdapterAddtocart;
    AddtocartDB addtocartDB;
    TextView totalamount,next;
    DatabaseReference requests;

    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Groza");
        mToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyCart.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });





        recycleaddtoitem = (RecyclerView) findViewById(R.id.recycleaddtcart1);
        totalamount=findViewById(R.id.totalamount);

        next=findViewById(R.id.next);

        addtocartDB=new AddtocartDB(this);
        addtocartDB.getAlldata();
        addtocartDB.getsum();
        list1=addtocartDB.getItem();

        int a=addtocartDB.getTotal();
        totalamount.setText("₹ "+a);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Addaddress.class);
                startActivity(intent);
            }
        });




        RecyclerView.LayoutManager recyce = new GridLayoutManager(getApplicationContext(),1);
        /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
        // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recycleaddtoitem.setLayoutManager(recyce);
        recycleaddtoitem.setItemAnimator( new DefaultItemAnimator());

        recyclerAdapterAddtocart=new RecyclerAdapterAddtocart(list1,this);
        recycleaddtoitem.setAdapter(recyclerAdapterAddtocart);



    }




    }



