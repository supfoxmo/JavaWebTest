package com.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletA extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        ServletContext servletContext = this.getServletContext();

        //向ServletContext应用域取数据
        Object userObj1 = servletContext.getAttribute("userObj1");
        writer.print("<br>");
        writer.print(userObj1);//User{name='mark', password='123456', age=24, email='mark2000@outlook.com'}

        servletContext.removeAttribute("userObj1");
    }
}
