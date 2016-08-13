/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sf
 */
public class GreetingFactory {
    private final SortedMap<Date, String> moments = new TreeMap<>(); 
    private final SimpleDateFormat formatter 
            = new SimpleDateFormat("HH:mm:ss");
    private Date localTime = new Date();

    public GreetingFactory() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        moments.put(calendar.getTime(), "good.morning");
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        moments.put(calendar.getTime(), "good.day");
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        moments.put(calendar.getTime(), "good.evening");
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        moments.put(calendar.getTime(), "good.night");
    }
    
    public String generateActualMessage(ResourceBundle messages) {
        if (moments.isEmpty()) {
            return messages.getString("good.day");
        }
        SortedMap<Date, String> headMap = moments.headMap(localTime);
        Date messageKey = headMap.isEmpty() ? moments.lastKey()
                : headMap.lastKey();
        String message = moments.get(messageKey);        
        return messages.getString(message);
    }

    public void setLocalTime(Date localTime) {
        this.localTime = localTime;
    }
}
