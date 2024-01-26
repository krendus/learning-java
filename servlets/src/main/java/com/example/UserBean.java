package com.example;

import java.io.Serializable;

public class UserBean<T> implements Serializable {
    private static final long serVersion = 1L;
    private String username;
    private String password;
    private T t;
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public static long getSerVersion() {
        return serVersion;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public T workWithT(T parameter) {
//        t = parameter;
        return parameter;
    }

    public boolean authenticate () {
        return "krendus".equals(this.username) && "password".equals(this.password);
    }
}
