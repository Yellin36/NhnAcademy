<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2022/11/23
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>강의 추가</title>
</head>
<body>
<h3>강의 추가</h3>
<form method="post" action="/course/register">
  강의명 : <input type="text" name="subject"><br/>
  강사명 : <input type="text" name="teacher">
  <input type="submit" value="강의 등록">
</form>
</body>
</html>
