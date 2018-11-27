<%--
  Created by IntelliJ IDEA.
  User: saber
  Date: 2018/11/24
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <c:choose>
        <c:when test="${not empty userList}">
            <c:forEach items="${userList}" var="user" varStatus="vs">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="2">无数据!</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>

