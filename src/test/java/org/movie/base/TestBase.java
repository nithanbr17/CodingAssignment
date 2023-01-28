package org.movie.base;

import org.movie.core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public static WebDriver driver;
    private WebDriverManager webDriverManager;

    @BeforeClass
    public void setUp()
    {
        webDriverManager =  WebDriverManager.getInstance();
        driver = webDriverManager.getDriver();
    }

    @AfterClass
    public void tearDown()
    {
        webDriverManager.quitDriver();
    }

}
