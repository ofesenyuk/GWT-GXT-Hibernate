/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.mycompany.gwthibernate.client.ProjectEntryPoint;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OFesenyuk
 */
public class GreetingViewImpl extends Composite implements GreetingView {
    
    private static final GreetingViewImplUiBinder uiBinder 
            = GWT.create(GreetingViewImplUiBinder.class);
//    private MyServiceAsync myServiceAsync
//            = (MyServiceAsync) GWT.create(MyService.class);            
    String actualGreet;

    interface GreetingViewImplUiBinder 
        extends UiBinder<Widget, GreetingViewImpl> {
    }

    SimplePanel viewPanel = new SimplePanel();
    @UiField
    Label greetingMessage;
    @UiField
    Anchor logOutAnchor;

    public GreetingViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        String url = ProjectEntryPoint.APPLICATION_BASE_URL;
        String host = ProjectEntryPoint.HOST_PORT;
        String redirect = ProjectEntryPoint.APPLICATION_BASE_URL
                .split(host)[1];
        logOutAnchor.setHref(redirect);
    }

    @Override
    public void setMessage(String message) {
//        try {
//            greetingMessage.setText(new String(message.getBytes("UTF-8"), 
//                    "ISO-8859-1"));
            greetingMessage.setText(message);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(GreetingViewImpl.class.getName()).log(Level.SEVERE, null, ex);
//            greetingMessage.setText(message);
//            System.err.println("Exception: " + ex.getMessage());
//        }
        greetingMessage.setTitle("message: " + message);
    }
}
