<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:bundle basename="language">
<html>
<head>
    <title>NHN Mart</title>
</head>
<body>
<c:choose>
    <c:when test="${param.lang != null}">
        <fmt:setLocale value="${param.lang}" scope="application"/>
    </c:when>
</c:choose>
<h1><fmt:message key="title"/></h1>
<hr>
<h6><fmt:message key="help"/></h6>
<button><a href="/locale.do?lang=ko"><fmt:message key="ko"/> </a></button>
<button><a href="/locale.do?lang=en"><fmt:message key="en"/> </a></button><br/>
<fmt:message key="lang"/> :
<c:choose>
    <c:when test="${param.lang != null}">
<%--        <fmt:setLocale value="${param.lang}" scope="application"/>--%>
        <fmt:message key="${param.lang}"/>
    </c:when>
    <c:otherwise>
        <fmt:message key="ko"/><fmt:message key="default"/>
    </c:otherwise>
</c:choose>
<hr>
<ul>
  <li><a href="/init.do"><fmt:message key="init"/></a> </li>
  <li><a href="/foods.do"><fmt:message key="shopping"/></a></li>
  <li><a href="/cart.do"><fmt:message key="basket"/></a></li>
</ul>
<hr>
<fmt:message key="change"/>: ${applicationScope.money}<fmt:message key="money"/>
</body>
</html>
</fmt:bundle>