package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        //version 1
//        DateFormat dateFormatOne = new SimpleDateFormat("dd.MM.yyyy - E");
//        Calendar calendar1 = new GregorianCalendar(1991, Calendar.MARCH, 7);
//        int myAge = 29;
//        for (int i = 0; i < myAge + 1; i++) {
//            calendar1.set(Calendar.YEAR, 1991 + i);
//            System.out.println(i + " - " + dateFormatOne.format(calendar1.getTime()));
//        }

        //version 2
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E");
        Calendar calendar = Calendar.getInstance();
        int myAge = 29;
//        calendar.set(Calendar.DATE, 7);
//        calendar.set(Calendar.MONTH, 2);
//        calendar.set(Calendar.YEAR, 1991);
        calendar.set(1991, 2, 7);
        for (int i = 0; i < myAge + 1; i++) {
            calendar.set(Calendar.YEAR, 1991 + i);
            System.out.println(i + " - " + dateFormat.format(calendar.getTime()));
        }
    }
}
