package com.ohgiraffers.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        System.out.println("=============================");
        System.out.println("firstName : "+ firstName);
        System.out.println("lastName : " + lastName);

        Cookie[] cookies = req.getCookies();

        for (int i = 0; i <cookies.length; i++) {
            System.out.printf("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue());
            if("firstName".equals(cookies[i].getName())){
                firstName = cookies[i].getValue();
            }else if("lastName".equals(cookies[i].getName())){
                lastName = cookies[i].getValue();
            }
        }
        System.out.println("for 이후 값 ");
        System.out.println("firstName : "+ firstName);
        System.out.println("lastName : " + lastName);


        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>your first name is ")
                .append(firstName)
                .append(" and last name is ")
                .append(lastName)
                .append("</h3>")
                .append("</body>\n")
                .append("</html>\n");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();
        /*
        * 쿠키는 텍스트 파일 형태로 클라이언트 브라우저에 저장된다.
        * 그렇기 대문에 개인pc는 크게 상관 없지만 공용pc 등 다른 사용자와 함께 쓰는 컴퓨터이면 보안에 취약하다.
        * 따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다는 세션을 이용한다.
        * 세션은 쿠키와 유사항 형태로 key=value 쌍으로 저장되지만 서버(톰캣)에서 관리되어 보안에 더 우수하다.
        * */
    }
}
