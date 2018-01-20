package pl.mju.simpleNetworkChat.client;

import pl.mju.simpleNetworkChat.client.dto.Connector;

public class Main {

    public static void main(String[] args) {

        Configuration clientConfig = new Configuration();
        User user = new User("Marek");
        Connector connector = new Connector();

        connector.connectToServer(clientConfig);

    }

}
