package com.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/send/cookie")
public class CookieSendTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie1 = new Cookie("uesrname", "zhangsan");
        Cookie cookie2 = new Cookie("password", "123456789");

        //设置cookie失效时间（单位为秒）只要有效期大于零，就存储到硬盘上
        cookie1.setMaxAge(60 * 60);//一小时后失效
        cookie2.setMaxAge(60 * 60);//一小时后失效
        //设置cookie的有效期为 0，表示cookie被删除，主要应用在：使用这种方式删除浏览器上的同名cookie
//        cookie1.setMaxAge(0);
        //设置cookie的有效期为负数，表示cookie不会被存储到硬盘中，而是存储到浏览器内存中

//        cookie1.setMaxAge(-1);

        //将cookie响应到浏览器上
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        //设置cookie的关联路径
        cookie1.setPath(request.getContextPath());
        cookie2.setPath(request.getContextPath());
    }
}
