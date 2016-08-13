package com.mycompany.gwthibernate.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.RequestTimeoutException;
import com.google.gwt.http.client.Response;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mycompany.gwthibernate.client.mvp.AppActivityMapper;
import com.mycompany.gwthibernate.client.mvp.AppPlaceHistoryMapper;
import com.mycompany.gwthibernate.client.place.RegistrationPlace;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProjectEntryPoint implements EntryPoint {
    public static final int STATUS_CODE_OK = 200;
    private final static String LOCALE_DEF_URL = "http://ipinfo.io";
    private static final Logger logger 
            = Logger.getLogger(ProjectEntryPoint.class.getName());
    public static String IRREGULAR_CREDENTIALS = "irregular.credentials";
    public static String HOST_PORT;
    public static String APPLICATION_BASE_URL;
        
    private final Place defaultPlace = new RegistrationPlace("");
    private final SimplePanel appWidget = new SimplePanel();

    @Override
    public void onModuleLoad() {
        HOST_PORT = Window.Location.getHost();
        APPLICATION_BASE_URL = Window.Location.getHref();
        logger.info("PORT: " + HOST_PORT + " url: " + APPLICATION_BASE_URL);
        defineLocaleSettings();
        
        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);
        historyHandler.handleCurrentHistory();
        RootPanel.get().add(appWidget);
  }

    private void defineLocaleSettings() {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
                LOCALE_DEF_URL);
        try {
            Request response = builder.sendRequest(null, new RequestCallback() {
                @Override
                public void onError(Request request, Throwable exception) {
                    if (exception instanceof RequestTimeoutException) {
                        Window.alert("The request has timed out");
                        logger.log(Level.WARNING, 
                                "Exception at locale determination: "
                                + "the request has timed out");
                    } else {
                        Window.alert("exception.getMessage: " 
                                + exception.getMessage());
                        logger.log(Level.WARNING, 
                                "Exception at locale determination: " 
                                + exception.getMessage());
                    }
                }

                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (STATUS_CODE_OK == response.getStatusCode()) {
                        String textToParse = response.getText();
                        String country = textToParse.split("request")[1]
                                .split("country")[1]
                                .replace("&quot;", "").split(",")[0]
                                .replace(":", "").trim();
//                                .split(",")[0].replaceAll("[:\"]", "");
//                        Window.alert("country " + country);
                        logger.log(Level.WARNING, "Country is determined as " 
                                + country);
                        LocationSingleton.getInstance().setCountry(country);
                    } else {
//                        Window.alert("response " + response.getStatusCode());
                        logger.log(Level.WARNING, "Country is not determined "
                                + "because of response status " 
                                + response.getStatusCode());
                    }
                }
            });
        } catch (RequestException e) {
            // Code omitted for clarity
//            Window.alert(e.getMessage());
            GWT.log("Country is not determined because of exception "
                                + e.getMessage());
        }
    }
  
}
