<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 31/07/18
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form"
                 uri="http://www.springframework.org/tags/form"	%>

<html>
<head>
    <title>Add user</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:input path="name" placeholder="User's name"/>
    <form:errors path="name"/>
    <form:input path="surname" placeholder="User's surname"/>
    <form:errors path="surname"/>
    <form:input path="login" placeholder="login"/>
    <form:errors path="login"/>
    <form:password path="password" placegolder="password"/>
    <form:errors path="password"/>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
