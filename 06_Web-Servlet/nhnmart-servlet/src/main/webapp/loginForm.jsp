<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="language">
<html>
<head>
    <title>NHN Mart</title>
</head>
<body>
<h1><fmt:message key="login"/></h1>
<hr>
<form method="post" action="/login.do">
    <fmt:message key="userid"/> <input type="text" name="id"></br>
    <fmt:message key="userpwd"/> <input type="pwd" name="pwd"></br>
    <button type="submit" ><fmt:message key="login"/></button>
</form>
</body>
</html>
</fmt:bundle>