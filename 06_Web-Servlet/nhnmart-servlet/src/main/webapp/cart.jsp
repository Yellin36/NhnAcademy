<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<fmt:bundle basename="language">
<html>
<head>
    <title>NHN Mart</title>
</head>
<body>
<h1><fmt:message key="title"/>: <fmt:message key="subtitle"/></h1>
<hr>
=============================<br/>
<h3><fmt:message key="receipt"/></h3>
=============================<br/>
<c:set var="basket" value="${applicationScope.basket}"/>
<c:set var="totalPrice" value="0"/>
<c:forEach var="food" items="${basket.getFoods()}">
    <ul>
        <li>${food.name}: ${food.price}<fmt:message key="money"/></li>
        <p hidden>${totalPrice = totalPrice + food.price} </p>
    </ul>
</c:forEach>
=============================<br/>
<fmt:message key="totalFee"/> : ${totalPrice}<br/>
=============================<br/>
<%
    request.getServletContext().setAttribute("totalPrice", pageContext.getAttribute("totalPrice"));
%>
<br/>
<button><a href="/pay.do"><fmt:message key="buy"/></a></button>
<hr>
<button><a href="/index.jsp"><fmt:message key="mainPage"/></a></button>
</body>
</html>
</fmt:bundle>