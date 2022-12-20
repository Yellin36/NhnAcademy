<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>강의 관리</h1>
<hr>
<button onclick="location.href='/course/register'">강의 추가</button>
<hr>
<jsp:include page="list.jsp" flush="true"/>

</body>
</html>
