package com.java.oa.util;

import java.util.ResourceBundle;

public class text {
    public static void main(String[] args) {
        //属性资源文件绑定
        ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");

        System.out.println(bundle.getString("driver"));
        System.out.println(bundle.getString("url"));
        System.out.println(bundle.getString("user"));
        System.out.println(bundle.getString("password"));
    }
}
