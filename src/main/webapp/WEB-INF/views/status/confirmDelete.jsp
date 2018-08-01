<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 24/07/18
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form"
                 uri="http://www.springframework.org/tags/form"	%>
<html>
<head>
    <title>Are you sure you want to delete this status???</title>
</head>
<body>

Potwierdź usuniecie statusu o id ${id}
<a href="/status/delete/${id}">POTWIERDŹ </a>
<a href="/status"> ANULUJ</a>
</body>
</html>
