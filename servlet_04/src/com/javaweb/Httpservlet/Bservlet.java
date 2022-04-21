package com.javaweb.Httpservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Bservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从请求域取数据
        Object sysTime = request.getAttribute("sysTime");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("当前系统时间为：" + sysTime.toString());//当前系统时间为：Mon Mar 07 17:29:12 CST 2022
        //从请求域中删除数据
        request.removeAttribute("sysTime");
        writer.print("<br>");
        //获取客户端的IP地址
        String remoteAddr = request.getRemoteAddr();
        writer.print("客户端的IP地址" + remoteAddr.toString());//客户端的IP地址127.0.0.1
        writer.print("<br>");
        //设置请求体的编码集
        request.setCharacterEncoding("UTF-8");

        writer.print("<br>");
        //动态获取应用的根路径
        String contextPath = request.getContextPath();
        writer.print("当前应用的根路径为：" + contextPath.toString());//当前应用的根路径为：/httptext
        writer.print("<br>");

        //获取请求的URI（带有项目名）
        String requestURI = request.getRequestURI();
        writer.print("请求的URI为：" + requestURI.toString());
        writer.print("<br>");

        //获取servlet的路径（不带项目名）
        String servletPath = request.getServletPath();
        writer.print("servlet的路径为：" + servletPath);
        writer.print("<br>");

        //获取请求的UTL
        StringBuffer requestURL = request.getRequestURL();
        writer.print("请求的URL为：" + requestURL);
        writer.print("<br>");

        //获取请求方式
        String method = request.getMethod();
        writer.print("请求方式为：" + method.toString());
    }
}
