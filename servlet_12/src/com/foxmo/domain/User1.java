package com.foxmo.domain;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class User1 implements HttpSessionBindingListener {
    private int userCode;
    private String userName;
    private String password;

    public User1() {
    }

    public User1(int userCode, String userName, String password) {
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

    /**
     * 当User1对象存储导Session域中的时候调用
     * @param event
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("绑定数据");
    }

    /**
     * 当删除Session域中的User1对象的时候调用
     * @param event
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("解绑数据");
    }
}
