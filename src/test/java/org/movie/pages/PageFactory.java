package org.movie.pages;

public class PageFactory {

    HomePage movieInfo;

    public static HomePage getWebSite(String type)
    {
        switch(type)
        {
            case "IMDB" : return new ImdbHome();
            case "WIKI" : return new WikiHome();
            default: return null;
        }
    }
}
