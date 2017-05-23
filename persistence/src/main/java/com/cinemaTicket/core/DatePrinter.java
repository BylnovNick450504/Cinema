package com.cinemaTicket.core;


import java.util.Date;

public class DatePrinter {

    public DatePrinter() {
    }

    public static String convertMinHourDayMonth(int digit) {
        if(digit < 10) {
            return "0" + digit;
        }
        return "" + digit;
    }

    public static String convertYear(int digit) {
        return "20" + digit % 100;
    }

    public static String  printDayMonthYear(Date date) {
        return "" + convertMinHourDayMonth(date.getDay()) + "." +
                    convertMinHourDayMonth(date.getMonth()) + "." +
                    convertYear(date.getYear());
    }

    public static String  printHourMin(Date date) {
        return "" + convertMinHourDayMonth(date.getHours()) + ":" +
                convertMinHourDayMonth(date.getMinutes());
    }

    public static Date convertToDate(String s) {
        return new Date();
    }
}
