<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 31/07/18
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Project's details</title>
</head>
<body>
<h3>Szczegóły projektu:</h3>
<ul>
    <li>Data utworzenia: ${project.created}</li>
    <li>Nazwa: ${project.name}</li>
    <li>Identyfikator: ${project.identifier}</li>
    <li>Opis: ${project.description}</li>
    <li>Lista użytkowników: ${project.users}</li>
</ul>

</body>
</html>
