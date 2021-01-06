package com.may.serializable;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String name;
    private int age;
    private String email;

    public User(String username, String name, int age){
        this.age = age;
        this.name = name;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
