package integration.tests.selenium;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class IrregularCredentialsMainUA {
    public static void main(String[] args) throws Exception {
        FirefoxDriver wd;
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost:8080/GWTHibernate/");
        wd.findElement(By.cssSelector("td")).click();
        wd.findElement(By.cssSelector("input.gwt-TextBox")).click();
        wd.findElement(By.cssSelector("input.gwt-TextBox")).clear();
        wd.findElement(By.cssSelector("input.gwt-TextBox")).sendKeys("test");
        wd.findElement(By.cssSelector("input.gwt-PasswordTextBox")).click();
        wd.findElement(By.cssSelector("input.gwt-PasswordTextBox")).clear();
        wd.findElement(By.cssSelector("input.gwt-PasswordTextBox")).sendKeys("set");
        wd.findElement(By.cssSelector("button.gwt-Button")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("неправильні логін/пароль")) {
            System.out.println("verifyTextPresent failed");
        }
        synchronized (wd) {
            try {
                wd.wait(60000L);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginLogoutTestUa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("div.gwt-Label "
                + wd.findElement(By.cssSelector("div.gwt-Label")).getText());
//        assertTrue(wd.findElement(By.cssSelector("div.gwt-Label")).getText()
//                .contains(irregularMessage));
        assertEquals("неправильні логін/пароль", //"irregular credentials",
                wd.findElement(By.cssSelector("div.gwt-Label")).getText()
                .trim());
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
