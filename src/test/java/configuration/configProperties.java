package configuration;

import java.io.FileReader;
import java.util.Properties;
public class configProperties {
    static Properties propValues;
    private static String property;

    configProperties() throws Exception{
        this.propValues = new Properties();
        propValues.load(new FileReader("src\\main\\resources\\Config-Files\\config.properties"));
    }

    public static String getProperty(String ppty) throws Exception {
        new configProperties();
        property = propValues.getProperty(ppty);
        return property;
    }
}
