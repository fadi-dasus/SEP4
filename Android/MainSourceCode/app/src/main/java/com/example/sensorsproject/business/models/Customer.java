package com.example.sensorsproject.business.models;

public class Customer {

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    public Customer(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer [ID=" + ", username=" + username + ", password=" + password + ", email=" + email
                + ", phoneNumber=" + phoneNumber + "]";
    }
}
