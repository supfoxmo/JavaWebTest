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
import java.sql.SQLException;

public class DeptAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置响应内容的格式和字符集类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        //获取请求中提交的数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String address = request.getParameter("address");
        String enums = request.getParameter("enums");
        String wages = request.getParameter("wages");

        //连接数据库，并将请求中提交的数据存储到数据库中
        Connection conn = null;
        PreparedStatement ps = null;

        //标记sql语句执行后受影响的行数
        int count = 0;

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //启动事务（关闭事务自动提交机制）
            conn.setAutoCommit(false);
            //获取数据库操作对象
            String sql = "insert into data(deptno,dname,address,enums,wages) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,address);
            ps.setString(4,enums);
            ps.setString(5,wages);
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

        if(count == 1){
            //新增成功
            request.getRequestDispatcher("/list").forward(request,response);
        }else{
            //新增失败
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }
}
