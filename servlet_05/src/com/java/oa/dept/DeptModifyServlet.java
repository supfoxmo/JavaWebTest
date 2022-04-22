package com.java.oa.dept;

import com.java.oa.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应内容的格式和编码集类型
        response.setContentType("text/html;charset=UTF-8");

        //获取请求提交的数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String address = request.getParameter("address");
        String enums = request.getParameter("enums");
        String wages = request.getParameter("wages");

        //标记执行sql语句后受影响的行数
        int count = 0;

        //连接数据库，将数据存储带数据库中
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //获取数据库操作对象
            String sql = "update data set dname = ?,address = ?,enums = ?,wages = ? where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,address);
            ps.setString(3,enums);
            ps.setString(4,wages);
            ps.setString(5,deptno);
            //执行sql语句
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //关闭资源
            JDBCUtil.close(conn,ps,null);
        }

        if (count == 1) {
            //修改成功
            request.getRequestDispatcher("/list").forward(request,response);
        }else{
            //修改失败
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }
}
