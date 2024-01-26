package com.example;

import java.io.*;
import java.net.*;

public class GreetClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = 8000;
        System.out.println("Connecting to " + serverName + " on port " + port);
        try(Socket client = new Socket(serverName, port);) {
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            out.write(("Hello from " + client.getLocalSocketAddress()).getBytes());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server says " + in.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
