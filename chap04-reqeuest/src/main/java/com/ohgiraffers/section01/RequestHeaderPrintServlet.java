package com.ohgiraffers.section01;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {


    /*
    * 헤더의 종류는 전통적으로 4가지 카테고리로 구분된다.
    *   1. General haeder : 요청 및 응답에 모두 적용되지만 최종적으로는 body에 전송되는 것과 관련이 없는 헤더이다.
    *   2. Request Header : Fetch될 리소스나 클라이언트 자체에 대한 상세 정보를 포함하는 헤더이다.
    *   3. Response header : 위치나 서버 자체와 같은 응답에 대한 부가적인 정보를 갖는 헤더이다.
    *   4. Entity header : 컨텐트츠의 길이나 mime 타입과 같은 엔티티 boody에 대한 상세 정보를 포함하는 헤더이다.
    *   (요청 응답 모두에 사용되며, 메세지 바디의 컨텐츠를 나타내기에 get 요청은 해당하지 않는다.)
     *
     * accept : 요청을 보낼 때 서버에게 요청할 응답 타입 명시
     * accept-encoding : 응답 시 원하는 인코딩 방식
     * accept-language : 웅답 시 원하는 언어
     * connection : HTTP 통신이 완료된 후에 네트워크 접속을 유지할지 결정 (기본값: keep-alive = 연결을 열린 상태로 유지)
     * host : 서버의 도메인 네임과 서버가 현재 Listening 중인 TCP포트 지정 (반드시 하나가 존재. 없거나 둘 이상이면 404)
     * referer : 이 페이지 이전에 대한 주소
     * sec-fetch-dest : 요청 대상
     * sec-fetch-mode : 요청 모드
     * sec-fetch-site : 출처(origin)와 요청된 resource 사이의 관계
     * sec-fetch-user : 사용자가 시작한 요청일 때만 보내짐 (항상 ?1 값 가짐)
     * cache-control : 캐시 설정
     * upgrade-insecure-requests
     * user-agent : 현재 사용자가 어떤 클라이언트(OS, browser 포함)을 이용해 보낸 요청인지 명시
    * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("accept : " + req.getHeader("accept"));
        System.out.println("accept-encoding : " + req.getHeader("accept-encoding"));
        System.out.println("accept-language : " + req.getHeader("accept-language"));
        System.out.println("connection : " + req.getHeader("connection"));
        System.out.println("host : " + req.getHeader("host"));
        System.out.println("referer : " + req.getHeader("referer"));

    }
}
