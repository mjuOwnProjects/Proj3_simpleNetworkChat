package pl.mju.simpleNetworkChat.client.dto;

import pl.mju.simpleNetworkChat.client.Configuration;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Connector {

    Configuration clientConfig;
    InputStreamReader inputStreamReader;
    Socket socket;

    public Connector (Configuration clientConfig) {
        this.clientConfig = clientConfig;
    }

    public void connectToServer() {
        try {
            this.socket = createSocketConnection();
            setInputStreamReader(socket);
        } catch (IOException e) {
            System.out.println("Problem with connection or reading the data" + e.getMessage());
        }
    }

    //TODO przerobić tak, żeby tutaj zwracało socket zamiast void
    public Socket createSocketConnection() {
        try (Socket socket = new Socket(clientConfig.getStringProperty("server_address"), clientConfig.getIntProperty("server_port"))) {
            socket.setSoTimeout(clientConfig.getIntProperty("client_timeout"));
        } catch(SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
        return socket;
    }

    public void setInputStreamReader(Socket socket) throws IOException {
        this.inputStreamReader = new InputStreamReader(socket.getInputStream());
    }

    public InputStreamReader getInputStreamReader() {
        return inputStreamReader;
    }

    public Socket getSocket() {
        return socket;
    }
}
