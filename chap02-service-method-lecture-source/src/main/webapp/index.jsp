<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>get 요청</h1>
    <a href="request-service">Hello Servlet</a>

    <h1>post 요청</h1>
    <form action="request-service" method="post">
        <input type="submit" value="POST방식 요청 전송">
    </form>
</body>
</html>