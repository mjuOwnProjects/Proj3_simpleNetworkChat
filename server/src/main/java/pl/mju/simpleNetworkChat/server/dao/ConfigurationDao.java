package pl.mju.simpleNetworkChat.server.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationDao {

    String propertiesFile;
    Properties properties;

    public ConfigurationDao(String propertiesFile) {
        this.propertiesFile = propertiesFile;
        properties = loadPropertiesFile(this.propertiesFile);
    }

    public ConfigurationDao() {
        this("src/main/resources/server.properties");
    }

    public Properties getProperties() {
        return properties;
    }

    private Properties loadPropertiesFile(String propertiesFile) {
        Properties localProperties = new Properties();
        try {
            localProperties = new Properties();
            localProperties.load(new FileReader(propertiesFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localProperties;
    }
}
