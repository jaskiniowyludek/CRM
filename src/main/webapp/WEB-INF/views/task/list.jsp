<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 31/07/18
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All tasks</title>
</head>
<body>
<ul>
    <c:forEach items="${tasks}" var="task">
        <li>
                ${task.subject} ${task.created} ${task.user}
            <a href="/task/details/${task.id}">Task's details</a>
            <a href="/task/edit/${task.id}">Edit task</a>
        </li>
    </c:forEach>

</ul>
</body>
</html>
