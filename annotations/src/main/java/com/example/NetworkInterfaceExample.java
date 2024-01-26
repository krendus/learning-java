package com.example;

import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NetworkInterfaceExample {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
        for (NetworkInterface iface : interfaces) {
            if(iface.isUp()) {
                System.out.println("Interface name: " + iface.getName());
                System.out.println("Interface display name: " + iface.getDisplayName());
                System.out.println("Hardware Address: " + Arrays.toString(iface.getHardwareAddress()));
                System.out.println("Parent: " + iface.getParent());
                System.out.println("Index: " + iface.getIndex());
                System.out.println("\tInterface Addresses");
                for(InterfaceAddress addr: iface.getInterfaceAddresses()) {
                    System.out.println("\t\t"+ addr.getAddress().toString());
                }
                System.out.println("\tMTU: " + iface.getMTU());
                System.out.println("\tSubinterfaces: " +
                        Collections.list(iface.getSubInterfaces()));
                System.out.println("\t is loopback: " + iface.isLoopback());
                System.out.println("\t is virtual: " + iface.isVirtual());
                System.out.println("\t is point to point: " + iface.isPointToPoint());
                System.out.println("Supports Multicast: " + iface.supportsMulticast());
                System.out.println("======");
            }
        }

        NetworkInterface nif = NetworkInterface.getByIndex(1);

        System.out.println("Network interface 1: " + nif.toString());

        NetworkInterface nif2 = NetworkInterface.getByName("eth0");
        InetAddress ip = InetAddress.getByName("localhost");
        NetworkInterface nif3 = NetworkInterface.getByInetAddress(ip);
        System.out.println("\nlocalhost associated with: " + nif3);

        boolean eq = nif.equals(nif2);
        System.out.println("nif==nif2: " + eq);
        System.out.println("Hashcode : " + nif.hashCode());
    }
}
