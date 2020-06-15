package com.softuni.springworkshop.web.models;

public class RoleAddModel {
    private String username;
    private String role;

    public RoleAddModel(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public RoleAddModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
