package test;

import helpers.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Boolean.TRUE;


public class BaseTest {
    private final String url = Config.getProperty("baseUrl");
    private final String browserConfig = Config.getProperty("driver");
    private final int timeoutConfig = Integer.parseInt(Config.getProperty("timeout"));
    Logger Log = LoggerFactory.getLogger("Test");

    @BeforeMethod
    public void preConfig() {
        Reporter.log("TSNG Logger", 0,true);
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        browser = browserConfig;
        timeout = timeoutConfig;
        baseUrl = url;
        startMaximized = TRUE;
        open("");
        Log.warn("Before Method");
    }

    @BeforeClass
    public void printClass() {
        Log.info("Before Class", BaseTest.class);
    }

    @BeforeTest
    public void printTest() {
        System.out.println("Before Test");
        Log.info("Before Test");
    }

    @BeforeSuite
    public void printMethod() {
        System.out.println("Before Suite");
    }

}
