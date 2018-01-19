package pl.mju.simpleNetworkChat.server;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

        Configuration serverConfig = new Configuration();
        System.out.println(welcomeMessage(serverConfig));

        try (ServerSocket serverSocket = new ServerSocket(serverConfig.getIntProperty("port"))) {
            while (true) {
                new ServerListener(serverSocket.accept(), serverConfig).start();
            }
        } catch (IOException e){
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static String welcomeMessage(Configuration serverConfig) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("=====================================================");
            stringBuilder.append("\nServer started with name: ");
            stringBuilder.append(serverConfig.getStringProperty("serverName"));
            stringBuilder.append("\nTCP/IP Socket Listener on port = ");
            stringBuilder.append(serverConfig.getStringProperty("port"));
            stringBuilder.append(", IP = ");
            stringBuilder.append(Inet4Address.getLocalHost().getHostAddress());
            stringBuilder.append("\n=====================================================");
        } catch (UnknownHostException e) {
            stringBuilder.append("I can't receive IP address of the server" + e.getMessage());
        }
        return stringBuilder.toString();
    }
}
