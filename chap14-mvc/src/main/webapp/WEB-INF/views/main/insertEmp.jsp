<%--
  Created by IntelliJ IDEA.
  User: psc12
  Date: 2023-11-24
  Time: 오후 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>직원 등록 페이지</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>
    <h1>전체 조회</h1>
    <a href="/employees">전체 조회</a>

    <h1>개별 조회</h1>
    <form action="/employees" method="get">
        <label>사원 번호를 입력하세요 : </label>
        <input type="text" name="empId" />
        <button type="submit"> 요청하기 </button>
    </form>


    <h3>emp 테이블에서 신규 직원 정보 추가(필요한 정보를 입력받을 수 있는 form을 만들어서 추가함)</h3>
    <form action="${pageContext.servletContext.contextPath}/employees" method="post">
        직원명 : <input type="text" name="empName"/> <br>
        주민등록번호 : <input type="text" name="empNo"> <br>
        이메일 : <input type="email" name="email"/> <br>
        전화번호 : <input type="tel" name="phone"/> <br>
        부서코드 :
        <select name="deptCode">
            <option value="D1">인사관리부</option>
            <option value="D2">회계관리부</option>
            <option value="D3">마케팅부</option>
            <option value="D4">국내영업부</option>
            <option value="D5">해외영업1부</option>
            <option value="D6">해외영업2부</option>
            <option value="D7">해외영업3부</option>
            <option value="D8">기술지원부</option>
            <option value="D9">총무부</option>
        </select>
        <br>
        직급코드 :
        <select name="jobCode">
            <option value="J1">대표</option>
            <option value="J2">부사장</option>
            <option value="J3">부장</option>
            <option value="J4">차장</option>
            <option value="J5">과장</option>
            <option value="J6">대리</option>
            <option value="J7">사원</option>
        </select>
        <br>
        급여등급 :
        <select name="salLevel">
            <option value="S1">S1</option>
            <option value="S2">S2</option>
            <option value="S3">S3</option>
            <option value="S4">S4</option>
            <option value="S5">S5</option>
            <option value="S6">S6</option>
        </select>
        <br>
        급여 : <input type="number" name="salary"/> <br>
        보너스율 : <input type="text" name="bonus"/> <br>
        관리자 사번 : <input type="text" name="managerId"/> <br>
        입사일 : <input type="date" name="hireDate"/>
        사원 번호 : <input type="number" name="empId"/>
        <input type="submit" value="등록하기"/>
    </form>
</body>
</html>
