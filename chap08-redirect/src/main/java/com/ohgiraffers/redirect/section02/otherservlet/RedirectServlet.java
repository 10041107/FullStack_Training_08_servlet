package com.ohgiraffers.redirect.section02.otherservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("이 서블릿으로 redirect 성공!");
        String test = (String) req.getAttribute("test");

        StringBuilder redirectText = new StringBuilder();
        redirectText.append("<!doctype html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>이 서블릿으로 redirect 성공!</h1>")
                .append("<h1> test의 값은 "+ test + "</h1>")
                .append("</body>\n")
                .append("</html>\n");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(redirectText);
        out.flush();
        out.close();
        /*
        * redirect하면 url이 재작성되어 새로고침할 때 redirect된 페이지에 대한 요청을 반복한다.
        * 즉, 이전 요청에 포함된 정보는 남아있지 않고 url이 변경되는 것이 redirect의 특징이다.
        * http 요청은 요청 시 잠시 connection을 맺고 응답 시에도 잠시 connection을 맺으며 요청 단위당 request개체는 한 개만
        * 생성된다. 따라서 첫 요청시 의 request와 현재 redirect된 페이지의 request는 서로 다른 객체이므로
        * redirect를 스면 이전 서블릿의 값을 공유해서 사용할 수 없게 된다.
        * */
    }
}
