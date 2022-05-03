package com.foxmo.domain;

public class User2 {
    private int userCode;
    private String userName;
    private String password;

    public User2() {
    }

    public User2(int userCode, String userName, String password) {
        this.userCode = userCode;
        this.userName = userName;
        this.password = password;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
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
}
