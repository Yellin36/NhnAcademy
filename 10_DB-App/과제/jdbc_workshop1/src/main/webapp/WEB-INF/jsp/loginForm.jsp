<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2022/11/21
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form method="post" action="/login">
    사용자 이름 : <input type="text" name="username"> <br/>
    비밀번호 : <input type="password" name="password"> <br/>
    <input type="submit" value="로그인">
</form>
</body>
</html>
