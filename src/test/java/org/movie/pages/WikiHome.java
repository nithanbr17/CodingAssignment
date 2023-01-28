package org.movie.pages;

import org.movie.core.WebDriverHelper;
import org.openqa.selenium.By;

public class WikiHome implements HomePage{

    WebDriverHelper webDriverHelper;
    static By searchBox = By.id("searchInput");
    static By searchButton = By.xpath("//button[text()='Search']");

    public WikiHome()
    {
        webDriverHelper= new WebDriverHelper();
        webDriverHelper.waitForPageToLoad();
    }
    @Override
    public MovieInfo searchMovie(String movieName)
    {
        webDriverHelper.enterText(searchBox,movieName);
        webDriverHelper.clickElement(searchButton);
        return new WikiInfo();
    }
}
