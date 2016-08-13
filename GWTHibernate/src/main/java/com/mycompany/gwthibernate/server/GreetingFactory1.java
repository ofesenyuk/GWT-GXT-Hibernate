/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.server;

import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author sf
 */
public class GreetingFactory1 {
    private final static SortedMap<LocalTime, String> moments = new TreeMap<>(); 
    private LocalTime localTime = LocalTime.now();
    
    static {
        moments.put(LocalTime.parse("06:00:00"), "good.morning");
        moments.put(LocalTime.parse("09:00"), "good.day");
        moments.put(LocalTime.parse("19:00"), "good.evening");
        moments.put(LocalTime.parse("23:00"), "good.night");
    }
    
    public String generateActualMessage(ResourceBundle messages) {
        SortedMap<LocalTime, String> headMap = moments.headMap(localTime);
        LocalTime messageKey = headMap.isEmpty() ? moments.lastKey()
                : headMap.lastKey();
        String message = moments.get(messageKey);        
        return messages.getString(message);
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}
