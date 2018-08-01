<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 31/07/18
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<p><a href="${pageContext.request.contextPath}/article/form">Add article</a></p>--%>
<ul>
    <c:forEach items="${users}" var="user">
        <li>
                ${user.name} ${user.surname} ${user.login}
            <a href="/user/edit/${user.id}">Edit user</a>
            <a href="/user/deleteConfirm/${user.id}">Delete user </a>
        </li>
    </c:forEach>

</ul>
</body>
</html>
