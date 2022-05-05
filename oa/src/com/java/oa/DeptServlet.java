package com.java.oa;

import com.java.bean.Dept;
import com.java.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {"/list","/add","/delete","/detail","/edit"})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();

        response.setContentType("text/html");

        // 获取session对象，若不为空，证明用户已成功登录过，若为空，则用户还为登录，返回登录页面(不需要重新创建session对象)
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null){
            if ("/list".equals(servletPath)){
                doList(request,response);
            }else if("/add".equals(servletPath)){
                doAdd(request,response);
            }else if("/delete".equals(servletPath)){
                doDel(request,response);
            }else if("/detail".equals(servletPath)){
                doDetail(request,response);
            }else if("/edit".equals(servletPath)){
                doEdit(request,response);
            }
        }else{
            //返回登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

    }

    /**
     * 部门信息修改页面
     * @param request
     * @param response
     */
    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取修改后的部门信息
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String address = request.getParameter("address");
        String enums = request.getParameter("enums");
        String wages = request.getParameter("wages");

        //连接数据库，将修改后的数据存储到数据库中
        Connection conn = null;
        PreparedStatement ps = null;

        //标记执行sql语句后数据库受影响的行数
        int count = 0;

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

        if(count == 1){
            //修改部门信息成功，重定向到部门详情页面
            response.sendRedirect("/oa/list");
        }else{
            //修改部门信息失败，跳转到操作错误页面
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    /**
     * 部门信息详情页面
     * @param request
     * @param response
     */
    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获取请求中提交的信息
        String no = request.getParameter("deptno");
        //连接数据库，根据提交信息对数据库中数据进行删操作
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //标志执行sql语句后数据库受影响的行数
        int count = 0;

        //一个容器，用来存储Dept对象的集合
        List<Dept> depts = new ArrayList<>();

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //启动事务（关闭自动提交机制）
            conn.setAutoCommit(false);
            //获取数据库操作对象
            String sql = "select deptno,dname,address,enums,wages from data where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,no);
            //执行sql语句
            rs = ps.executeQuery();
            //处理操作结果集
            while(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String address = rs.getString("address");
                String enums = rs.getString("enums");
                String wages = rs.getString("wages");

                Dept dept = new Dept();
                //将数据封装到Dept对象中
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setAddress(address);
                dept.setEnums(enums);
                dept.setWages(wages);

                //将dept对象存储到depts集合中
                depts.add(dept);

                count++;
            }
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            if(conn != null){
                try {
                    //事务回滚
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally{
            JDBCUtil.close(conn,ps,rs);
        }

        //将depts集合存储到请求域中
        request.setAttribute("deptDetail",depts);

        if(count == 1){
            //查询部门信息成功，跳转到部门详情页面
            request.getRequestDispatcher("/detail.jsp").forward(request,response);
        }else{
            //查询部门信息失败，跳转到操作错误页面
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    /**
     * 删除部门信息
     * @param request
     * @param response
     */
    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获取请求中提交的信息
        String deptno = request.getParameter("deptno");
        //连接数据库，根据提交信息对数据库中数据进行删操作
        Connection conn = null;
        PreparedStatement ps = null;

        //标志执行sql语句后数据库受影响的行数
        int count = 0;

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //启动事务（关闭自动提交机制）
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
            if(conn != null){
                try {
                    //事务回滚
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally{
            JDBCUtil.close(conn,ps,null);
        }

        if(count == 1){
            //删除部门信息成功，重定向到部门列表页面
            response.sendRedirect("/oa/list");
        }else{
            //删除部门信息失败，跳转到操作错误页面
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    /**
     * 新增部门信息
     * @param request
     * @param response
     */
    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单提交的数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String address = request.getParameter("address");
        String enums = request.getParameter("enums");
        String wages = request.getParameter("wages");

        //连接数据库，将数据存储到数据库中
        Connection conn = null;
        PreparedStatement ps = null;

        //标记执行sql语句后数据库受影响的行数
        int count = 0;

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
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

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //关闭资源
            JDBCUtil.close(conn,ps,null);
        }

        if(count == 1){
            //新增部门信息成功，重定向到部门信息列表页面
                response.sendRedirect("/oa/list");
        }else{
            //新增部门信息失败，跳转到操作错误页面
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    /**
     * 部门信息列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //存放部门信息的容器
        List<Dept> depts = new ArrayList<Dept>();

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //获取数据库操作对象
            String sql = "select deptno,dname,address,enums,wages from data";
            ps = conn.prepareStatement(sql);
            //执行sql语句
            rs = ps.executeQuery();
            //处理操作结果集
            while(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String address = rs.getString("address");
                String enums = rs.getString("enums");
                String wages = rs.getString("wages");

                //将从数据库查找到数据包装到Dept类中
                Dept dept = new Dept();
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setAddress(address);
                dept.setEnums(enums);
                dept.setWages(wages);

                //将dept类放到depts集合中
                depts.add(dept);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //关闭资源
            JDBCUtil.close(conn,ps,rs);
        }

        //将集合depts放到请求域中
        request.setAttribute("deptList",depts);

        //跳转到list.jsp页面
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
