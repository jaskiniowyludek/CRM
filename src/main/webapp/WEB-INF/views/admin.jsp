<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 1/08/18
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin view</title>
</head>
<body>

<p><a href="${pageContext.request.contextPath}/project/">See all projects</a></p>
<p><a href="${pageContext.request.contextPath}/project/add">Add new project</a></p>
<p><a href="${pageContext.request.contextPath}/user/">See all users</a></p>
<p><a href="${pageContext.request.contextPath}/user/add">Add new user</a></p>
<p><a href="${pageContext.request.contextPath}/status/">See all statuses</a></p>
<p><a href="${pageContext.request.contextPath}/status/add">Add new status</a></p>
<p><a href="${pageContext.request.contextPath}/priority/">See all priorities</a></p>
<p><a href="${pageContext.request.contextPath}/priority/add">Add new priority</a></p>
<p><a href="${pageContext.request.contextPath}/homepage/">Go to homepage</a></p>

</body>
</html>
