/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.mycompany.gwthibernate.client.ui.GreetingView;
import com.mycompany.gwthibernate.client.ui.GreetingViewImpl;
import com.mycompany.gwthibernate.client.ui.RegistrationView;
import com.mycompany.gwthibernate.client.ui.RegistrationViewImpl;

/**
 *
 * @author OFesenyuk
 */
public class ClientFactoryImpl implements ClientFactory {

    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    private final RegistrationView registrationView = new RegistrationViewImpl();
    private final GreetingView greetingView = new GreetingViewImpl();

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public RegistrationView getRegistrationView() {
        return registrationView;
    }

    @Override
    public GreetingView getGreetingView() {
        return greetingView;
    }
}
