package com.ohgiraffesr.section02.formdata;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class FormDataTestServlet extends HttpServlet {
    /*
    * post 방식으로 전달받은 데이터에 한글이 포함되어 있으면 해당 문자는 인코딩이 맞지 않아 깨진다.
    * ===============================================================================
    * get 방식의 데이터는 html charset에 기술된 인코딩 방식으로 브라우저가 한글을 이해하고, %문자로 URLEncoder를 이용해
    * 변환 후 url 요청으로 전송한다. 이때 header의 내용은 ascii 코드로 전송되기 때문에 어떤 언어든 서버의 설정 인코딩 방식과
    * 맞기만 하면 해석하는데 문제가 없으므로 한글이 깨지지 않는다. GET 요청은 보통 서버의 리소스를 가져오는 행위를 요청하는
    * http 요청 방식이기에 별도의 데이터가 필요 없어 요청 본문(페이로드)는 해석하지 않는다.
    * ===============================================================================
    * 하지만 post 요청은 서버의 리소스에 내용을 추가하는 요청이기 때문에 데ㅔ이터가 필요한 경우가 대부분이다.
    * 서버의 리소스에 추가해야 하는 정보를 페이로드에 key&value 방식으로 담아 전송하는데,
    * 해더와는 별개로 urlEncoder를 이용하지 않고 페이지 meta에 기술된 charset에 따라 UTF-8로 해석된 데이터를 서버로 전송한다.
    * 기본적으로 서버단에서 페이로드를 디코딩 하는 방식은 지정되어 있지 않으므로 request, getCharactorEncoding()을 호출해보면
    * null을 반환하게 되는데 인코딩된 방식을 명시하지 않으면 기본 ISO-8859-1로 해석하므로 값을 꺼내오면 한글인 글자가 깨지는
    * 현상이 발생한다. 따라서 parameter를 꺼내오기 전에 parameter값을 해석할 인코딩 방식이 utf-8임을
    * setCharactorEncoding(String encType)으로 지정해주어야 브라우저에서 요청한 인코딩 방식와 일치하여 한글 깨짐 현상을 막을 수 있다.
    * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 기본설정 인코딩 방식이 null이므로 톰캣의 기본 세팅 값이 ios-8859-1로 디코딩을 시도한다.
        System.out.println(req.getCharacterEncoding());

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println("name : " + name );
        String age = req.getParameter("age");
        System.out.println("age : " + age );
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        System.out.println("birthday : " + birthday );
        String[] hobbis = req.getParameterValues("hobbies");
        System.out.println("hobbis : " + hobbis );

    }
}
