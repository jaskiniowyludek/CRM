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
    <title>List of priorities</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/priority/add">Add priority</a></p>
<ul>
    <c:forEach items="${priorities}" var="priority">
        <li>
                ${priority.name}
            <a href="/priority/edit/${priority.id}">Edit priority</a>
            <a href="/priority/deleteConfirm/${priority.id}">Delete priority</a>
        </li>
    </c:forEach>

</ul>
<p><a href="${pageContext.request.contextPath}/admin/">Return</a></p>
</body>
</html>