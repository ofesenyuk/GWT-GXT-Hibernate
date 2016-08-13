/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.mycompany.gwthibernate.client.ClientFactory;
import com.mycompany.gwthibernate.client.activity.GreetingActivity;
import com.mycompany.gwthibernate.client.activity.RegistrationActivity;
import com.mycompany.gwthibernate.client.place.GreetingPlace;
import com.mycompany.gwthibernate.client.place.RegistrationPlace;

/**
 *
 * @author OFesenyuk
 */
public class AppActivityMapper implements ActivityMapper {

    private final ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }
    
    @Override
    public Activity getActivity(Place place) {
        if (place instanceof RegistrationPlace) {
            return new RegistrationActivity((RegistrationPlace) place, clientFactory);
        } else if (place instanceof GreetingPlace) {
            return new GreetingActivity((GreetingPlace) place, clientFactory);
        }

        return null;
    }
    
}
