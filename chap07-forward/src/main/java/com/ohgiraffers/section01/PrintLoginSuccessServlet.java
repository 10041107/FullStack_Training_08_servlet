package com.ohgiraffers.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        * forward 받은 서블릿에서도 요청 방식이 get이면 doget 메소드를, 요청 방식이 post이면 doPost 메소드를 호ㅗ출한다.
        * 보내준 서블릿에 request에 전달 정보를 담았으므로 해당 서블릿에서 사용하기 위해 다시 request에서 꺼내온다.
        *
        * forward할 때 전달한 request와 response의 모든 정보를 이용해 새로운 request, response를 만들고
        * 그 정보를 이용해 다시 http 메소드에 맞는 서블릿의 doGet 혹은 doPost를 요청하는 방식이다.
        * 깊은 복사를 이용해 값을 그대로 복사했기 때문에 내부에 존재하는 헤더 정보나 인스턴스는 그대로 유지하고 있다.
        * */
        String userId = (String) req.getAttribute("userId");

        StringBuilder responseText = new StringBuilder();

        responseText.append("<!doctype html> \n")
                .append("<html> \n")
                .append("<head>\n")
                .append("</head> \n")
                .append("<body> \n")
                .append("<h3 align=\" center \"> \n")
                .append(userId)
                .append("</h3> \n")
                .append("</body> \n")
                .append("</html> \n");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();

        /* 기본적으로 변수의 기본 스코프는 메소드(= 해당 페이지) 이기 때문에 다른 페이지(= 서블릿)로 데이터를 공유할 수 없다.
         * 하지만 forward 방식은 request와 response를 포함하여 위임하기 때문에 request에 정보를 저장하여 forward하면
         * 위임받은 서블릿에서도 위임한 서블릿의 정보를 공유할 수 있다.
         * forward 받은 서블릿의 존재를 클라이언트가 알 필요가 없기 때문에 url 자체는 변경되지 않는다.
         * (사용자는 결과 화면만 제대로 받으면 되기 때문이다.)
         * forward 방식의 또ㅗ 다른 특징은 요청 시 서버로 전송한 데이터가 남아있는 상태로 새로고침(= 재요청)을 하면
         * 동일한 요청을 반복하여 데이터베이스에 insert하는 등의 행위를 하면 중복된 행이 삽입될 가능성이 있다.
         * 따라서 이러한 경우 다른 페이지를 호출하는 방식인 sendRedirect를 이용한다.
         * */
    }
}
