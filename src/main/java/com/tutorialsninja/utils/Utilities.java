package com.tutorialsninja.utils;

import java.util.Date;

public class Utilities {
    public static String generateEmailWithTimeStamp()
    {
        Date date = new Date();
        String dateStamp = date.toString().replace(" ","_").replace(":","_");
        return "tester"+dateStamp+"@gmail.com";
    }


}
