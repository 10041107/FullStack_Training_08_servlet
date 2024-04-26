<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
    <form action="forward" method="get">
        아이디 : <input type="text" name="userId"/>
        비밀번호 : <input type="password" name="password"/>
        <button type="submit">전송</button>
    </form>
</body>
</html>