package com.ohgiraffers.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("lastName");

        System.out.printf("firstName : " + firstName);
        System.out.printf("secondNAme : " + secondName);

        /*
        * 쿠키를 사용하는 방법은 간단하다.
        * 1. 쿠키를 생성한다.
        * 2. 생성한 쿠키의 만료 시간을 설정한다.
        * 3. 응답 헤더에 쿠키를 담는다.
        * 4. 응답을 보낸다.
        *
        * 그러나 쿠키에는 제약사항이 있다.
        * 쿠키의 이름은 ascii 문자만을 사용해야하며 한 번 설정한 쿠키의 이름은 변경할 수 없다.
        * 또한 쿠키의 이름은 공백문자와 일부 특수문자([] ( ) = , " \ ? @ : ; )를 사용할 수 없다.
        * */
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", secondName);

        firstNameCookie.setMaxAge(60*60*24);
        lastNameCookie.setMaxAge(60*60*24);

        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        resp.sendRedirect("redirect");
    }
}
