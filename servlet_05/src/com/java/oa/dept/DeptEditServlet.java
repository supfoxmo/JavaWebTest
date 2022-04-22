package com.java.oa.dept;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应内容的格式和字符集类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        //获取项目根路径
        String contextPath = request.getContextPath();

        //获取请求提交的数据
        String no = request.getParameter("no");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String address = request.getParameter("address");
        String enums = request.getParameter("enums");
        String wages = request.getParameter("wages");

        writer.print("<!DOCTYPE html>");
        writer.print("<html lang='en'>");
        writer.print("<head>");
        writer.print("    <meta charset='UTF-8'>");
        writer.print("    <title>修改页面</title>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("    <h2 align='center'>修改页面</h2>");
        writer.print("    <hr>");
        writer.print("    <form action='"+contextPath+"/modify' method='post'>");
        writer.print("                部门编号:<input type='text' value="+deptno+" name='deptno' readonly/><br>");
        writer.print("                部门名称:<input type='text' value="+dname+" name='dname'/><br>");
        writer.print("                部门地址:<input type='text' value="+address+" name='address' /><br>");
        writer.print("                员工人数:<input type='text' value="+enums+" name='enums'/><br>");
        writer.print("                平均工资:<input type='text' value="+wages+" name='wages'/><br>");
        writer.print("        <input type='submit' value='提交'>");
        writer.print("        <input type='reset' value='清空'>");
        writer.print("    </form>");
        writer.print("</body>");
        writer.print("</html>");
    }
}
