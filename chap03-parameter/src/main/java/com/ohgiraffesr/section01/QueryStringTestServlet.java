package com.ohgiraffesr.section01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


public class QueryStringTestServlet extends HttpServlet {

    /*
    * HttpServlet 클래스의 service method는 요청 방식에 따라 get요청에 대해서
    * doget() method를 호출하면서 request와 Response를 전달한다.
    * 톰캣 서블릿 컨테이너가 요청 url로 매핑된 servlet클래스의 인스턴스를 생성하여 service method를 호출하고
    * httpServlet를 상속받아 오버라이딩한 현재 클래스의 doGet() method가 동적 바인딩에 의해 호출된다.
    * ========================================================================================
    * Service로 부터 전달받은 httpServletRequest는 요청 시 전달한 값을 getParameter() Mehod로 추출할 수 있다.
    * 이때 인자로 input 태그에 지정한 name 속성의 값을 문자열 형태로 전달해주면된다.
    * 화면에서 전달한 form 내의 모든 input 태그의 값들을 hashMap으로 관리하고 있으므로,
    * 원하는 값을 찾기 위해서는 key역할을 하는 문자열이 필요하기 때문이다.
    * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        System.out.println("이름 : " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("나이 : " + age);

        Date birthDay = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("생일 : " + birthDay);

        System.out.print("취미[] : " );
        String[] hobbies = req.getParameterValues("hobbies");
        for (String hobby:hobbies) {
            System.out.print(hobby + ", ");
        }
    }
}
