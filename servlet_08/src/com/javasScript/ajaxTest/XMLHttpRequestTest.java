package com.javasScript.ajaxTest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ajaxServlet")
public class XMLHttpRequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取请求提交的数据
        String name = request.getParameter("name");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        //将身高和体重强转为float类型
        Float h = Float.valueOf(height);
        Float w = Float.valueOf(weight);
        //计算BMI值
        float bmi = w / (h * h);

        String msg = "";
        //判断健康程度
        if (bmi <= 18.4){
            msg += "偏瘦";
        }else if (bmi >= 18.5 && bmi <= 23.9){
            msg += "正常";
        }else if (bmi >= 24.0 && bmi <= 27.9){
            msg += "过重";
        }else{
            msg += "肥胖";
        }

        msg = "您好," + name + " 先生/女士,您的BMI值为: " + bmi + ",身体状态: " + msg;
        //设置响应内容格式和编码集
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print(msg);
        out.flush();
        out.close();
    }
}
