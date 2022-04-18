package com.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletContextTest extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        ServletContext servletContext = this.getServletContext();

        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();

        while (initParameterNames.hasMoreElements()) {
            String element = initParameterNames.nextElement();
            String value = this.getInitParameter(element);
            writer.print(element + "=" + value + "<br>");
        }
        writer.print("<br>");

        String contextPath = servletContext.getContextPath();
        writer.print(contextPath.toString());//    /context

        writer.print("<br>");
        String realPath = servletContext.getRealPath("/index.html");
        writer.print(realPath.toString());//D:\code\javacode_idea\Workspace_idea_3\javaweb\out\artifacts\servlet_02_war_exploded\index.html

        User user = new User("joker", "123456", 21, "hidsn2000@outlook.com");
        User user1 = new User("mark", "123456", 24, "mark2000@outlook.com");
        //向ServletContext应用域存数据
        servletContext.setAttribute("userObj",user);
        servletContext.setAttribute("userObj1",user1);
        //向ServletContext应用域去数据
        Object userObj = servletContext.getAttribute("userObj");
        writer.print("<br>");
        writer.print(userObj);//User{name='joker', password='123456', age=21, email='hidsn2000@outlook.com'}
        //从ServletContext应用域删数据
        servletContext.removeAttribute("userObj");

    }
}
