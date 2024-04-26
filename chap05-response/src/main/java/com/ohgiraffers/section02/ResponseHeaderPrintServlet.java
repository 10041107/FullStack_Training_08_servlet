package com.ohgiraffers.section02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/reponse-print")
public class ResponseHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        long currentTime = System.currentTimeMillis();
        out.print("<h1> " + currentTime +"</h1>");
        out.close();

        Collection<String> reseponseHeaders = response.getHeaderNames();
        Iterator<String> iter = reseponseHeaders.iterator();
        while (iter.hasNext()){
            String headerName = iter.next();
            System.out.println(headerName + " : " + response.getHeaders(headerName));
        }

    }
}
