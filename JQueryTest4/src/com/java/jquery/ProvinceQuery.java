package com.java.jquery;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.bean.City;
import com.java.bean.Province;
import com.java.util.JDBCutil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet({"/proQueryTest","/cityQueryTest"})
public class ProvinceQuery extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println(request.getServletPath()));
        if ("/proQueryTest".equals(request.getServletPath())){
            doProQuery(request,response);
        }else if("/cityQueryTest".equals(request.getServletPath())){
            doCityQauery(request,response);
        }
    }

    /**
     * 连接数据库，根据用户所选的省份的编号，查询对应城市的信息
     * @param request
     * @param response
     * @throws IOException
     */
    private void doCityQauery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取请求参数
        String pid = request.getParameter("pid");

        //容器，存储City对象
        ArrayList<City> cities = new ArrayList<>();
        String json = "{}";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCutil.getConnection();
            String sql = "select id,name from city where provinceid=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(pid));
            rs = ps.executeQuery();
            while(rs.next()){
                City city = new City();
                city.setCid(rs.getInt("id"));
                city.setCname(rs.getString("name"));

                //将city对象存储到cities集合中
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCutil.close(conn,ps,rs);
        }

        //将list转化成json格式的数据，输出给ajax请求
        if (cities != null){
            //调用jackson工具库，实现list-->json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(cities);
        }

        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 连接数据库，查询所有省份信息，并动态的增添下拉框的信息
     * @param request 请求对象
     * @param response 响应对象
     * @throws ServletException
     * @throws IOException
     */
    protected void doProQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //容器，存储province对象
        ArrayList<Province> provinces = new ArrayList<Province>();
        String json = "{}";

        try {
            conn = JDBCutil.getConnection();
            String sql = "select id,name,jiancheng,shenghui from province";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Province province = new Province();
                province.setPid(rs.getInt("id"));
                province.setPname(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));

                provinces.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutil.close(conn,ps,rs);
        }

        //将list转化成json格式的数据，输出给ajax请求
        if (provinces != null){
            //调用jackson工具库，实现list-->json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(provinces);
        }

        out.print(json);
        out.flush();
        out.close();
    }
}
