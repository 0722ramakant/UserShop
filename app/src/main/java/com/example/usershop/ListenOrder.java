package com.example.usershop;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ListenOrder extends Service implements ChildEventListener {

    FirebaseDatabase db;
    DatabaseReference requests;
    FirebaseAuth firebaseAuth;
    String number;

    @Override
    public void onCreate() {
        super.onCreate();


        firebaseAuth= FirebaseAuth.getInstance();
        number=firebaseAuth.getCurrentUser().getPhoneNumber();
        db= FirebaseDatabase.getInstance();

        requests = FirebaseDatabase.getInstance().getReference().child("uploadedItemDetails").child("249410").child("request").child("+919548039381");



    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        requests.addChildEventListener((ChildEventListener) this);
        return super.onStartCommand(intent, flags, startId);
    }

    public ListenOrder() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


    }

    private void showNotification(String key, Placeaddress placeaddress1) {
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent intent=new Intent(getBaseContext(),MainActivity.class);
       intent.putExtra("UserPhone",number);
        PendingIntent contentIntent= (PendingIntent) PendingIntent.getActivity(getBaseContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder=new NotificationCompat.Builder(getBaseContext());
        builder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setTicker("UserApp")
                .setContentInfo("Your Order was updated")
                .setContentText(" order #"+key+"was update status to "+Common.convertCodeToStatus(placeaddress1.getStatus()))
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentIntent(contentIntent)
               .setSound(soundUri)
                .setContentInfo("info");




        NotificationManager notificationManager= (NotificationManager) getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);




        notificationManager.notify(1,builder.build());

    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

//        DataSnapshot dataSnapshot1= (DataSnapshot) dataSnapshot.getChildren();
//        Placeaddress placeaddress1=dataSnapshot1.getValue(Placeaddress.class);
//        Toast.makeText(ListenOrder.this,""+placeaddress1.getCurrentTime(),Toast.LENGTH_LONG).show();
        requests.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){


                    Placeaddress placeaddress1=dataSnapshot1.getValue(Placeaddress.class);


                    showNotification(placeaddress1.getCurrentTime(), placeaddress1);
                }




            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {




    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }


}
