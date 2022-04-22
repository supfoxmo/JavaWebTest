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

public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置响应内容的格式和编码集
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        //根据请求提交的部门编码，删除数据
        String deptno = request.getParameter("deptno");

        //连接数据库
        Connection conn = null;
        PreparedStatement ps = null;

        int count = 0;

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //启动事务（关闭事务自动提交机制）
            conn.setAutoCommit(false);
            //获取数据库操作对象
            String sql = "delete from data where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            //执行sql语句
            count = ps.executeUpdate();
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally{
            //关闭资源
            JDBCUtil.close(conn,ps,null);
        }

        if(1 == count){
            //删除成功,返回部门列表页面
            request.getRequestDispatcher("/list").forward(request,response);
        }else{
            //删除失败，跳转到错误页面
            request.getRequestDispatcher("/error.html").forward(request,response);
        }

    }
}
