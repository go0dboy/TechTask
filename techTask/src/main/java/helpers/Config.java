package helpers;

import java.util.Properties;

public class Config {
    static final org.slf4j.Logger Log = org.slf4j.LoggerFactory.getLogger("File");
    private static final Properties props = new Properties();

    static {
        try {
            props.load(Config.class.getResourceAsStream("/config.properties"));
        } catch (Throwable e) {
            Log.error(e.fillInStackTrace().toString());
        }
    }

    private final int errorConfig = Integer.parseInt(Config.getProperty("error"));

    public static String getProperty(String name) {
        if (!props.containsKey(name)) {
            Log.error("Config option with name - " + name + " does not exists.");
        }
        return props.getProperty(name);
    }
}
