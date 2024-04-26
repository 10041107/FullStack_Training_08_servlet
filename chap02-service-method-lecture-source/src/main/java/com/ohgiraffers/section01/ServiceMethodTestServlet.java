package com.ohgiraffers.section01;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    private static final long serialVersionUID =1L;


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /*
        * Http를 대체할 프로토콜이 존재한다면 HttpServletRequest는 다른 클래스로 대체가 되어야한다.
        * 따라서 ServletRequest라는 추상화된 타입으로 사용하고, 실제 인스턴스는 httpServletRequest로 사용하여
        * 나중에 Service method의 인자 타입은 변경하지 않고 다른 프로토콜을 사용하는 request로 변경이 가능하다(다형성)
        * =============================================================================================
        * 하지만 현재 사용되는 프로토콜은 http 프로토콜로, httpServletRequest 타입이다.
        * httpServletRequest는 ServletRequest 타입을 상속받아서 구현하였으며, http 프로토콜의 정보를 담고 있기 때문에
        * 실제 사용 시에는 httpServletRequest 타입으로 다운 캐스팅 해서 사용해야한다..
        * ServletResponse도 같은 맥락이다.
        * =============================================================================================
        * httpServlet 클래스의 service(ServletRequest request, ServletResponse) mothod에서는
        * 인자로 전달받은 request와 reponse를 httpServletRequest와 httpServletResponse로 다운 캐스팅한다.
        * */

        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // a -> GET 링크를 호출하는 <a/> 태그의 경우 모든 요청을 GET 방식으로 요청한다.
        String method = request.getMethod();

        System.out.println(method);

        if(method.equals("GET")){
            doGet(request, response);
        } else if (method.equals("POST")) {
            doPost(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청을 처리할 메서드");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post 요청을 처리할 메서드");
    }

}
