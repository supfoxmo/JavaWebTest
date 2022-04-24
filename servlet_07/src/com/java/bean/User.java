package com.java.bean;

import java.util.Objects;

public class User {
    private String userId;
    private String userName;
    private String password;
    private Address address;

    public User(String userId, String userName, String password, Address address) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, address);
    }
}
