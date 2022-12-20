<%@ page import="com.nhnacademy.nhn_mart.FoodStand" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.nhnacademy.nhn_mart.Food" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="language">
<html>
<head>
    <title>NHN Mart</title>
</head>
<body>
<h1><fmt:message key="title"/></h1>
<hr>
<p><fmt:message key="welcome"/></p>

<c:choose>
    <c:when test="${param.containsKey('error')}">
        <p><strong><fmt:message key="errorLine1"/></strong></p>

    </c:when>
    <c:otherwise>
        <p><fmt:message key="infoLine"/></p>
    </c:otherwise>
</c:choose>

<c:set var="foodStand" value="${applicationScope.foodStand}"/>
<c:set var="foodNames" value="${applicationScope.foodNames}"/>
<c:set var="foodPrices" value="${applicationScope.foodPrices}"/>
<%
    Map<String, Integer> foodAmounts = new HashMap<>();
    FoodStand foodStand = (FoodStand) pageContext.getAttribute("foodStand");
    String[] foodNames = (String[]) pageContext.getAttribute("foodNames");

    Arrays.asList(foodNames).stream().forEach(x -> {
        foodAmounts.put(x, foodStand.getFoods().stream()
                .filter(y -> x.equals(y.getName()))
                .collect(Collectors.toList()).size());
    });
    pageContext.setAttribute("foodAmounts", foodAmounts);
%>
<c:set var="foodAmounts" value="${pageScope.foodAmounts}"/>

<table border='1' style="border-collapse: collapse">
    <caption>&lt<fmt:message key="productList"/>&gt</caption>
    <tr>
        <th></th>
        <th><fmt:message key="product"/></th>
        <th><fmt:message key="price"/></th>
        <th><fmt:message key="stock"/></th></tr>
    <c:forEach var="foodName" items="${foodNames}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${foodName}</td>
            <td>${foodPrices[status.index]}</td>
            <td>${foodAmounts.get(foodName)}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<form method="post" action="/cart.do">
    <ul>
        <c:forEach var="foodName" items="${foodNames}">
            <li>${foodName} <input type="number" name="${foodName}"/></li>
        </c:forEach>
    </ul>
    <button type="submit"><fmt:message key="addList"/></button>
</form>

<hr>
<button><a href="/logout"><fmt:message key="logout"/></a></button>
<button><a href="/index.jsp"><fmt:message key="mainPage"/></a></button>
</body>
</html>
</fmt:bundle>