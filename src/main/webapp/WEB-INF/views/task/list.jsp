<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 31/07/18
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/article/form">Add article</a></p>
<ul>
    <c:forEach items="${articles}" var="article">
        <li>
                ${article.title} ${article.content}
            <a href="/article/edit/${article.id}">Edit article</a>
            <a href="/article/delete/${article.id}">Delete article </a>
        </li>
    </c:forEach>

</ul>
</body>
</html>
