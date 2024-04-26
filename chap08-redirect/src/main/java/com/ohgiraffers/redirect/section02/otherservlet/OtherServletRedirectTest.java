package com.ohgiraffers.redirect.section02.otherservlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/otherservlet")
public class OtherServletRedirectTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청을 전달받음");
        System.out.println(resp);

        req.setAttribute("test", "값 공유하는지 확인하기");

        System.out.println((String)req.getAttribute("test"));

        resp.sendRedirect("redirect");
    }
}
