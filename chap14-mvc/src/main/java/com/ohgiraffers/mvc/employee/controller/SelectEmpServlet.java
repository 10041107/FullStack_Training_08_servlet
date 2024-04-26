package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.dto.EmpDTO;
import com.ohgiraffers.mvc.employee.dto.EmpInsertDTO;
import com.ohgiraffers.mvc.employee.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/employees")
public class SelectEmpServlet extends HttpServlet {
    private EmpService empService;

    @Override   //init은 리소스를 할당하는 경우 사용한다.
    public void init() throws ServletException {
        empService = new EmpService();
        System.out.println(empService + " 현재 상태");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");
        String path = null;

        if(empId == null){
            // 전체조회
            // get /employees
            List<EmpDTO> emplist = empService.selectAllEmp();

            request.setAttribute("emplist", emplist);
            path= "/WEB-INF/views/employee/empList.jsp";
        }else{
            // get /employees?empId=노홍철
            // 단일 사원 조회
            Object result = empService.selectEmp(empId);
            if(result instanceof EmpDTO){
                result = (EmpDTO)result;
            }else{
                result = (String)result;
            }
            request.setAttribute("emp", result);
            path= "/WEB-INF/views/employee/showEmpInfo.jsp";
        }

        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        EmpInsertDTO insert = new EmpInsertDTO();
        insert.setEmpId(req.getParameter("empId"));
        insert.setEmpName(req.getParameter("empName"));
        insert.setEmpNo(req.getParameter("empNo"));
        insert.setEmail(req.getParameter("email"));
        insert.setPhone(req.getParameter("phone"));
        insert.setDeptCode(req.getParameter("deptCode"));
        insert.setJobCode(req.getParameter("jobCode"));
        insert.setSalLevel(req.getParameter("salLevel"));
        insert.setSalary(Integer.parseInt(req.getParameter("salary")));
        insert.setBonus(Double.parseDouble(req.getParameter("bonus")));
        insert.setManagerId(req.getParameter("managerId"));
        insert.setHireDate(java.sql.Date.valueOf(req.getParameter("hireDate")));

        int result = empService.insert(insert);
        String path;
        if(result > 0){
            path= "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("message", "신규 직원 등록 성공");
        }else{
            path ="/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 등록 실패");
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }


    @Override
    public void destroy() {
        empService = null;
        System.out.println(empService + " 현재 상태" );
    }
}
