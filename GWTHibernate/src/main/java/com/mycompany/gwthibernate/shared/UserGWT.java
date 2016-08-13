/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 *
 * @author OFesenyuk
 */
public class UserGWT implements IsSerializable {
    private String name;
    private String greeting;

    public UserGWT(String name, String greeting) {
        this.name = name;
        this.greeting = greeting;
    }

    public UserGWT() {
    }

    public String getName() {
        return name;
    }

    public String getGreeting() {
        return greeting;
    }
}
