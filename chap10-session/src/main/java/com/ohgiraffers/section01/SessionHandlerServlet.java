package com.ohgiraffers.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("fristName : " + firstName);
        System.out.println("lastName : " + lastName);

        /*
        * session을 사용하는 이유
        * 1. cookie의 경우 사용자의 브라우저에서 관리가 되는 데이터로 보안에 위험이 있어 민감한 정보를 서버에서 보관하기 위함
        * 2. cookie를 지원하지 않는 브라우저도 존재하기 때문
        * 3. 상태를 계속 유지해야 하는 메커니즘에 적합하지 않는 경우가 있는데 특히 로그인 정보가 대표적이며 이러한 값은
        *   값을 지속적으로 유지해야 하기 때문에 session을 이용하게 된다.
        * HttpSession은 직접 생성하는 것이 아닌 request에 있는 getSession() 메소드를 이용하여 리턴을 받아 사용한다.
        * */
        HttpSession session = req.getSession();
        System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());
        session.setMaxInactiveInterval(60*10); // 10분 설정
        System.out.println("session 유지 시간 변경 : " +  session.getMaxInactiveInterval());

        System.out.println("session Id : " + session.getId());
        /*
        * 세션은 redirect를 해도 값을 유지할 수 있기 때문에(브라우저에 저장됨) reqeust보다 더 넓은 범위의 공유 영역을 갖는다.
        * 세션의 값을 담을 때 setAttribute(key,value) 형태로 담을 수 있고 값을 꺼낼때는 getAtrribute(key)로 꺼낸다.
        * */
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);
        resp.sendRedirect("redirect");
    }
}
