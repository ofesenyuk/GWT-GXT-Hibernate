/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mycompany.gwthibernate.client.LocationSingleton;
import com.mycompany.gwthibernate.client.ProjectEntryPoint;
import com.mycompany.gwthibernate.client.UserService;
import com.mycompany.gwthibernate.client.UserServiceAsync;
import com.mycompany.gwthibernate.client.place.GreetingPlace;
import com.mycompany.gwthibernate.shared.UserGWT;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OFesenyuk
 */
public class RegistrationViewImpl extends Composite 
    implements RegistrationView {
    
    private final GreetingViewImplUiBinder uiBinder 
            = GWT.create(GreetingViewImplUiBinder.class);
    private final Logger logger 
            = Logger.getLogger(ProjectEntryPoint.class.getName());
    private final UserServiceAsync userServiceAsync 
            = (UserServiceAsync) GWT.create(UserService.class);

    interface GreetingViewImplUiBinder 
        extends UiBinder<Widget, RegistrationViewImpl> {
    }
    
    @UiField
    Button buttonSubmit;
    @UiField
    Label errorMessage;
    @UiField
    TextBox loginBox;
    @UiField
    PasswordTextBox passwordBox;
    private Presenter listener;

    public RegistrationViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @Override
    public void setName(String greetingName) {
        buttonSubmit.setTitle(greetingName);
    }

    @Override
    public void setPresenter(Presenter listener) {
        this.listener = listener;
    }
    
    @UiHandler("buttonSubmit")
    void onClickButton(ClickEvent evt) {
        retrieveLocalName(loginBox.getText(), passwordBox.getText(),
                LocationSingleton.getInstance().getCountry());
    }

    private void retrieveLocalName(String userName, String password,
            String country) {
        userServiceAsync.getUser(userName, password, country, 
                new AsyncCallback<UserGWT>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new RuntimeException(caught);
            }

            @Override
            public void onSuccess(UserGWT userGWT) {
                String greeting = userGWT.getGreeting();
                String head = ProjectEntryPoint.IRREGULAR_CREDENTIALS;
                logger.log(Level.INFO, "greeting: " + greeting);
                if (greeting.trim().startsWith(head)) {
                    errorMessage.setText(greeting.replace(head, "").trim());
                    throw new RuntimeException(head);
                } else {
                    GreetingPlace greetingPlace
                            = new GreetingPlace(userGWT.getName());
                    greetingPlace.setMessage(greeting);
                    greetingPlace.setViewName(userGWT.getName());
                    listener.goTo(greetingPlace);
                }
            }
        });
    }
}
