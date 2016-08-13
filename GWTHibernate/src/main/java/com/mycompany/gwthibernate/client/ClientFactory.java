/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.mycompany.gwthibernate.client.ui.GreetingView;
import com.mycompany.gwthibernate.client.ui.RegistrationView;

/**
 *
 * @author OFesenyuk
 */
public interface ClientFactory {
    
    EventBus getEventBus();

    PlaceController getPlaceController();

    RegistrationView getRegistrationView();

    GreetingView getGreetingView();
}
