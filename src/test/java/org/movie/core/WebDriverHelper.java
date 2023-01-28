package org.movie.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverHelper {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    public WebDriverHelper()
    {
        webDriver = WebDriverManager.getInstance().getDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public String getText(By locator)
    {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return webDriver.findElement(locator).getText();
    }

    public void enterText(By locator, String text)
    {
        WebElement textBox = webDriver.findElement(locator);
        webDriverWait.until(ExpectedConditions.visibilityOf(textBox));
        textBox.click();
        textBox.sendKeys(text);
    }

    public void clickElement(By locator)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        webDriver.findElement(locator).click();
    }

    public void waitForPageToLoad()
    {
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        webDriverWait.until((ExpectedCondition<Boolean>) wd -> js.executeScript("return document.readyState").equals("complete"));
    }
}
