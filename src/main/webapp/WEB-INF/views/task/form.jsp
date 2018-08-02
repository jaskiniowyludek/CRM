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
<form:form method="post" modelAttribute="task">
    <form:input path="subject" placeholder="Wpisz temat zadania"/>
    <form:errors path="subject"/>
    <form:textarea path="description" placeholder="Please, describe the task"/>
    <form:errors path="description"/>
    <form:select path="project.id"
                 items="${projects}"
                 itemValue="id"
                 itemLabel="name"/>
    <form:errors path="project"/>
    <form:select path="projectUser.id"
                 items="${users}"
                 itemValue="id"
                 itemLabel="login"/>
    <form:errors path="projectUser"/>
    <form:select path="status.id"
                 items="${statuses}"
                 itemValue="id"
                 itemLabel="name"/>
    <form:errors path="status"/>
    <form:select path="priority.id"
                 items="${priorities}"
                 itemValue="id"
                 itemLabel="name"/>
    <form:errors path="priority"/>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
