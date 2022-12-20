<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2022-10-25
  Time: 오후 5:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생 등록</title>
</head>
<body>
<form method="post" action="/student/register.do">
  학번:  <input type="text" name="id"><br/>
  이름:  <input type="text" name="name"><br/>
  성별:  <input type="text" name="gender"><br/>
  나이:  <input type="number" name="age"><br/>
  <input type="submit"/>
</form>
</body>
</html>
