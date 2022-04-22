package com.java.oa.dept;

import com.java.oa.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ResourceBundle;

public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //获取请求提交的数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        //连接数据库，根据部门编码查询部门信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //获取数据库操作对象
            String sql = "SELECT address,enums,wages FROM DATA WHERE deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            //执行sql语句
            rs = ps.executeQuery();
            //处理结果集
            writer.print("<!DOCTYPE html>");
            writer.print("<html lang='en'>");
            writer.print("<head>");
            writer.print("    <meta charset='UTF-8'>");
            writer.print("    <title>详情页面</title>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("    <h2 align='center'>详情页面</h2>");
            writer.print("    <hr>");
            writer.print("    <table border='1px' align='center' width='40%'>");
            writer.print("        <tr>");
            writer.print("            <th>部门编号</th>");
            writer.print("            <th>部门名称</th>");
            writer.print("            <th>部门地址</th>");
            writer.print("            <th>员工人数</th>");
            writer.print("            <th>平均工资</th>");
            writer.print("        </tr>");

            if (rs.next() != false){
                String enums = rs.getString("enums");
                String wages = rs.getString("wages");
                String address = rs.getString("address");

                writer.print("        <tr>");
                writer.print("            <td>"+deptno+"</td>");
                writer.print("            <td>"+dname+"</td>");
                writer.print("            <td>"+address+"</td>");
                writer.print("            <td>"+enums+"</td>");
                writer.print("            <td>"+wages+"</td>");
                writer.print("        </tr>");
            }

            writer.print("    </table>");
            writer.print("    <input type='button' value='返回列表页面' onclick='window.history.back()'>");
            writer.print("</body>");
            writer.print("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.close(conn,ps,rs);
        }


    }

}
