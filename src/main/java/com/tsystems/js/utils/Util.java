package com.tsystems.js.utils;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kull on 30.08.16.
 */
public class Util {

    public static Time getTime(String timeString){
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        try {
            return new Time(formatter.parse(timeString).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getDate(String date){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(date);
        }catch (ParseException e){
            return null;
        }
    }
}
