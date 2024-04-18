package helpers;

import static configuration.configProperties.getProperty;

public class constants {
    public static String URL;

    static {
        try {
            URL = getProperty("webApp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String user;

    static {
        try {
            user = getProperty("userId");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String psw;

    static {
        try {
            psw = getProperty("Password");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int clientId = 2;

}
