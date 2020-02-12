package com.datang.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d1 = sdf.parse("2019-12-31 23:59:59");
        System.out.println(d1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        Date d2 = sdf2.parse("2019-12-31 23:59:59");
        System.out.println(d2);

        SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY-MM-DD");
        Date d3 = sdf3.parse("2020-01-01");
        System.out.println(d3);

    }
}
