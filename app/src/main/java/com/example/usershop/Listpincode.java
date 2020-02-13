package com.example.usershop;

public class Listpincode {

    Allitm allitm;
    String pincode;

    public Listpincode() {
    }

    public Listpincode(Allitm allitm, String pincode) {
        this.allitm = allitm;
        this.pincode = pincode;
    }

    public Allitm getAllitm() {
        return allitm;
    }

    public String getPincode() {
        return pincode;
    }
}
