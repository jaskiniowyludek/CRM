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
    <title>All projects</title>
</head>
<body>
<%--<p><a href="${pageContext.request.contextPath}/article/form">Add article</a></p>--%>
<ul>
    <c:forEach items="${projects}" var="project">
        <li>
                ${project.created} ${project.name} ${project.identifier}
            <a href="/task/list/${project.id}">Tasks list</a>
            <a href="/project/details/${project.id}">Project's details</a>
            <a href="project/edit/${project.id}">Edit project</a>
        </li>
    </c:forEach>

</ul>
</body>
</html>
