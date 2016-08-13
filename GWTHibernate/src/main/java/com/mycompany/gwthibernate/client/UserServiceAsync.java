/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mycompany.gwthibernate.shared.UserGWT;

/**
 *
 * @author OFesenyuk
 */
public interface UserServiceAsync {
    public void getUser(String userName, String password, String country,
            AsyncCallback<UserGWT> callback);
//    public void getActualLocalGreeting(String country, 
//            AsyncCallback<String> callback);
}
