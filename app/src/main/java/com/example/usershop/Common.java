package com.example.usershop;

public class Common {

    public static String convertCodeToStatus(String code){
        if (code.equals("0"))
            return "Placed";
       else if (code.equals("1"))
            return "on My Way";
       else
           return "shipped";

    }

}
