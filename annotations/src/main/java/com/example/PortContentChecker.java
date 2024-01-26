package com.example;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortContentChecker {
    public static void main(String[] args) {
        boolean foundPort = false;
        String host = "localhost";
        int portToCheck = 8000;
            try(Socket client = new Socket(host, portToCheck)) {
                InputStream inFromServer = client.getInputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(inFromServer));
                System.out.println("Just connected to " + client.getRemoteSocketAddress());

                while (true) {
                    String incomingStr = in.readLine();
                    if(incomingStr == null) {
                        System.out.println("Server disconnected");
                        break;
                    }
                    System.out.println("Data from server: " + incomingStr);
                }
            } catch (IOException e) {
                System.out.println("Exception occurred" + e);
            }
        }
    }
