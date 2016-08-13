/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mycompany.gwthibernate.client.ClientFactory;
import com.mycompany.gwthibernate.client.place.RegistrationPlace;
import com.mycompany.gwthibernate.client.ui.RegistrationView;

/**
 *
 * @author OFesenyuk
 */
public class RegistrationActivity extends AbstractActivity implements
        RegistrationView.Presenter {
    
    private final ClientFactory clientFactory;
    private final String name;

    public RegistrationActivity(RegistrationPlace place, 
            ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.name = place.getUserName();
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        RegistrationView registrationView = clientFactory.getRegistrationView();
        registrationView.setName(name);
        registrationView.setPresenter(this);
        containerWidget.setWidget(registrationView.asWidget());
    }

    @Override
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
    
}
