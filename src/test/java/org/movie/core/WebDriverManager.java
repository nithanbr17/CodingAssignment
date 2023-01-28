package org.movie.core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import java.time.Duration;

public class WebDriverManager {

    private static WebDriverManager webDriverManager;

    private ChromeDriver chromeDriver;

    private WebDriverManager()
    {
        Reporter.log("Return WebDriver Manager Instance");
    }

    public static WebDriverManager getInstance()
    {
        if(webDriverManager==null)
        {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    public ChromeDriver getDriver()
    {
        if(chromeDriver == null)
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            chromeDriver = new ChromeDriver(options);
            chromeDriver.manage().window().maximize();
            chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
        return chromeDriver;
    }


    public void quitDriver()
    {
        if(chromeDriver!=null)
        {
            chromeDriver.quit();
        }
    }
}
