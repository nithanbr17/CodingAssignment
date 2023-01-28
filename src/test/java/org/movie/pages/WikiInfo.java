package org.movie.pages;

import org.movie.core.WebDriverHelper;
import org.openqa.selenium.By;

public class WikiInfo implements MovieInfo{

    WebDriverHelper webDriverHelper;

    static By releaseDate = By.xpath("//div[text()='Release date']/parent::th/following-sibling::td//li");
    static By country = By.xpath("//th[text()='Country']/parent::tr/td");

    public WikiInfo()
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
