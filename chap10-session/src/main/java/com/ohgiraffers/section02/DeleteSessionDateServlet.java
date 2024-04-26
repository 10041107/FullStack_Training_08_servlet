package com.ohgiraffers.section02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        /*
        * 세션의 데이터를 지우는 방법
        * 1. 설정한 만료시간이 지나면 세션이 만료된다.
        * 2. removeAttribute(key)를 이용하여 session의 Attribute를 지우는 방법
        * 3. inverlidate()를 호출하면 세션의 모든 데이터가 제거된다.
        * */
        session.removeAttribute("firstName");
        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        /*
        * session.invalidate(); 이후 session이 존재하지 않기 때문에 에러가 발생된다.
        * session.invalidate();는 세션 전체를 만료 처리하는 것이다.
        * */
        session.invalidate();
        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

    }
}
