package org.movie.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigReader {

    String path = "config/qa.properties";
    Properties properties;

    public ConfigReader() throws IOException {
        properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(path)));
    }

    public String getProperty(String name)
    {
        return properties.getProperty(name);
    }
}
