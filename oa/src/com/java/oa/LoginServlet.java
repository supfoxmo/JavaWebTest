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

@WebServlet({"/login","/register","/exit"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求路径
        String servletPath = request.getServletPath();

        if ("/login".equals(servletPath)){
            doLogin(request,response);
        }else if ("/register".equals(servletPath)){
            doRegister(request,response);
        }else if("/exit".equals(servletPath)){
            doExit(request,response);
        }
    }

    /**
     * 手动销毁session对象，退出系统
     * @param request
     * @param response
     */
    private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取session对象
        HttpSession session = request.getSession();
        //判断session对象是否为空
        if (session != null){
            //手动销毁session对象
            session.invalidate();
            //销毁浏览器中的cookie对象
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName()) || "password".equals(cookie.getName())){
                    //销毁cookie对象
                    cookie.setMaxAge(0);
                    //设置cookie的关联路径
                    cookie.setPath(request.getContextPath());
                    //响应cookie给浏览器，浏览器会将原来的cookie覆盖
                    response.addCookie(cookie);
                }
            }
            //重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    /**
     * 注册账户页面，连接数据库，判断账户信息是否合法，若合法则注册成功，反之注册失败
     * @param request
     * @param response
     */
    private void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取注册账户信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //标记是否验证成功
        Boolean result = false;

        int count = 0;

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //获取数据库操作对象
            String sql = "select * from t_user where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            //执行sql语句
            rs = ps.executeQuery();

            if (!rs.next()) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //关闭资源
            JDBCUtil.close(conn,ps,rs);
        }

        if (result) {
            try {
                //获取连接
                conn = JDBCUtil.getConnection();
                //获取数据库操作对象
                String sql = "insert into t_user(username,password) values(?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                //执行sql语句
                count = ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                //关闭资源
                JDBCUtil.close(conn,ps,rs);
            }

            if (count == 1) {
                //注册成功，重定向到登录页面
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }else{
            //注册失败,重定向到注册失败页面
            response.sendRedirect(request.getContextPath() + "/loginfail.jsp?m=r");
        }
    }

    /**
     * 用户登录页面 连接数据库，验证用户提交的用户名和密码是否正确
     * @param request
     * @param response
     */
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取用户提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //标记是否验证成功
        Boolean result = false;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //获取数据库操作对象
            String sql = "select * from t_user where username=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            //执行sql语句
            rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //关闭资源
            JDBCUtil.close(conn,ps,rs);
        }

        if (result) {
            //从服务器获取session对象，若没有则新创建一个session对象
            HttpSession session = request.getSession();
            //将用户登录信息绑定到会话域中
            session.setAttribute("username",username);

            //登录成功后，判断用户是否选择了十天内免登录
            String sign = request.getParameter("sign");
            if ("1".equals(sign)){
                //创建cookie对象,并将用户名和密码存放到会话域中
                Cookie cookie1 = new Cookie("username",username);
                Cookie cookie2 = new Cookie("password",password);
                //设置cookie的有效期
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setMaxAge(60 * 60 * 24 * 10);
                //设置cookie的关联路径（只要访问该应用就将cookie对象发送给服务器）
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                //将cookie对象添加到响应中
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            //登录成功，重定向到部门信息列表页面
            response.sendRedirect(request.getContextPath() + "/list");
        }else{
            //登录失败,重定向到登录失败页面
            response.sendRedirect(request.getContextPath() + "/loginfail.jsp?m=l");
        }
    }
}
