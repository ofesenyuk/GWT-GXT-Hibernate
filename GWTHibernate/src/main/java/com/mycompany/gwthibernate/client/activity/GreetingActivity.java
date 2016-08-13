/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mycompany.gwthibernate.client.ClientFactory;
import com.mycompany.gwthibernate.client.place.GreetingPlace;
import com.mycompany.gwthibernate.client.ui.GreetingView;

/**
 *
 * @author OFesenyuk
 */
public class GreetingActivity extends AbstractActivity {
    
    private final ClientFactory clientFactory;
    private final String message;

    public GreetingActivity(GreetingPlace place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.message = place.getMessage();
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        GreetingView greetingView = clientFactory.getGreetingView();
        greetingView.setMessage(message);
        containerWidget.setWidget(greetingView.asWidget());
    }
    
}
