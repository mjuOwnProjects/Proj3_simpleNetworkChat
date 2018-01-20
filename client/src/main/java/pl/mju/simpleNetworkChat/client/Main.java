package pl.mju.simpleNetworkChat.client;

import pl.mju.simpleNetworkChat.client.dto.Connector;
import pl.mju.simpleNetworkChat.client.dto.Messenger;

public class Main {

    public static void main(String[] args) {

        Configuration clientConfig = new Configuration();
        User user = new User("Marek");
        Connector connector = new Connector(clientConfig);
        connector.connectToServer();
        Messenger messenger = new Messenger(connector,user);
        messenger.message(connector.getInputStreamReader(),connector.getSocket());

        connector.connectToServer();

    }

}
