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
public class GreetingPlace extends Place {
    private String message;
    private String viewName;

    public GreetingPlace(String token) {
        this.message = token;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    
    public static class Tokenizer implements PlaceTokenizer<GreetingPlace> {

        @Override
        public GreetingPlace getPlace(String token) {
            return new GreetingPlace(token);
        }

        @Override
        public String getToken(GreetingPlace place) {
            return place.getViewName();
        }
        
    }
}
