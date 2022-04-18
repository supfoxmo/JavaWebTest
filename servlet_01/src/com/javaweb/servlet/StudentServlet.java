package com.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //设置响应的内容类型
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //连接数据库（JDBC）
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String password = "li970511";
            conn = DriverManager.getConnection(url,user,password);
            //获取预处理的数据库操作对象
            String sql ="select sno,sname,ssex,sage,sdept from students";
            ps = conn.prepareStatement(sql);
            //执行sql语句
            rs = ps.executeQuery();
            //处理操作结果集
            while(rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                String sage = rs.getString("sage");
                String sdept = rs.getString("sdept");
                out.print(sno + "," + sname + "," + ssex + "," + sage + "," + sdept + "<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
