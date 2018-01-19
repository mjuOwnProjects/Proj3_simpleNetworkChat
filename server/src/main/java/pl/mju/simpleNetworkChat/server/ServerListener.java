package pl.mju.simpleNetworkChat.server;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerListener extends Thread {

    private Socket socket;
    private Configuration serverConfig;

    public ServerListener(Socket socket, Configuration configuration ) {
        this.socket = socket;
        this.serverConfig = configuration;
    }

    @Override
    public void start() {

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader input = new BufferedReader(inputStreamReader);
            PrintWriter outpout = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String clientMessage = input.readLine();
                System.out.println("Recieved message: " + clientMessage);
                outpout.println("");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
