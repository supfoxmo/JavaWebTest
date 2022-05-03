package com.javaServlet.ajaxtext;

import com.javaServlet.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/province")
public class ProvinceByID extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String msg = "请先输入省份编码！";

        //获取请求中的参数
        String proId = request.getParameter("proId");
        if (proId != null && !"".equals(proId)){
            //连接数据库，根据proId查询省份名称
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

//            String driver = "com.mysql.jdbc.Driver";
//            String url = "jdbc:mysql://localhost:3306/provinces";
//            String user = "root";
//            String password = "li970511";

            try {
//                Class.forName(driver);
//                conn = DriverManager.getConnection(url,user,password);
                conn = JDBCUtil.getConnection();
                String sql = "select name from province where id=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,Integer.valueOf(proId));
                rs = ps.executeQuery();

                if (rs.next()){
                    msg = rs.getString("name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtil.close(conn,ps,rs);
            }
        }

        out.print(msg);
        out.flush();
        out.close();
    }
}
