package org.movie.tests;

import org.movie.base.TestBase;
import org.movie.pages.HomePage;
import org.movie.pages.MovieInfo;
import org.movie.pages.PageFactory;
import org.movie.utility.ConfigReader;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class MovieTest extends TestBase {

    ConfigReader configReader;

    @Test(dataProvider = "getData")
    void validateReleaseDateAndCountryOfOrigin(String siteName, String movieName,
                                               String releaseDateExpected, String countryExpected) throws IOException {

        configReader = new ConfigReader();

        Reporter.log("Search For Movie");
        driver.navigate().to(configReader.getProperty(siteName));
        HomePage homePage = PageFactory.getWebSite(siteName);
        MovieInfo movieInfo = homePage.searchMovie(movieName);

        Reporter.log("Validate Movie Information");
        Assert.assertEquals(movieInfo.getReleaseDate(),releaseDateExpected);
        Assert.assertEquals(movieInfo.getCountry(),countryExpected);
    }

    @DataProvider(name = "getData")
    public Object[][] getData(){
        return new Object[][] {{"IMDB", "Pushpa: The Rise - Part 1", "December 17, 2021 (United States)", "India"},
                {"WIKI","Pushpa","17 December 2021","India"}};
    }
}
