package com.java.oa;

import com.java.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取浏览器提交的cookie对象
        Cookie[] cookies = request.getCookies();

        String username = null;
        String password = null;

        //判断cookies集合是否为空
        if (cookies != null) {
            //遍历cookies集合，获取用户名和密码
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                } else if ("password".equals(cookie.getName())) {
                    password = cookie.getValue();
                }
            }
        }
        boolean result = false;
        //判断用户名和密码是否为空
        if (username != null && password != null){
            //连接数据库，判断用户名是否合法
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                conn = JDBCUtil.getConnection();

                String sql = "select * from t_user where username = ? and password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);

                rs = ps.executeQuery();

                if (rs.next()) {
                    result = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                JDBCUtil.close(conn,ps,rs);
            }

            if (result) {
                //从服务器获取session对象，若没有则新创建一个session对象
                HttpSession session = request.getSession();
                //将用户登录信息绑定到会话域中
                session.setAttribute("username",username);

                //用户名和密码合法，重定向到部门信息列表页面
                response.sendRedirect(request.getContextPath() + "/list");
            }else{
                //用户名和密码非法，重定向到登录页面
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }else{
            //重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
