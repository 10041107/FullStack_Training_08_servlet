package com.ohgiraffers.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

    /*
    * 서블릿이 하는 역할은 크게 3가지 이다.
    * 1. 요청 받기 - http method get/post 요청에 따라 parameter로 전달받은 데이터를 꺼내올 수 있다.
    * 2. 비즈니스 로직 처리 (service 호출을 통해 .DB 접속과 CRUD의 대한 로직을 처리함)
    * 3. 응답하기 - 문자열로 동적인 웹(html 태그)페이지를 만들고 스트림을 이용하여 내보낸다.
    * */

    /*
    * 사용자가 브라우저에 응답하기 위해서는 HttpServletResponse의 getWriter() method로 printWriter 인스턴스를 반환한다.
    * printWriter는 BufferWriter와 형제격인 클래스이지만 더 많은 새ㅐㅇ성자를 제공하고 있는 범용성으로 인해 더 많이 사용한다.
    * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("<title>response</title>")
                .append("</head>\n")
                .append("<body>")
                .append("<h1>  안녕하세요 </h1>")
                .append("</body>")
                .append("</html>");

        // 브라우저로 내보낼 데이터의 타입을 응답 헤더에 설정해주지 않으면 기본값은 null이고 이는 text/plain로 인식된다.
        System.out.println("default respoonse type " + resp.getContentType());


        /* 기본 값은 text/plain이지만 html 태그르 사용하면 요청 시 text/html도 응답으로 수락 가능하도록 헤더 설정이 되어있어
        자동으로 text/html로 인식하게 된다. 하지만 명시적으로 text/plain로 설정하게 되면 태그를 태그로 인식하지 않고 문자열로 인식한다.
         * */
        resp.setContentType("text/html");

        /*
        *  응답 시에도 별도의 인코딩을 지정하지 않으면 기본(톰캣의 설정) 설정된 인코딩 방식을 따르게 된다.
        *  따라서 한글을 포함한 페이지를 응답하는 경우 글자가 깨져서 현출된다.
        * */
        System.out.println("default response encoding : " + resp.getCharacterEncoding());

        resp.setCharacterEncoding("UTF-8");
        System.out.println("chaged response encoding : " + resp.getCharacterEncoding());

        PrintWriter out = resp.getWriter();
        out.println(responseBuilder.toString());
        out.flush();
        out.close();
    }
}
