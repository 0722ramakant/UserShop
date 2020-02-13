package com.example.usershop;

import java.io.Serializable;

public class Addtocartitem implements Serializable {

    private String itemname;
    private String itemid;
    private String brandname;
    private String itemimageurl;
    private String itemdescription;
    private String onelariprice;
    private String onelariquantity;
    private String onelariunit;
    private String onecartoonprice;
    private String onecartoonquantity;
    private String onecartoonunit;
    private String onecartoonweight;
    private String oneboxprice;
    private String oneboxquantity;
    private String oneboxunit;
    private String onebagprice;
    private String onebagquantity;
    private String onebagweight;
    private String onebagunit;
    private String itempriceperkg;
    private String itempriceperpice;
    private String itemweight;
    private String itemunit;
    private String itemCategory;
    private String itemquantity;
    private String noofbox_pices_kg;
    private String noof_bag_cartoon;
    private String noofbox_pices_kg_price;
    private String noof_bag_cartoon_price;
    private String totalprice;



   // String itemname,itemid,brandname,itemimageurl,itemdescription,onelariprice,onelariquantity, onelariunit, onecartoonprice, onecartoonquantity, onecartoonunit,onecartoonweight, oneboxprice,oneboxquantity,oneboxunit,onebagprice,onebagquantity,onebagweight,onebagunit,itempriceperkg,itempriceperpice,itemweight, itemunit,itemCategory, itemquantity,noofbox_pices_kg, noof_bag_cartoon,totalprice


    public Addtocartitem() {
    }

    public Addtocartitem(String itemname, String itemid, String brandname, String itemimageurl, String itemdescription, String onelariprice, String onelariquantity, String onelariunit, String onecartoonprice, String onecartoonquantity, String onecartoonunit, String onecartoonweight, String oneboxprice, String oneboxquantity, String oneboxunit, String onebagprice, String onebagquantity, String onebagweight, String onebagunit, String itempriceperkg, String itempriceperpice, String itemweight, String itemunit, String itemCategory, String itemquantity, String noofbox_pices_kg, String noof_bag_cartoon, String noofbox_pices_kg_price, String noof_bag_cartoon_price, String totalprice) {
        this.itemname = itemname;
        this.itemid = itemid;
        this.brandname = brandname;
        this.itemimageurl = itemimageurl;
        this.itemdescription = itemdescription;
        this.onelariprice = onelariprice;
        this.onelariquantity = onelariquantity;
        this.onelariunit = onelariunit;
        this.onecartoonprice = onecartoonprice;
        this.onecartoonquantity = onecartoonquantity;
        this.onecartoonunit = onecartoonunit;
        this.onecartoonweight = onecartoonweight;
        this.oneboxprice = oneboxprice;
        this.oneboxquantity = oneboxquantity;
        this.oneboxunit = oneboxunit;
        this.onebagprice = onebagprice;
        this.onebagquantity = onebagquantity;
        this.onebagweight = onebagweight;
        this.onebagunit = onebagunit;
        this.itempriceperkg = itempriceperkg;
        this.itempriceperpice = itempriceperpice;
        this.itemweight = itemweight;
        this.itemunit = itemunit;
        this.itemCategory = itemCategory;
        this.itemquantity = itemquantity;
        this.noofbox_pices_kg = noofbox_pices_kg;
        this.noof_bag_cartoon = noof_bag_cartoon;
        this.noofbox_pices_kg_price = noofbox_pices_kg_price;
        this.noof_bag_cartoon_price = noof_bag_cartoon_price;
        this.totalprice = totalprice;
    }

    public String getItemname() {
        return itemname;
    }

    public String getItemid() {
        return itemid;
    }

    public String getBrandname() {
        return brandname;
    }

    public String getItemimageurl() {
        return itemimageurl;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public String getOnelariprice() {
        return onelariprice;
    }

    public String getOnelariquantity() {
        return onelariquantity;
    }

    public String getOnelariunit() {
        return onelariunit;
    }

    public String getOnecartoonprice() {
        return onecartoonprice;
    }

    public String getOnecartoonquantity() {
        return onecartoonquantity;
    }

    public String getOnecartoonunit() {
        return onecartoonunit;
    }

    public String getOnecartoonweight() {
        return onecartoonweight;
    }

    public String getOneboxprice() {
        return oneboxprice;
    }

    public String getOneboxquantity() {
        return oneboxquantity;
    }

    public String getOneboxunit() {
        return oneboxunit;
    }

    public String getOnebagprice() {
        return onebagprice;
    }

    public String getOnebagquantity() {
        return onebagquantity;
    }

    public String getOnebagweight() {
        return onebagweight;
    }

    public String getOnebagunit() {
        return onebagunit;
    }

    public String getItempriceperkg() {
        return itempriceperkg;
    }

    public String getItempriceperpice() {
        return itempriceperpice;
    }

    public String getItemweight() {
        return itemweight;
    }

    public String getItemunit() {
        return itemunit;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemquantity() {
        return itemquantity;
    }

    public String getNoofbox_pices_kg() {
        return noofbox_pices_kg;
    }

    public String getNoof_bag_cartoon() {
        return noof_bag_cartoon;
    }

    public String getNoofbox_pices_kg_price() {
        return noofbox_pices_kg_price;
    }

    public String getNoof_bag_cartoon_price() {
        return noof_bag_cartoon_price;
    }

    public String getTotalprice() {
        return totalprice;
    }
}
