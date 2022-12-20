<%@ page import="com.nhnacademy.domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2022-10-25
  Time: 오후 6:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생 상세화면</title>
</head>
<body>
학번:  ${student.id}<br/>
이름:  ${student.name}<br/>
성별:  ${student.gender}<br/>
나이:  ${student.age}<br/>
</body>
</html>
