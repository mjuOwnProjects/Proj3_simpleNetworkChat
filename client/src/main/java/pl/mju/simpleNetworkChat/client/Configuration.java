package pl.mju.simpleNetworkChat.client;

import pl.mju.simpleNetworkChat.client.dao.ConfigurationDao;

import java.util.Properties;

public class Configuration {

    private ConfigurationDao configurationDao;
    private Properties properties;

    public Configuration() {
        this.configurationDao = new ConfigurationDao();
        this.properties = configurationDao.getProperties();
    }

    public String getStringProperty(String key) {
        return properties.getProperty(key);
    }

    public int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

}
