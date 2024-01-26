package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLPratice {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://google.com");
            System.out.println("URL is " + url);
            System.out.println("Protocol is " + url.getProtocol());
            System.out.println("Filename is " + url.getFile());
            System.out.println("Host is " + url.getHost());
            System.out.println("Path is " + url.getPath());
            System.out.println("Port is " + url.getPort());
            System.out.println("Ref is " + url.getRef());
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection ) {
                connection = (HttpURLConnection) urlConnection;
            } else {
                System.out.println("Please enter an HTTP url.");
                return;
            }
            String urlContent = "";
            String current;
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((current = in.readLine()) != null) {
                urlContent += current;
            }
            System.out.println("Content is :" + urlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
