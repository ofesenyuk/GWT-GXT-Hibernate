/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 *
 * @author OFesenyuk
 */
public class RegistrationPlace extends Place {
    private final String userName;

    public RegistrationPlace(String token) {
        this.userName = token;
    }

    public String getUserName() {
        return userName;
    }
    
    public static class Tokenizer implements PlaceTokenizer<RegistrationPlace> {

        @Override
        public RegistrationPlace getPlace(String token) {
            return new RegistrationPlace(token);
        }

        @Override
        public String getToken(RegistrationPlace place) {
            return place.getUserName();
        }
        
    }
}
