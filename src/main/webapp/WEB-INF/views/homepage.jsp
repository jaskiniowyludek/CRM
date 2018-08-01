<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 31/07/18
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Lista projektów: </h3>
<ul>
    <c:forEach items="${projects}" var="project">
        <li>
                ${project.name} ${project.identifier} ${project.created}
            <a href="/project/details/${project.id}">Project's details</a>
        </li>
    </c:forEach>

</ul>

</body>
</html>
