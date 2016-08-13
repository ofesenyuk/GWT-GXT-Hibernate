package integration.tests.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class IrregularCredentialsUA {
    WebDriver wd;
    
    public static final int WAIT_FOR_ARISING = 60;
    public static final int N_TRY_FOR_ARISING = 10;
    private static final String TEXT_TO_TEST = "неправильні логін/пароль";
                                               //"irregular credentials"
    
    @Before
    public void setUp() throws Exception {
//        wd = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(WAIT_FOR_ARISING, 
                TimeUnit.SECONDS);
    }
    
    @Test
    public void IrregularCredentialsUA() {
        wd.get("http://localhost:8080/GWTHibernate/");
        waitForLocaleDetection();
        wd.findElement(By.cssSelector("td")).click();
        wd.findElement(By.cssSelector("input.gwt-TextBox")).click();
        wd.findElement(By.cssSelector("input.gwt-TextBox")).clear();
        wd.findElement(By.cssSelector("input.gwt-TextBox")).sendKeys("test");
        wd.findElement(By.cssSelector("input.gwt-PasswordTextBox")).click();
        wd.findElement(By.cssSelector("input.gwt-PasswordTextBox")).clear();
        wd.findElement(By.cssSelector("input.gwt-PasswordTextBox"))
                .sendKeys("set");
        wd.findElement(By.cssSelector("button.gwt-Button")).click();
        waitForTextArising();
        System.out.println("div.gwt-Label "
                + wd.findElement(By.cssSelector("div.gwt-Label")).getText());
        assertEquals(TEXT_TO_TEST, 
                wd.findElement(By.cssSelector("div.gwt-Label")).getText()
                .trim());
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

    public synchronized void waitForLocaleDetection() {
        try {
            wait(WAIT_FOR_ARISING * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginLogoutTestUa.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void waitForTextArising() {
        try {
                for (int i = 0; i < N_TRY_FOR_ARISING && wd.findElement(By
                        .cssSelector("div.gwt-Label")).getText().isEmpty(); 
                        i++) {
                    wait(WAIT_FOR_ARISING * 1000 / N_TRY_FOR_ARISING);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginLogoutTestUa.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
    }
}
