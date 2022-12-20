<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2022-10-25
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% for (int i = 1; i <= 9; i++) {%>
<h3><%= i%>단 시작</h3>
<%for (int j = 1; j <= 9; j++) {%>
<%= i + " X " + j  + " = " + (i*j)%><br/>
<%}%><br/>
<%}%>

</body>
</html>
