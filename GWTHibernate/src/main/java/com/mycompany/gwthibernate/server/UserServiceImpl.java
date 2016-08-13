/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mycompany.gwthibernate.client.ProjectEntryPoint;
import com.mycompany.gwthibernate.client.UserService;
import com.mycompany.gwthibernate.shared.UserGWT;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author OFesenyuk
 */
public class UserServiceImpl extends RemoteServiceServlet 
        implements UserService {
    Session session = null;
    PasswordHash passwordHash = new PasswordHash();
    private final Map<String, Locale> localeNotations = new HashMap<>();

//    public UserServiceImpl() {
//        localeNotations.put("UA", new Locale("uk", "UA"));
//        localeNotations.put("RU", new Locale("ru", "RU"));
//        localeNotations.put("EN", Locale.US);
//    }
    
    public UserServiceImpl() {
        localeNotations.put("UA", new Locale("uk", "UA"));
        localeNotations.put("RU", new Locale("ru", "RU"));
        localeNotations.put("EN", Locale.US);
//        this();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String userName = "ivan";
            if (getUser(userName) == null) {
                List<LocalNames> localNames = new ArrayList<>();
                localNames.add(new LocalNames("Іван", "UA"));
                localNames.add(new LocalNames("Иван", "RU"));
                addUser("Ivan", userName, "secret", localNames);
            }
            userName = "john";
            if (getUser(userName) == null) {
                addUser("John", userName, "smith", null);
            }
            tx.commit();

        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
    
    @Override
    public UserGWT getUser(String userName, String password, String country) {
        ResourceBundle messages = createResourceBundle(country);
        UserData user = null;
        try {
            user = getValidUser(getUser(userName), password);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        String name = "";
        String loginMessage = ProjectEntryPoint.IRREGULAR_CREDENTIALS
                + messages.getString(ProjectEntryPoint.IRREGULAR_CREDENTIALS);
        if (null != user) {
            name = user.getName();
            for (LocalNames localName : user.getLocalNamesCollection()) {
                if (localName.getLocale().equalsIgnoreCase(country)) {
                    name = localName.getName();
                    break;
                }
            }
            loginMessage
                    = (new GreetingFactory()).generateActualMessage(messages)
                    + " " + name + "!";
        }
        UserGWT loggedInUser = new UserGWT(name, loginMessage);
        return loggedInUser;
    }

    private UserData getUser(String userName) {
        if (null == session || !session.isOpen()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        Query query = session.getNamedQuery("UserData.findAll");
        List<UserData> users = query.list();
        for (UserData u : users) {
            try {
                String hashedUsername = new String(u.getUserName());
                if (passwordHash.validatePassword(userName, hashedUsername)) {
                    return u;
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    private void addUser(String name, String userName, String password, 
            List<LocalNames> localNames) {
        try {
            String hashedUsername = passwordHash.createHash(userName);
            String hashedPassword = passwordHash.createHash(password);
            System.out.println("hashedUsername " + hashedUsername
                    + " hashedPassword " + hashedPassword);
            UserData user = new UserData(name, hashedUsername.getBytes(),
                    hashedPassword.getBytes(), localNames);
            session.save(user);
            if (null == localNames || localNames.isEmpty()) {
                return;
            }
            for (LocalNames localName : localNames) {
                localName.setUId(user);
                session.save(localName);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ResourceBundle createResourceBundle(String country) {
        Locale locale = localeNotations.get(country);
        if (null == locale) {
            locale = localeNotations.get("EN");
        }
        return ResourceBundle.getBundle("messages", locale);
    }

    private UserData getValidUser(UserData user, String password) {
        if (null == user) {
            return null;
        }
        try {
            String hashedPassword = new String(user.getPassword());
            if (passwordHash.validatePassword(password, hashedPassword)) {
                return user;
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }
    
}
