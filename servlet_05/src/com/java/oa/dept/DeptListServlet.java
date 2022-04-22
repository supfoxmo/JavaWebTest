package com.java.oa.dept;

import com.java.oa.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置响应的内容类型以及字符集，防止中文乱码
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        //获取项目的根路径
        String contextPath = request.getContextPath();

        //连接数据库，查询所有部门
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            //获取预编译的数据库操作对象
            String sql = "select deptno,dname,address,enums,wages from data";
            ps = conn.prepareStatement(sql);
            //执行失去了语句
            rs = ps.executeQuery();
            //处理结果集
            int i = 0;

            writer.print("<!DOCTYPE html>");
            writer.print("<html lang='en'>");
            writer.print("<head>");
            writer.print("    <meta charset='UTF-8'>");
            writer.print("    <title>列表页面</title>");

            writer.print("<script type='text/javascript'>");
            writer.print("        function del(deptno){");
            writer.print("    if (window.confirm('亲，确认删除该数据吗？')){");
            writer.print("        document.location.href = '"+contextPath+"/delete?deptno='+deptno");
            writer.print("    }");
            writer.print("}");
            writer.print("</script>");

            writer.print("</head>");
            writer.print("<body>");
            writer.print("    <h2 align='center'>列表页面</h2>");
            writer.print("    <hr>");
            writer.print("    <table border='1px' align='center' width='40%'>");
            writer.print("        <tr>");
            writer.print("            <th>序号</th>");
            writer.print("            <th>部门编号</th>");
            writer.print("            <th>部门名称</th>");
            writer.print("            <th>操作</th>");
            writer.print("        </tr>");
            while(rs.next() != false){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String address = rs.getString("address");
                String enums = rs.getString("enums");
                String wages = rs.getString("wages");


                writer.print("        <tr>");
                writer.print("            <td>"+(++i)+"</td>");
                writer.print("            <td>"+deptno+"</td>");
                writer.print("            <td>"+dname+"</td>");
                writer.print("            <td>");
                writer.print("                <a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>");
                writer.print("                <a href='"+contextPath+"/edit?deptno="+deptno+"&dname="+dname+"&address="+address+"&enums="+enums+"&wages="+wages+"'>修改</a>");
                writer.print("                <a href='"+contextPath+"/detail?deptno="+deptno+"&dname="+dname+"'>详情</a>");
                writer.print("            </td>");
                writer.print("        </tr>");

            }
            writer.print("    </table>");
            writer.print("    <a href='add.html'>新增部门信息</a>");
            writer.print("</body>");
            writer.print("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.close(conn,ps,rs);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
