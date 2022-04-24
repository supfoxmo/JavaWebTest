package com.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get/cookie")
public class CookieGetTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取该关联路径下所有的cookie，返回一个集合
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            //获取cookie的name和value
            out.print(cookie.getName()  + "=" + cookie.getValue());
            out.print("<br>");
        }
    }
}
