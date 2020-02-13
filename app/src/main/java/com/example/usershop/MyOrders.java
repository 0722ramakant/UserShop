package com.example.usershop;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;

public class MyOrders extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapterMyOrder recyclerAdapterMyOrder;
    List<Placeaddress> placeaddresses=new ArrayList<>();
    FirebaseAuth firebaseAuth;
    String number;

  FirebaseDatabase db;
 DatabaseReference requests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        recyclerView=findViewById(R.id.recyclerOrder);

        requests = FirebaseDatabase.getInstance().getReference().child("uploadedItemDetails").child("249410").child("request");

        RecyclerView.LayoutManager recyce = new GridLayoutManager(getApplicationContext(),1);
        /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
        // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setLayoutManager(recyce);
        recyclerView.setItemAnimator( new DefaultItemAnimator());




        firebaseAuth= FirebaseAuth.getInstance();
        number=firebaseAuth.getCurrentUser().getPhoneNumber();

        data();
    }


    void data()
    {

        requests.child(number).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                placeaddresses.clear();
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){


                    Placeaddress placeaddress1=dataSnapshot1.getValue(Placeaddress.class);
                    Toast.makeText(MyOrders.this,""+placeaddress1.getCurrentTime(),Toast.LENGTH_LONG).show();

                    placeaddresses.add(placeaddress1);
                }

                recyclerAdapterMyOrder=new RecyclerAdapterMyOrder(placeaddresses,getApplicationContext());
                recyclerView.setAdapter(recyclerAdapterMyOrder);


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }








}
