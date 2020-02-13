package com.example.usershop;

import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Placeaddress{

    String currentTime, status,name,mobile_number,zipcode,shopname,roadname,city,state,landmark,paymentmode,noofitem,totalamoint;

    private List<Addtocartitem>   addtocartitem;

    public Placeaddress() {
    }

    public Placeaddress(String currentTime, String status, String name, String mobile_number, String zipcode, String shopname, String roadname, String city, String state, String landmark, String paymentmode, String noofitem, String totalamoint, List<Addtocartitem> addtocartitem) {
        this.currentTime = currentTime;
        this.status = status;
        this.name = name;
        this.mobile_number = mobile_number;
        this.zipcode = zipcode;
        this.shopname = shopname;
        this.roadname = roadname;
        this.city = city;
        this.state = state;
        this.landmark = landmark;
        this.paymentmode = paymentmode;
        this.noofitem = noofitem;
        this.totalamoint = totalamoint;
        this.addtocartitem = addtocartitem;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getRoadname() {
        return roadname;
    }

    public void setRoadname(String roadname) {
        this.roadname = roadname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public String getNoofitem() {
        return noofitem;
    }

    public void setNoofitem(String noofitem) {
        this.noofitem = noofitem;
    }

    public String getTotalamoint() {
        return totalamoint;
    }

    public void setTotalamoint(String totalamoint) {
        this.totalamoint = totalamoint;
    }

    public List<Addtocartitem> getAddtocartitem() {
        return addtocartitem;
    }

    public void setAddtocartitem(List<Addtocartitem> addtocartitem) {
        this.addtocartitem = addtocartitem;
    }
}
