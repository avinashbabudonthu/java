package com.junit4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    public static void main(String[] args) {
        String format = "HHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String result = simpleDateFormat.format(date);
        System.out.println(result);
    }

}