package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.List;

public class GreetServer extends Thread {
    private final ServerSocket serverSocket;
    public GreetServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(600000);
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println("Input data: " + Arrays.toString(in.readAllBytes()));
                out.writeUTF("This is a data " + server.getLocalSocketAddress() + "\nGoodbye");
            } catch (SocketTimeoutException e) {
                System.out.println("Socket timeout");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args){
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new GreetServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
