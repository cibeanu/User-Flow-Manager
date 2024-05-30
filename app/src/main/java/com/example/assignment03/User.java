package com.example.assignment03;

import java.io.Serializable;

public class User implements Serializable {
    String name;

    String email;

    String typeButton;

    public User(String name, String email, String typeButton) {
        this.name = name;
        this.email = email;
        this.typeButton = typeButton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTypeButton(String typeButton) {
        this.typeButton = typeButton;
    }

    public String getEmail() {
        return email;
    }

    public String getTypeButton() {
        return typeButton;
    }

    public User() {
    }
}
