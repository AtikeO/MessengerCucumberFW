package stepdefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.ConfigReader;

public class SharedSD {      //Webdriver ile baglantili, configReader ile bagl, Browseri baslatiyor
                             // ShareSD + configReader + BasePage

    //Before and after methods == Hook

    private static WebDriver driver = null;           // WebDriver is here

    @Before("@web")        //cucumber.api.java        // it contacts with feature file
    public static void before() {

        ConfigReader configReader = new ConfigReader();              // ConfigReader is here, It is contacted with feature file // Browser and URL come here
        System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());
        driver = new ChromeDriver();                                                        // browser is initialized

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);              // Wait concept
        driver.get(configReader.getUrl());                                                  // URL is navigated
    }

    @After("@web")
    public static void after() {                     // Test bitince:
        if (driver != null) {                        // Cokie leri sil
            driver.manage().deleteAllCookies();      // browseri kapat
            driver.quit();
        }
    }

    public static WebDriver getDriver() {

        return driver;                                // driver artik kullanima hazir
    }
}

