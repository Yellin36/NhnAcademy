<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title><%="title"%>></title>
</head>
<body>
<h1><%= "Hello World!" %></h1>

<c:out value="hello, servlet!"/>

<c:set var="email" value="dongmyo@nhndooray.com" scope="request" />
<c:set var="name">dongmyo</c:set>

<c:out value="1" /><br />
<c:out value="${email}" /><br />
<c:out value="${pageScope.email}" /><br />
<c:out value="${requestScope.email}" /><br />

<c:out value="${name}" /><br />
<c:remove var="name" />
<c:out value="${name}" /><br />
<hr>
<h1>Formatting tag library</h1>
<fmt:setLocale value="ko" />
<fmt:setBundle basename="message" var="message" />
<fmt:message key="hello" bundle="${message}" />

<fmt:bundle basename="message">
    i say dooray, you say <fmt:message key="hello" />
</fmt:bundle>
</body>
</html>