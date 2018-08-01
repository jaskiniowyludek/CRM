<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 31/07/18
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/status/add">Add status</a></p>
<ul>
    <c:forEach items="${statuses}" var="status">
        <li>
                ${status.name} ${status.active} ${status.sortOrder}
            <a href="/status/edit/${status.id}">Edit status</a>
            <a href="/status/deleteConfirm/${status.id}">Delete status </a>
        </li>
    </c:forEach>

</ul>
</body>
</html>