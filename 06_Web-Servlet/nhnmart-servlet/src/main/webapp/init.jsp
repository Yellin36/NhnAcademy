<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="language">
<html>
<head>
    <title>NHN Mart</title>
</head>
<body>
<h1><fmt:message key="title"/></h1>
<hr>
<ul>
    <li><a href="/foods.do"><fmt:message key="shoppingList"/></a></li>
</ul>
<hr>
<button><a href="/logout.do"><fmt:message key="logout"/></a></button>
<button><a href="/index.jsp"><fmt:message key="mainPage"/></a></button>
</body>
</html>
</fmt:bundle>