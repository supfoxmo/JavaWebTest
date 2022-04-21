package com.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class servletConfigTest extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //设置响应的内容类型
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        //获取ServletConfig对象
        ServletConfig servletConfig = this.getServletConfig();
        writer.print(servletConfig.toString());
        writer.print("<br>");

        //获取ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();
        writer.print(servletContext.toString());
        writer.print("<br>");

        //获取当前servlet的name
        String servletName = servletConfig.getServletName();
        writer.print(servletName.toString());
        writer.print("<br>");

        //获取所有初始参数的name,返回一个集合
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        //通过初始化参数的name获取对应的value
        while(initParameterNames.hasMoreElements()){
            String element = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(element);
            writer.print(element + "," + value);
        }


        /*
         *  获取初始化数据还有一下方法
         *      Enumeration<String> initParameterNames1 = this.getInitParameterNames();
                while(initParameterNames1.hasMoreElements()){
                    String s = initParameterNames1.nextElement();
                    String initParameter = this.getInitParameter(s);
                    writer.print(element + "," + value);
                }
         */
    }
}
