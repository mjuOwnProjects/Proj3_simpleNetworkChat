package pl.mju.simpleNetworkChat.client.dto;

import pl.mju.simpleNetworkChat.client.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Connector {

    public void connectToServer(Configuration clientConfig) {
        try (Socket socket = new Socket(clientConfig.getStringProperty("server_address"), clientConfig.getIntProperty("server_port"))) {

            socket.setSoTimeout(clientConfig.getIntProperty("client_timeout"));
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader msgFromServer = new BufferedReader(inputStreamReader);
            PrintWriter msgFromClient = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                msgFromClient.println(echoString);
                if (!echoString.equals("exit")) {
                    response = msgFromServer.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));
        } catch(SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());

        }
    }
}
