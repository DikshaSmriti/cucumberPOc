package com.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties init_prop() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/properties/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String getProperty(String keyName) {
        return prop.getProperty(keyName);
    }

}
