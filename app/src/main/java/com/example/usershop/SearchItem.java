package com.example.usershop;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import dmax.dialog.SpotsDialog;

public class SearchItem extends AppCompatActivity   {

     MaterialSearchView searchView;
    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;
    private  Adapter adapter;
    public  static ArrayList<Listpincode> allitms;
    ArrayList<Listpincode> list=new ArrayList<>();



    String pincode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);

        Intent intent=getIntent();
         pincode=intent.getStringExtra("pincode");


        recyclerView = findViewById(R.id.recylerAll);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("uploadedItemDetails").child(pincode).child("allproducts");

        data();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Groza");
        mToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchItem.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



         searchView=findViewById(R.id.searchView);
         searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
             @Override
             public void onSearchViewShown() {

             }

             @Override
             public void onSearchViewClosed() {


             }
         });
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text=newText;
        adapter.filter(text);
       return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.toolbar_menu,menu);
       MenuItem item=menu.findItem(R.id.action_search);
       searchView.setMenuItem(item);
       return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();



        if (id==R.id.myCart){
            Intent i=new Intent(SearchItem.this,MyCart.class);
            startActivity(i);



            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    void data()
    {
        final SpotsDialog spotsDialog = new SpotsDialog(this);
        spotsDialog.show();
        spotsDialog.setMessage("Loading");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Allitm allitm=dataSnapshot1.getValue(Allitm.class);
                    Listpincode listpincode=new Listpincode(allitm,pincode);
                    list.add(listpincode);
                }
                allitms=list;

                adapter=new Adapter(getApplicationContext(),allitms);
                recyclerView.setAdapter(adapter);
                spotsDialog.dismiss();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



}
