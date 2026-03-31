package com.example.cravecart1.features.users.dto;

import com.example.cravecart1.features.users.entity.UserRole;

public class UserUpdateRequest {

    private String name;
    private String phoneNumber;
    private UserRole role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
