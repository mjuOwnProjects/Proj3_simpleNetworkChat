package pl.mju.simpleNetworkChat.client.dto;

import pl.mju.simpleNetworkChat.client.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Messenger {

    Connector connector;
    User user;

    public Messenger(Connector connector, User user) {
        this.connector = connector;
        this.user = user;
    }

    public void message(InputStreamReader inputStreamReader, Socket socket) {
            try {
                BufferedReader msgFromServer = new BufferedReader(inputStreamReader);
                PrintWriter msgToServer = new PrintWriter(socket.getOutputStream(), true);

                Scanner scanner = new Scanner(System.in);
                String echoString;
                String response;

                do {
                    System.out.println("Enter string to be echoed: ");
                    echoString = scanner.nextLine();

                    msgToServer.println(user.getUserName() + ": "+ echoString);
                    if (!echoString.equals("exit")) {
                        response = msgFromServer.readLine();
                        System.out.println(response);
                    }
                } while (!echoString.equals("exit"));
            } catch (IOException e) {
                System.out.println("Error while getting message from user: " + e.getMessage());
            }
    }

}
