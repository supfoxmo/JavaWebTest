package com.java.JQuery;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/province")
public class JQuery_ajax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String pid = request.getParameter("pid");

        //连接数据库，根据pid查询数据
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String msg = "{}";

        try {
            String driver = "com.mysql.jdbc.Driver";
            //注册驱动
            Class.forName(driver);
            //获取连接
            String url = "jdbc:mysql://localhost:3306/provinces";
            String user = "root";
            String password = "li970511";
            conn = DriverManager.getConnection(url,user,password);
            //获取数据库操作对象
            String sql = "select name,jiancheng,shenghui from province where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(pid));
            //执行sql语句
            rs = ps.executeQuery();
            //处理操作结果集
            if (rs.next()){
                String name = rs.getString("name");
                String jiancheng = rs.getString("jiancheng");
                String shenghui = rs.getString("shenghui");

                msg = "{\"name\" : \""+name+"\",\"jiancheng\" : \""+jiancheng+"\",\"shenghui\" : \""+shenghui+"\"}";
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        out.print(msg);
        //清空缓存
        out.flush();
        //关闭资源
        out.close();

    }
}
