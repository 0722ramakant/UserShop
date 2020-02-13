package com.example.usershop;

/**
 * Created by Amisha on 22-02-2019.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by csa on 3/7/2017.
 */

public class RecyclerAdapterAddtocart extends RecyclerView.Adapter<RecyclerAdapterAddtocart.MyHolder> {

    List<Addtocartitem> list;
    Context context;
    Addtocartitem mylist;

    public RecyclerAdapterAddtocart(List<Addtocartitem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.addtocart,parent,false);
        MyHolder myHolder = new MyHolder(view);



        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {


        mylist = list.get(position);

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mylist = list.get(position);


                AddtocartDB addtocartDB=new AddtocartDB(context);
                addtocartDB.deleteItem(mylist.getItemid());
                mylist = list.get(position);
                Intent intent=new Intent(context,MyCart.class);
                context.startActivity(intent);

            }
        });


        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mylist = list.get(position);


                if(mylist.getItemCategory().trim().equals("Only_Cartoon"))
                {
                    Intent i=new Intent(context,OnlyCartoon.class);
                    i.putExtra("image", mylist.getItemimageurl());
                    i.putExtra("brandname", mylist.getBrandname());
                    i.putExtra("itemname", mylist.getItemname());

                    i.putExtra("itemcategory",mylist.getItemCategory());
                    i.putExtra("itemid11", mylist.getItemid());
                    i.putExtra("onecartoonprice", mylist.getOnecartoonprice());
                    i.putExtra("onecartoonweight",mylist.getOnecartoonquantity());
                    i.putExtra("onecartoonunit",mylist.getOnecartoonunit());

                    i.putExtra("itemdescription",mylist.getItemdescription());
                    i.putExtra("itemCategory",mylist.getItemCategory());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin","");
                    context.startActivity(i);


                }else if(mylist.getItemCategory().trim().equals("Cartton-lari-pices"))
                {
                    Intent i=new Intent(context,CartoonLariPice.class);
                    i.putExtra("image", mylist.getItemimageurl());
                    i.putExtra("brandname", mylist.getBrandname());
                    i.putExtra("itemname", mylist.getItemname());
                    i.putExtra("itemcategory", mylist.getItemCategory());
                    i.putExtra("itemid11",mylist.getItemid());
                    i.putExtra("itempriceperpices", mylist.getItempriceperpice());
                    i.putExtra("itemweight", mylist.getItemweight());
                    i.putExtra("itemunit", mylist.getItemunit());

                    i.putExtra("onelariprice", mylist.getOnelariprice());
                    i.putExtra("onelariquantity",mylist.getOnelariquantity());
                    i.putExtra("onelariunit",mylist.getOnelariunit());

                    i.putExtra("onecartoonprice", mylist.getOnecartoonprice());
                    i.putExtra("onecartoonquantity", mylist.getOnecartoonquantity());
                    i.putExtra("onecartoonunit",mylist.getOnecartoonunit());

                    i.putExtra("itemdescription", mylist.getItemdescription());
                    i.putExtra("itemCategory", mylist.getItemCategory());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin","");

                    context.startActivity(i);
                }
                else if(mylist.getItemCategory().trim().equals("Cartton-Box-pices"))
                {
                    Intent i=new Intent(context,CartoonBoxPice.class);

                    i.putExtra("image", mylist.getItemimageurl());
                    i.putExtra("itemcategory", mylist.getItemCategory());
                    i.putExtra("itemid11", mylist.getItemid());
                    i.putExtra("brandname", mylist.getBrandname());
                    i.putExtra("itemname", mylist.getItemname());

                    i.putExtra("itempriceperpices",mylist.getItempriceperpice());
                    i.putExtra("itemweight", mylist.getItemweight());
                    i.putExtra("itemunit", mylist.getItemunit());

                    i.putExtra("oneboxprice",mylist.getOneboxprice());
                    i.putExtra("oneboxquantity", mylist.getOnebagquantity());
                    i.putExtra("oneboxunit",mylist.getOneboxunit());

                    i.putExtra("onecartoonprice",mylist.getOnecartoonprice());
                    i.putExtra("onecartoonquantity", mylist.getOnecartoonquantity());
                    i.putExtra("onecartoonunit", mylist.getOnecartoonunit());

                    i.putExtra("itemdescription",mylist.getItemdescription());

                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin","");
                    context.startActivity(i);
                }
                else if(mylist.getItemCategory().trim().equals("Cartoon_pices"))
                {

                    Intent i=new Intent(context,Cartoonpices.class);

                    i.putExtra("image", mylist.getItemimageurl());
                    i.putExtra("brandname", mylist.getBrandname());
                    i.putExtra("itemname",mylist.getItemname());

                    i.putExtra("itemcategory", mylist.getItemCategory());
                    i.putExtra("itemid11", mylist.getItemid());
                    i.putExtra("itempriceperpices", mylist.getItempriceperpice());
                    i.putExtra("itemweight", mylist.getItemweight());
                    i.putExtra("itemunit", mylist.getItemunit());

                    i.putExtra("onecartoonprice",mylist.getOnecartoonprice());
                    i.putExtra("onecartoonquantity", mylist.getOnecartoonquantity());
                    i.putExtra("onecartoonunit", mylist.getOnecartoonunit());

                    i.putExtra("itemdescription",mylist.getItemdescription());

                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin","");
                    context.startActivity(i);



                }
                else if(mylist.getItemCategory().trim().equals("Only_Bag"))
                {
                    Intent i=new Intent(context,OnlyBag.class);

                    i.putExtra("image", mylist.getItemimageurl());
                    i.putExtra("brandname",mylist.getBrandname());
                    i.putExtra("itemname", mylist.getItemname());

                    i.putExtra("itemcategory",mylist.getItemCategory());
                    i.putExtra("itemid11", mylist.getItemid());
                    i.putExtra("onebagprice", mylist.getOnebagprice());
                    i.putExtra("onebagweight",mylist.getOnebagweight());

                    i.putExtra("itemdescription",mylist.getItemdescription());

                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin","");
                    context.startActivity(i);


                }
                else if(mylist.getItemCategory().trim().equals("BagKg"))
                {
                    Intent i=new Intent(context,Bagkg.class);

                    i.putExtra("image", mylist.getItemimageurl());
                    i.putExtra("brandname", mylist.getBrandname());
                    i.putExtra("itemname", mylist.getItemname());
                    i.putExtra("itemcategory", mylist.getItemCategory());
                    i.putExtra("itemid11", mylist.getItemid());
                    i.putExtra("itemprice",mylist.getItempriceperkg());
                    i.putExtra("onebagprice", mylist.getOnebagprice());
                    i.putExtra("onebagweight",mylist.getOnebagquantity());
                    i.putExtra("onebagunit",mylist.getOnebagunit());
                    i.putExtra("itemdescription", mylist.getItemdescription());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("pin","");
                    context.startActivity(i);

                }

            }
        });


        if(mylist.getItemCategory().trim().equals("Only_Cartoon"))
        {
            holder.Name.setText(mylist.getItemname());
            holder.Brand.setText(mylist.getBrandname());
            holder.Noofbox.setText(mylist.getNoofbox_pices_kg()+"  cartoon");
            holder.noofprice.setText("₹ "+mylist.getNoofbox_pices_kg_price());
           // holder.noofcartoon.setText(mylist.getNoof_bag_cartoon()+"  cartoon");
            //holder.noofcartoonprice.setText("₹ "+mylist.getNoof_bag_cartoon_price());
            holder.totalprice.setText("₹ "+mylist.getTotalprice());
            holder.cartitemprice.setText("₹ "+mylist.getOnecartoonprice());
            holder.cartitemweight.setText(mylist.getOnecartoonquantity()+" Kg");
            Picasso.with(context).load(mylist.getItemimageurl()).into(holder.Imageurl);

        }else if(mylist.getItemCategory().trim().equals("Cartton-lari-pices"))
        {
            holder.Name.setText(mylist.getItemname());
            holder.Brand.setText(mylist.getBrandname());
            holder.Noofbox.setText(mylist.getNoofbox_pices_kg()+"  lari");
            holder.noofprice.setText("₹ "+mylist.getNoofbox_pices_kg_price());
             holder.noofcartoon.setText(mylist.getNoof_bag_cartoon()+"  cartoon");
            holder.noofcartoonprice.setText("₹ "+mylist.getNoof_bag_cartoon_price());
            holder.totalprice.setText("₹ "+mylist.getTotalprice());
            holder.cartitemprice.setText("₹ "+mylist.getItempriceperpice());
            holder.cartitemweight.setText(mylist.getItemweight()+" gm");
            Picasso.with(context).load(mylist.getItemimageurl()).into(holder.Imageurl);
        }
        else if(mylist.getItemCategory().trim().equals("Cartton-Box-pices"))
        {
            holder.Name.setText(mylist.getItemname());
            holder.Brand.setText(mylist.getBrandname());
            holder.Noofbox.setText(mylist.getNoofbox_pices_kg()+"  Box");
            holder.noofprice.setText("₹ "+mylist.getNoofbox_pices_kg_price());
            holder.noofcartoon.setText(mylist.getNoof_bag_cartoon()+"  cartoon");
            holder.noofcartoonprice.setText("₹ "+mylist.getNoof_bag_cartoon_price());
            holder.totalprice.setText("₹ "+mylist.getTotalprice());
            holder.cartitemprice.setText("₹ "+mylist.getItempriceperpice());
            holder.cartitemweight.setText(mylist.getItemweight()+" gm");
            Picasso.with(context).load(mylist.getItemimageurl()).into(holder.Imageurl);

        }
        else if(mylist.getItemCategory().trim().equals("Cartoon_pices"))
        {

            holder.Name.setText(mylist.getItemname());
            holder.Brand.setText(mylist.getBrandname());
            holder.Noofbox.setText(mylist.getNoofbox_pices_kg()+"  Pices");
            holder.noofprice.setText("₹ "+mylist.getNoofbox_pices_kg_price());
            holder.noofcartoon.setText(mylist.getNoof_bag_cartoon()+"  cartoon");
            holder.noofcartoonprice.setText("₹ "+mylist.getNoof_bag_cartoon_price());
            holder.totalprice.setText("₹ "+mylist.getTotalprice());
            holder.cartitemprice.setText("₹ "+mylist.getItempriceperpice());
            holder.cartitemweight.setText(mylist.getItemweight()+" Kg");
            Picasso.with(context).load(mylist.getItemimageurl()).into(holder.Imageurl);

        }
        else if(mylist.getItemCategory().trim().equals("Only_Bag"))
        {
            holder.Name.setText(mylist.getItemname());
            holder.Brand.setText(mylist.getBrandname());
            holder.Noofbox.setText(mylist.getNoofbox_pices_kg()+"  bag");
            holder.noofprice.setText("₹ "+mylist.getNoofbox_pices_kg_price());
            // holder.noofcartoon.setText(mylist.getNoof_bag_cartoon()+"  cartoon");
            //holder.noofcartoonprice.setText("₹ "+mylist.getNoof_bag_cartoon_price());
            holder.totalprice.setText("₹ "+mylist.getTotalprice());
            holder.cartitemprice.setText("₹ "+mylist.getOnebagprice());
            holder.cartitemweight.setText(mylist.getOnebagweight()+" kg");
            Picasso.with(context).load(mylist.getItemimageurl()).into(holder.Imageurl);



        }
        else if(mylist.getItemCategory().trim().equals("BagKg"))
        {


            holder.Name.setText(mylist.getItemname());
            holder.Brand.setText(mylist.getBrandname());
            holder.Noofbox.setText(mylist.getNoofbox_pices_kg()+"  Kg");
            holder.noofprice.setText("₹ "+mylist.getNoofbox_pices_kg_price());
            holder.noofcartoon.setText(mylist.getNoof_bag_cartoon()+"  bag");
            holder.noofcartoonprice.setText("₹ "+mylist.getNoof_bag_cartoon_price());
            holder.totalprice.setText("₹ "+mylist.getTotalprice());
            holder.cartitemprice.setText("₹ "+mylist.getItempriceperkg());
            holder.cartitemweight.setText("1 Kg");
            Picasso.with(context).load(mylist.getItemimageurl()).into(holder.Imageurl);
        }




    }

    @Override
    public int getItemCount() {

        int arr = 0;

        try{
            if(list.size()==0){

                arr = 0;

            }
            else{

                arr=list.size();
            }



        }catch (Exception e){



        }

        return arr;

    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Name,Brand,Noofbox,noofprice,noofcartoon,noofcartoonprice,totalprice,cartitemprice,cartitemweight,remove;
        ImageView Imageurl;
        LinearLayout cart;


        public MyHolder(View itemView) {
            super(itemView);
            Imageurl=itemView.findViewById(R.id.imgaeurl);
            remove=itemView.findViewById(R.id.remove);
            cart=itemView.findViewById(R.id.cart);
            Name = (TextView) itemView.findViewById(R.id.cartitemname);
            Brand = (TextView) itemView.findViewById(R.id.cartbrandname);
            cartitemprice = (TextView) itemView.findViewById(R.id.cartitemprice);
            cartitemweight = (TextView) itemView.findViewById(R.id.cartitemweight);
            Noofbox= (TextView) itemView.findViewById(R.id.noof_pices_box_lari_kg);
            noofprice= (TextView) itemView.findViewById(R.id.noof_pices_box_lari_kg_price);
            noofcartoon= (TextView) itemView.findViewById(R.id.noofcartoon_bag);
            noofcartoonprice= (TextView) itemView.findViewById(R.id.noofcartoon_bag_price);
            totalprice= (TextView) itemView.findViewById(R.id.total);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
