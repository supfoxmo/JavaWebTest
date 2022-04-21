package com.javaweb.Httpservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HttpServletRequestText extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String key = parameterNames.nextElement();
            String[] values = request.getParameterValues(key);
            for (int i = 0; i < values.length; i++) {
                writer.print(key + "=" + values[i]);
                writer.print("<br>");
            }
        }
        //获取参数Map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历集合(获取Map集合中所有的key)
        Set<String> keys = parameterMap.keySet();
        //迭代器
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            writer.print(key);
            writer.print("<br>");
        }
        //通过name获取一维数组的第一个元素
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String interest = request.getParameter("interest");

        writer.print(username + "," + password + "," + interest);
    }
}
