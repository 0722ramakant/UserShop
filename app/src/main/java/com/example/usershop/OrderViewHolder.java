package com.example.usershop;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;


class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {


    public TextView txtorderid;
    public TextView txtordernumber;
    public TextView txttotal;
    public TextView txtorderstatus;


    private ItemClickListner itemClickListner;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        txtorderid=itemView.findViewById(R.id.orderid);
       txtorderstatus=itemView.findViewById(R.id.status);
        txtordernumber=itemView.findViewById(R.id.noOfItem);
        txttotal=itemView.findViewById(R.id.totalamount);


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


