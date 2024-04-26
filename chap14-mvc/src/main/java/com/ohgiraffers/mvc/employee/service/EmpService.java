package com.ohgiraffers.mvc.employee.service;

import com.ohgiraffers.mvc.employee.dao.EmpMapper;
import com.ohgiraffers.mvc.employee.dto.EmpDTO;
import com.ohgiraffers.mvc.employee.dto.EmpInsertDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Objects;

import static com.ohgiraffers.mvc.common.Template.*;
public class EmpService {

    private EmpMapper empMapper;

    public Object selectEmp(String empId) {
        SqlSession sqlSession = getSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(empMapper);
        System.out.println(empId);
        EmpDTO emp = empMapper.selectByEmpId(Integer.parseInt(empId));

        if(Objects.isNull(emp)){
            return new String("사원정보가 없습니다.");
        }
        sqlSession.close();

        return emp;
    }

    public List<EmpDTO> selectAllEmp() {
        SqlSession sqlSession = getSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);

        List<EmpDTO> empList = empMapper.selectAllEmp();


        if(empList.size() <= 0 || empList == null){
            return null;
        }

        sqlSession.close();
        return empList;

    }

    public int insert(EmpInsertDTO insert) {
        SqlSession session = getSession();

        empMapper = session.getMapper(EmpMapper.class);
        int result = empMapper.insert(insert);

        if(result <= 0){
            session.rollback();
        }else{
            session.commit();
        }
        session.close();

        return result;
    }
}
