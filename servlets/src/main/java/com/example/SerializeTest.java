package com.example;

import java.io.*;

public class SerializeTest {
    public static void main(String[] args) {
        UserBean<Integer> userBean = new UserBean<>();
        Class<?> myClass = userBean.getClass();
//        boolean isObj = myClass.isInstance(userBean);
//        userBean.setUsername("krendus");
        userBean.setPassword("password");

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))){
            oos.writeObject(userBean);
            System.out.println("User object has been serialized and stored in user.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))){
            UserBean gUserBean = (UserBean) ois.readObject();
            System.out.println("User object has been deserialized from user.ser");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
