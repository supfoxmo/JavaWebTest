package com.java.servlet.annotation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RedirectTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //向请求域取数据
        Object student = request.getAttribute("student");
        //输出数据
        out.print("请求域中的数据为：" + student);
        //删除请求域中的数据
        request.removeAttribute("student");
    }
}
