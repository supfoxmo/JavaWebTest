package com.java.servlet.annotation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(21);
        student.setInterest("foolboll");

        //向请求域中存储数据
        request.setAttribute("student",student);

        //转发（无论转发多少次，都是同一个请求，都是同一个request）
        //无论转发多少次，浏览器地址栏上的请求始终不会变，且调用getRequestDispatcher()方法时路径不需要项目名
        //request.getRequestDispatcher("/b").forward(request,response);

        //重定向（重定向多少次就请求多少次，就有多少个request）
        //浏览器地址栏上的请求将会是最后一次重定向的请求路径，且调用sendRedirect()方法是路径需要带项目名
        //以下代码会将请求路径"/servlet-06/b"发送给浏览器，浏览器会自发的向服务器发送一次全新的请求
        response.sendRedirect("/servlet-06/b");

    }
}
