/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integration.tests.selenium;

import com.mycompany.gwthibernate.client.LocationSingleton;
import com.mycompany.gwthibernate.client.ProjectEntryPoint;
import static com.mycompany.gwthibernate.client.ProjectEntryPoint.APPLICATION_BASE_URL;
import com.mycompany.gwthibernate.server.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogoutTestUa {

    WebDriver wd;
    List<String> applicationBaseURLs = new ArrayList<>();
    private static final String TEXT_TO_TEST = "Добр";
                                              //"Good"
    private static final String TEXT1_TO_TEST = "Іван!";
                                              //"Ivan!"
    private static final String LOGOUT_TO_TEST = "Log out";
    private static final String LOGIN_TO_TEST = "Login";
    private static final String PASSWORD_TO_TEST = "Password";

    @Before
    public void setUp() throws Exception {
//        wd = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        wd = new ChromeDriver();
        wd.manage().timeouts()
                .implicitlyWait(IrregularCredentialsUA.WAIT_FOR_ARISING, 
                        TimeUnit.SECONDS);
        applicationBaseURLs.add("http://localhost:8080/GWTHibernate/");
        applicationBaseURLs.add("http://localhost:8084/gwthibernate/");
    }

    @Test
    public void LoginLogoutTestUa() {
        for (String url : applicationBaseURLs) {
            try {
                wd.get(url);
                wd.findElement(By.cssSelector("input.gwt-TextBox")).click();
                break;
            } catch (NoSuchElementException e) {
            }
        }
        IrregularCredentialsUA irregularCredentialsUA 
                = new IrregularCredentialsUA();
        irregularCredentialsUA.wd = wd;
        irregularCredentialsUA.waitForLocaleDetection();
        wd.manage().timeouts()
                .implicitlyWait(IrregularCredentialsUA.WAIT_FOR_ARISING,
                        TimeUnit.SECONDS);
        wd.findElement(By.cssSelector("input.gwt-TextBox")).click();
        wd.findElement(By.cssSelector("input.gwt-TextBox")).clear();
        wd.findElement(By.cssSelector("input.gwt-TextBox")).sendKeys("ivan");
        wd.findElement(By.cssSelector("input.gwt-PasswordTextBox")).click();
        wd.findElement(By.cssSelector("input.gwt-PasswordTextBox")).clear();
        wd.findElement(By.cssSelector("input.gwt-PasswordTextBox"))
                .sendKeys("secret");
        wd.findElement(By.cssSelector("button.gwt-Button")).click();
        irregularCredentialsUA.waitForTextArising();
        String text = wd.findElement(By.tagName("html")).getText();
        System.out.println("text " + text);
        assertTrue(text.contains(TEXT_TO_TEST) 
                   && text.contains(TEXT1_TO_TEST));
//        if (!wd.findElement(By.tagName("html")).getText().contains("Good night, Ivan!")) {
//            System.out.println("verifyTextPresent failed");
//        }
        assertTrue(text.contains(LOGOUT_TO_TEST));
        if (!wd.findElement(By.tagName("html")).getText().contains("Log out")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.linkText("Log out")).click();
        text = wd.findElement(By.tagName("html")).getText();
        assertTrue(text.contains(LOGIN_TO_TEST));
//        if (!wd.findElement(By.tagName("html")).getText().contains("Login")) {
//            System.out.println("verifyTextPresent failed");
//        }
        assertTrue(text.contains(PASSWORD_TO_TEST));
//        if (!wd.findElement(By.tagName("html")).getText().contains("Password")) {
//            System.out.println("verifyTextPresent failed");
//        }
    }

    @After
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
