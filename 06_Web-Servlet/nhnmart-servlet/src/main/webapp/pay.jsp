<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="language">
<html>
<head>
    <title>NHN Mart</title>
</head>
<body>
<h1><fmt:message key="title"/>: <fmt:message key="subtitle"/> </h1>
<hr>
<p><fmt:message key="successLine"/></p>
<p><fmt:message key="change"/>: ${applicationScope.money}</p>

<button><a href="/index.jsp"><fmt:message key="mainPage"/></a></button>
</body>
</html>
</fmt:bundle>