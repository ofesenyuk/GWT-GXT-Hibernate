/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mycompany.gwthibernate.shared.UserGWT;

/**
 *
 * @author OFesenyuk
 */
@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
    public UserGWT getUser(String userName, String password, String country);
//    public String getActualLocalGreeting(String country);
}
