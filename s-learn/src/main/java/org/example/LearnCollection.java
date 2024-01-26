package org.example;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@interface MyAnot {
    String type();
}
@MyAnot(type = "Annotation")
@interface Description {
    String description();
}

@Description(description = "Implementation of array list")
public class LearnCollection {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("One");
        al.add("Two");
        System.out.println(al.size());
        System.out.println(al.indexOf("Two"));
        System.out.println(Arrays.toString(al.toArray()));
        // Linked List
        LinkedList<String> ll = new LinkedList<String>(al);
        System.out.println(ll);
        al.add("We de go hash list");
        HashSet<String> hs = new HashSet<String>(al);
        System.out.println(hs);
        for (String el : ll) {
            System.out.print(el +", ");
        }
    }
}
