package com.example.legalizeco2.model;

public class Customer {

    private int ID;

    private String userame;

    private String password;

    private String email;

    private String phoneNumber;

    public Customer() {

    }

    public Customer(String userame, String password, String email, String phoneNumber) {

        this.userame = userame;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getID() {
        return ID;
    }

    public String getUserame() {
        return userame;
    }

    public void setUserame(String userame) {
        this.userame = userame;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer [ID=" + ID + ", userame=" + userame + ", password=" + password + ", email=" + email
                + ", phoneNumber=" + phoneNumber + "]";
    }
}
