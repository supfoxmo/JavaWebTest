package com.javaweb.Httpservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Aservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取系统时间
        Date nowTime = new Date();
        //将系统当前时间绑定到请求域当中
        request.setAttribute("sysTime",nowTime);

//        //从请求域取数据
//        Object sysTime = request.getAttribute("sysTime");
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        writer.print(sysTime.toString());
//        //从请求域中删除数据
//        request.removeAttribute("sysTime");

        /*
         * 使用Servlet当中的转发机制
         * 执行了Asetvlet之后，跳转到Bservlet
         * 转发机制可以转发到服务器中任意一个合法资源
         */
        //第一步：获取请求转发器对象
        RequestDispatcher dispatcher = request.getRequestDispatcher("/b");
        //第二步：调用转发器的forward方法完成跳转/转发
        dispatcher.forward(request,response);



    }
}
