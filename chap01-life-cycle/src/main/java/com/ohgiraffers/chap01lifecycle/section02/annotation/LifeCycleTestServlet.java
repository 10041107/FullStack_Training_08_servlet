package com.ohgiraffers.chap01lifecycle.section02.annotation;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "annotation-servlet", value = "/annotation-lifecycle", loadOnStartup = 1)
public class LifeCycleTestServlet extends HttpServlet {
    private static final long serialVersionUID  =1L;

    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet() {
        System.out.println("ano static 값 : " + serialVersionUID);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("ano init "+initCount++);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("ano serviceCount "+serviceCount++);
    }

    @Override
    public void destroy() {
        System.out.println("ano destory " + destroyCount++);
    }


}
