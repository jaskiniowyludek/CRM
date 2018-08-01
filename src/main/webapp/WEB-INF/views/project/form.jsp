<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 31/07/18
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form"
                 uri="http://www.springframework.org/tags/form"	%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="project">
    <form:input path="name" placeholder="Project's name"/>
    <form:errors path="name"/>
    <form:textarea path="description" placeholder="Please, describe the project"/>
    <form:errors path="description"/>
    <form:input path="url" placeholder="website address"/>
    <form:errors path="url"/>
    <form:select path="users"
                 items="${usersmodel}"
                 itemValue="id"
                 itemLabel="login"
                 multiple="true"/>
    <form:errors path="users"/>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
