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
    <title>Task's details</title>
</head>
<body>
<h3>Szczegóły zadania:</h3>
<ul>
    <li>Nazwa: ${task.subject}</li>
    <li>Data utworzenia: ${date}</li>
    <li>Opis: ${task.description}</li>
    <li>Aktualnie przydzielony użytkownik: ${task.projectUser.name}</li>
</ul>

</body>
</html>
