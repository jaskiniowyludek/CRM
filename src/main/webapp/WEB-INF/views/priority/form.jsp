<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 31/07/18
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form"
                 uri="http://www.springframework.org/tags/form"	%>

<html>
<head>
    <title>Add priority</title>
</head>
<body>
<form:form method="post" modelAttribute="priority">
    <form:input path="name" placeholder="Please, type priority's name"/>
    <form:errors path="name"/>
    <form:checkbox path="active" value="true"/>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
