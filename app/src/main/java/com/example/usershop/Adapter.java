package com.example.usershop;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

import me.grantland.widget.AutofitTextView;

/**
 * Created by Parsania Hardik on 26-Jun-17.
 */

class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
LinearLayout linearLayout;
    Button button;
    public AutofitTextView name;;
    public     TextView price;;
    public     TextView OneItemQuantity;;

    public     TextView brandname;
    public ImageView img;

    private ItemClickListner itemClickListner;

    public  MyViewHolder(@NonNull View itemView) {
        super(itemView);
       linearLayout =itemView.findViewById(R.id.lay1);
        button=itemView.findViewById(R.id.showbtn);
        name =  itemView.findViewById(R.id.itemname);
        price = (TextView) itemView.findViewById(R.id.ItemPrice);
        OneItemQuantity = (TextView) itemView.findViewById(R.id.weight);

       // brandname = (TextView) itemView.findViewById(R.id.brandnm);
        img=itemView.findViewById(R.id.img);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View v) {
        itemClickListner.onClick(v, getAdapterPosition(), false);

    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListner.onClick(v, getAdapterPosition(), false);
        return true;
    }
}

public class Adapter extends RecyclerView.Adapter<MyViewHolder>     {
        private Context ctx;
    private LayoutInflater inflater;
    private ArrayList<Listpincode> imageModelArrayList;
    private ArrayList<Listpincode> arraylist;

    public Adapter(Context ctx, ArrayList<Listpincode> imageModelArrayList){
this.ctx=ctx;
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        this.arraylist = new ArrayList<Listpincode>();
        this.arraylist.addAll(SearchItem.allitms);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.allitemlayout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
//           holder.setItemClickListner(new ItemClickListner() {
//               @Override
//               public void onClick(View view, int position, boolean isLongClick) {
//
//                   Intent i=new Intent(ctx, CartoonBoxPice.class);
//                   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                   ctx.startActivity(i);
//
//               }
//           });



//       holder. button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i=new Intent(ctx, CartoonBoxPice.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                ctx.startActivity(i);
//
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.name.setText(imageModelArrayList.get(position).allitm.getItemname());
     //   holder.price.setText("₹ "+imageModelArrayList.get(position).allitm.getItempriceperkg());
      //  holder.OneItemQuantity.setText(imageModelArrayList.get(position).allitm.getOneItemquantity());
      //  holder.brandname.setText(imageModelArrayList.get(position).getBrandname());


        if((imageModelArrayList.get(position).allitm.getItemCategory().toString()).equals("Only_Cartoon")){
            holder.price.setText("₹ "+imageModelArrayList.get(position).allitm.getOnecartoonprice());
            holder.OneItemQuantity.setText(imageModelArrayList.get(position).allitm.getOnecartoonweight().toString()+" "+imageModelArrayList.get(position).allitm.getOnecartoonunit().toString());
        }
        else if((imageModelArrayList.get(position).allitm.getItemCategory().toString()).equals("Cartton-lari-pices")){
            holder.price.setText("₹ "+imageModelArrayList.get(position).allitm.getItempriceperpice());
            holder.OneItemQuantity.setText(imageModelArrayList.get(position).allitm.getItemweight().toString()+" "+imageModelArrayList.get(position).allitm.getItemunit().toString());

        }

        else if((imageModelArrayList.get(position).allitm.getItemCategory().toString()).equals("BagKg")){
            holder.price.setText("₹ "+imageModelArrayList.get(position).allitm.getItempriceperkg());
holder.OneItemQuantity.setText(imageModelArrayList.get(position).allitm.getOnebagunit());

        }

        else if((imageModelArrayList.get(position).allitm.getItemCategory().toString()).equals("Cartton-Box-pices")){
            holder.price.setText("₹ "+imageModelArrayList.get(position).allitm.getItempriceperpice());
            holder.OneItemQuantity.setText(imageModelArrayList.get(position).allitm.getItemweight().toString()+" "+imageModelArrayList.get(position).allitm.getItemunit().toString());

        }

        else if((imageModelArrayList.get(position).allitm.getItemCategory().toString()).equals("Cartoon_pices")){
            holder.price.setText("₹ "+imageModelArrayList.get(position).allitm.getItempriceperpice());
            holder.OneItemQuantity.setText(imageModelArrayList.get(position).allitm.getItemweight().toString()+" "+imageModelArrayList.get(position).allitm.getItemunit().toString());

        }

        else if((imageModelArrayList.get(position).allitm.getItemCategory().toString()).equals("Cartoon_pices")){
            holder.price.setText("₹ "+imageModelArrayList.get(position).allitm.getOnebagprice());
            holder.OneItemQuantity.setText(imageModelArrayList.get(position).allitm.getOnebagquantity().toString()+" "+imageModelArrayList.get(position).allitm.getItemunit().toString());

        }
        Picasso.with(ctx).load(imageModelArrayList.get(position).allitm.getItemimageurl())
                .into(holder.img);


        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Only_Cartoon")) {
                    Intent i=new Intent(ctx,OnlyCartoon.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());

                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("onecartoonprice", imageModelArrayList.get(position).allitm.getOnecartoonprice().toString());
                    i.putExtra("onecartoonweight", imageModelArrayList.get(position).allitm.getOnecartoonweight().toString());
                    i.putExtra("onecartoonunit", imageModelArrayList.get(position).allitm.getOnecartoonunit().toString());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }
                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Cartton-lari-pices")){
                    Intent i=new Intent(ctx,CartoonLariPice.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());
                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("itempriceperpices", imageModelArrayList.get(position).allitm.getItempriceperpice().toString());
                    i.putExtra("itemweight", imageModelArrayList.get(position).allitm.getItemweight().toString());
                    i.putExtra("itemunit", imageModelArrayList.get(position).allitm.getItemunit());

                    i.putExtra("onelariprice", imageModelArrayList.get(position).allitm.getOnelariprice().toString());
                    i.putExtra("onelariquantity", imageModelArrayList.get(position).allitm.getOnelariquantity().toString());
                    i.putExtra("onelariunit", imageModelArrayList.get(position).allitm.getOnelariunit());

                    i.putExtra("onecartoonprice", imageModelArrayList.get(position).allitm.getOnecartoonprice().toString());
                    i.putExtra("onecartoonquantity", imageModelArrayList.get(position).allitm.getOnecartoonquantity().toString());
                    i.putExtra("onecartoonunit", imageModelArrayList.get(position).allitm.getOnecartoonunit());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }
                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Cartton-Box-pices")){
                    Intent i=new Intent(ctx,CartoonBoxPice.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());

                    i.putExtra("itempriceperpices", imageModelArrayList.get(position).allitm.getItempriceperpice().toString());
                    i.putExtra("itemweight", imageModelArrayList.get(position).allitm.getItemweight().toString());
                    i.putExtra("itemunit", imageModelArrayList.get(position).allitm.getItemunit());

                    i.putExtra("oneboxprice", imageModelArrayList.get(position).allitm.getOneboxprice().toString());
                    i.putExtra("oneboxquantity", imageModelArrayList.get(position).allitm.getOneboxquantity().toString());
                    i.putExtra("oneboxunit", imageModelArrayList.get(position).allitm.getOneboxunit());

                    i.putExtra("onecartoonprice", imageModelArrayList.get(position).allitm.getOnecartoonprice().toString());
                    i.putExtra("onecartoonquantity", imageModelArrayList.get(position).allitm.getOnecartoonquantity().toString());
                    i.putExtra("onecartoonunit", imageModelArrayList.get(position).allitm.getOnecartoonunit());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }

                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Cartoon_pices")){
                    Intent i=new Intent(ctx,Cartoonpices.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());

                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("itempriceperpices", imageModelArrayList.get(position).allitm.getItempriceperpice().toString());
                    i.putExtra("itemweight", imageModelArrayList.get(position).allitm.getItemweight().toString());
                    i.putExtra("itemunit", imageModelArrayList.get(position).allitm.getItemunit());

                    i.putExtra("onecartoonprice", imageModelArrayList.get(position).allitm.getOnecartoonprice().toString());
                    i.putExtra("onecartoonquantity", imageModelArrayList.get(position).allitm.getOnecartoonquantity().toString());
                    i.putExtra("onecartoonunit", imageModelArrayList.get(position).allitm.getOnecartoonunit());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }

                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Only_Bag")){
                    Intent i=new Intent(ctx,OnlyBag.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());

                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("onebagprice", imageModelArrayList.get(position).allitm.getOnebagprice().toString());
                    i.putExtra("onebagweight", imageModelArrayList.get(position).allitm.getOnebagquantity());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }

                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("BagKg")){
                    Intent i=new Intent(ctx,Bagkg.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());
                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("itemprice", imageModelArrayList.get(position).allitm.getItempriceperkg().toString());

                    i.putExtra("onebagprice", imageModelArrayList.get(position).allitm.getOnebagprice().toString());
                    i.putExtra("onebagweight", imageModelArrayList.get(position).allitm.getOnebagquantity());
                    i.putExtra("onebagunit", imageModelArrayList.get(position).allitm.getOnebagunit());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }

            }
        });

        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {






                if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Only_Cartoon")) {
                    Intent i=new Intent(ctx,OnlyCartoon.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());

                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("onecartoonprice", imageModelArrayList.get(position).allitm.getOnecartoonprice().toString());
                    i.putExtra("onecartoonweight", imageModelArrayList.get(position).allitm.getOnecartoonweight().toString());
                    i.putExtra("onecartoonunit", imageModelArrayList.get(position).allitm.getOnecartoonunit().toString());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }
                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Cartton-lari-pices")){
                    Intent i=new Intent(ctx,CartoonLariPice.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());
                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("itempriceperpices", imageModelArrayList.get(position).allitm.getItempriceperpice().toString());
                    i.putExtra("itemweight", imageModelArrayList.get(position).allitm.getItemweight().toString());
                    i.putExtra("itemunit", imageModelArrayList.get(position).allitm.getItemunit());

                    i.putExtra("onelariprice", imageModelArrayList.get(position).allitm.getOnelariprice().toString());
                    i.putExtra("onelariquantity", imageModelArrayList.get(position).allitm.getOnelariquantity().toString());
                    i.putExtra("onelariunit", imageModelArrayList.get(position).allitm.getOnelariunit());

                    i.putExtra("onecartoonprice", imageModelArrayList.get(position).allitm.getOnecartoonprice().toString());
                    i.putExtra("onecartoonquantity", imageModelArrayList.get(position).allitm.getOnecartoonquantity().toString());
                    i.putExtra("onecartoonunit", imageModelArrayList.get(position).allitm.getOnecartoonunit());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }
                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Cartton-Box-pices")){
                    Intent i=new Intent(ctx,CartoonBoxPice.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());
                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("itempriceperpices", imageModelArrayList.get(position).allitm.getItempriceperpice().toString());
                    i.putExtra("itemweight", imageModelArrayList.get(position).allitm.getItemweight().toString());
                    i.putExtra("itemunit", imageModelArrayList.get(position).allitm.getItemunit());

                    i.putExtra("oneboxprice", imageModelArrayList.get(position).allitm.getOneboxprice().toString());
                    i.putExtra("oneboxquantity", imageModelArrayList.get(position).allitm.getOneboxquantity().toString());
                    i.putExtra("oneboxunit", imageModelArrayList.get(position).allitm.getOneboxunit());

                    i.putExtra("onecartoonprice", imageModelArrayList.get(position).allitm.getOnecartoonprice().toString());
                    i.putExtra("onecartoonquantity", imageModelArrayList.get(position).allitm.getOnecartoonquantity().toString());
                    i.putExtra("onecartoonunit", imageModelArrayList.get(position).allitm.getOnecartoonunit());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }

                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Cartoon_pices")){
                    Intent i=new Intent(ctx,Cartoonpices.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());

                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("itempriceperpices", imageModelArrayList.get(position).allitm.getItempriceperpice().toString());
                    i.putExtra("itemweight", imageModelArrayList.get(position).allitm.getItemweight().toString());
                    i.putExtra("itemunit", imageModelArrayList.get(position).allitm.getItemunit());

                    i.putExtra("onecartoonprice", imageModelArrayList.get(position).allitm.getOnecartoonprice().toString());
                    i.putExtra("onecartoonquantity", imageModelArrayList.get(position).allitm.getOnecartoonquantity().toString());
                    i.putExtra("onecartoonunit", imageModelArrayList.get(position).allitm.getOnecartoonunit());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }

                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("Only_Bag")){
                    Intent i=new Intent(ctx,OnlyBag.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());

                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("onebagprice", imageModelArrayList.get(position).allitm.getOnebagprice().toString());
                    i.putExtra("onebagweight", imageModelArrayList.get(position).allitm.getOnebagquantity());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }

                else if((imageModelArrayList.get(position).allitm.getItemCategory().trim()).equals("BagKg")){
                    Intent i=new Intent(ctx,Bagkg.class);

                    i.putExtra("image", imageModelArrayList.get(position).allitm.getItemimageurl().toString());
                    i.putExtra("brandname", imageModelArrayList.get(position).allitm.getBrandname().toString());
                    i.putExtra("itemname", imageModelArrayList.get(position).allitm.getItemname().toString());
                    i.putExtra("itemprice", imageModelArrayList.get(position).allitm.getItempriceperkg().toString());

                    i.putExtra("itemcategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.putExtra("itemid11", imageModelArrayList.get(position).allitm.getItemid().toString());
                    i.putExtra("onebagprice", imageModelArrayList.get(position).allitm.getOnebagprice().toString());
                    i.putExtra("onebagweight", imageModelArrayList.get(position).allitm.getOnebagquantity());
                    i.putExtra("onebagunit", imageModelArrayList.get(position).allitm.getOnebagunit());

                    i.putExtra("itemdescription", imageModelArrayList.get(position).allitm.getItemdescription().toString());
                    i.putExtra("itemCategory", imageModelArrayList.get(position).allitm.getItemCategory().toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin",imageModelArrayList.get(position).getPincode());
                    ctx.startActivity(i);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }





    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        SearchItem.allitms.clear();
        if (charText.length() == 0) {
            SearchItem.allitms.addAll(arraylist);
        } else {
            for (Listpincode wp : arraylist) {
                if (wp.allitm.getItemname().toLowerCase(Locale.getDefault()).contains(charText)) {
                    SearchItem.allitms.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}

