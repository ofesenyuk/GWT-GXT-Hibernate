/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.mycompany.gwthibernate.client.place.GreetingPlace;
import com.mycompany.gwthibernate.client.place.RegistrationPlace;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers({RegistrationPlace.Tokenizer.class, GreetingPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
