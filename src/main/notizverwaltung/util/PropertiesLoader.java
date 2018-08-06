package main.notizverwaltung.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class PropertiesLoader {



    //Beispiel von https://crunchify.com/java-properties-file-how-to-read-config-properties-values-in-java/
    //TODO Wo werden die Exceptions abgefangen??
    //TODO Eventuell zu umständlich. Vielleicht eine einfache Klasse mit public static final usw. ->Eventuell Olbertz fragen was Best Practices ist

    public static String loadPropertie(String key) throws IOException  {
        String result;
        InputStream inputStream;


        Properties prop = new Properties();
        String propFileName = "config.properties";

        inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }


        result = prop.getProperty(key);
        inputStream.close();
        return result;


    }


}
