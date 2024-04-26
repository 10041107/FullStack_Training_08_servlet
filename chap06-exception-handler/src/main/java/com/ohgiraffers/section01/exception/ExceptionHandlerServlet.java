package com.ohgiraffers.section01.exception;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* javax.servlet.forward.request_uri
         * javax.servlet.forward.context_path
         * javax.servlet.forward.servlet_path
         * javax.servlet.forward.mapping
         * javax.servlet.error.status_code
         * javax.servlet.error.message
         * javax.servlet.error.servlet_name
         * javax.servlet.error.request_uri
         * */

        Enumeration<String> attrName = req.getAttributeNames();
        while(attrName.hasMoreElements()) {
            System.out.println(attrName.nextElement());
        }

        //javax.servlet.forward.request_uri
        String forwardRequestURL = (String) req.getAttribute("javax.servlet.forward.request_uri");
        String contextPath = (String) req.getAttribute("javax.servlet.forward.context_path");
        String sevletPath = (String) req.getAttribute("javax.servlet.forward.servlet_path");
        HttpServletMapping mapping = req.getHttpServletMapping();
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String message = (String) req.getAttribute("javax.servlet.error.message");
        String sevletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
        String errorRequestURI = (String) req.getAttribute("javax.servlet.error.request_uri");

        System.out.println("forwardRequestURL : " + forwardRequestURL);
        System.out.println("contextPath : " + contextPath);
        System.out.println("sevletPath : " + sevletPath);
        System.out.println("mapping : " + mapping);
        System.out.println("statusCode : " + statusCode);
        System.out.println("message : " + message);
        System.out.println("sevletName : " + sevletName);
        System.out.println("errorRequestURI : " + errorRequestURI);

        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!doctype html> \n")
                .append("<html>\n")
                .append("<head>\n")
                .append("<title>에러화면</title>")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(statusCode)
                .append(" - ")
                .append(message)
                .append("</h1> \n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(errorPage.toString());
        out.flush();
        out.close();
    }
}
