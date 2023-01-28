package org.movie.pages;

import org.movie.core.WebDriverHelper;
import org.openqa.selenium.By;

public class ImdbInfo implements MovieInfo{

    WebDriverHelper webDriverHelper;

    static By releaseDate = By.xpath("//a[text()='Release date']/parent::li/div//a");
    static By country = By.xpath("//button[text()='Country of origin']/parent::li/div//a");

    public ImdbInfo()
    {
        webDriverHelper = new WebDriverHelper();
        webDriverHelper.waitForPageToLoad();
    }

    @Override
    public String getReleaseDate() {
        return webDriverHelper.getText(releaseDate);
    }

    @Override
    public String getCountry() {
        return webDriverHelper.getText(country);
    }
}
