package org.movie.pages;

import org.movie.core.WebDriverHelper;
import org.openqa.selenium.By;

public class ImdbHome implements HomePage{

    WebDriverHelper webDriverHelper;
    static By searchBox = By.id("suggestion-search");
    static By searchButton = By.id("iconContext-magnify");

    public ImdbHome()
    {
        webDriverHelper = new WebDriverHelper();
        webDriverHelper.waitForPageToLoad();
    }
    @Override
    public MovieInfo searchMovie(String movieName) {
        webDriverHelper.enterText(searchBox,movieName);
        webDriverHelper.clickElement(searchButton);
        webDriverHelper.clickElement(By.xpath("//a[text()='"+movieName+"']"));
        return new ImdbInfo();
    }
}
