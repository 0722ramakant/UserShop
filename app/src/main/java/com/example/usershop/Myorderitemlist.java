package com.example.usershop;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Myorderitemlist extends AppCompatActivity {
    ArrayList<Addtocartitem> addtocartitems=new ArrayList<>();
    RecyclerView recycleaddtoitem;

    RecyclerAdapterMyordeitemlist recyclerAdapterMyordeitemlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorderitemlist);

        addtocartitems=(ArrayList<Addtocartitem>)getIntent().getSerializableExtra("mylist");
        recycleaddtoitem = (RecyclerView) findViewById(R.id.recycleaddtcart1);

        RecyclerView.LayoutManager recyce = new GridLayoutManager(getApplicationContext(),1);
        /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
        // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recycleaddtoitem.setLayoutManager(recyce);
        recycleaddtoitem.setItemAnimator( new DefaultItemAnimator());
        recyclerAdapterMyordeitemlist=new RecyclerAdapterMyordeitemlist(addtocartitems,getApplicationContext());
        recycleaddtoitem.setAdapter(recyclerAdapterMyordeitemlist);



    }





}
