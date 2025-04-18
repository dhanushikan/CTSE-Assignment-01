package com.example.authservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "app_user")  // MongoDB collection name (optional, can be changed to whatever you want)
public class User {

    @Id
    private String id;  // MongoDB uses String (ObjectId) by default for IDs

    private String username;
    private String password;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
