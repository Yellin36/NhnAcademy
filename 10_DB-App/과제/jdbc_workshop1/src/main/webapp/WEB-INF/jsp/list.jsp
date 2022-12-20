<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>강의 목록</h3>
<c:if test="${courses != null}">
    <table border="1" style="border-collapse: collapse">
        <tr>
            <th>강의 번호</th>
            <th>강사</th>
            <th>강의명</th>
            <th>강의 생성일</th>
            <th colspan="2"></th>
            <th></th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <c:choose>
                    <c:when test="${courseId != null && course.id == courseId}">
                        <form method="post" action="/course/modify/${course.id}">
                            <td>${course.id}</td>
                            <td><input type="text" name="teacher" value="${course.teacher.name}"></td>
                            <td><input type="text" name="subject" value="${course.subject.name}"></td>
                            <td>${course.createdAt}</td>
                            <td colspan="2">
                                <button type="submit">수정 완료</button>
                            </td>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <td>${course.id}</td>
                        <td>${course.teacher.name}</td>
                        <td>${course.subject.name}</td>
                        <td>${course.createdAt}</td>
                        <td colspan="2">
                            <button onclick="location.href='/course/modify/' + ${course.getId()}">수정</button>
                        </td>
                    </c:otherwise>
                </c:choose>
                <td>
                    <button onclick="location.href='/course/delete/' + ${course.getId()}">삭제</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>