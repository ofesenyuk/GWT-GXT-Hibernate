/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client;

/**
 *
 * @author OFesenyuk
 */
public class LocationSingleton {
    
    private String country;
    
    private LocationSingleton() {
    }
    
    public static LocationSingleton getInstance() {
        return LocationSingletonHolder.INSTANCE;
    }

    public String getCountry() {
        return country;
    }

    void setCountry(String country) {
        this.country = country;
    }
    
    private static class LocationSingletonHolder {

        private static final LocationSingleton INSTANCE = new LocationSingleton();
    }
}
