package com.foxmo.servlet;

import com.foxmo.domain.User1;
import com.foxmo.domain.User2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/bindingTest")
public class HttpSessionBindingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User1 user1 = new User1(1001, "zhangsan", "123456");
        User2 user2 = new User2(1002, "lisi", "123456");

        session.setAttribute("zhangsan",user1);
        session.setAttribute("lisi",user2);
    }
}
