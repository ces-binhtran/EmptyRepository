<%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 20/01/2021
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/static/css/sidebar.css">
</head>
<body>
<div class="side-bar">
    <div class="type">

        <div class="type__header">
            <span>Type</span>
            <i class="fas fa-book"></i>
        </div>
        <div class="type__list">
            <c:forEach var="type" items="${types}">
                <a class="type__item" href="/book/type?type=${type.id}">
                    <span>${type.name}</span>
                    <i class="fab fa-java"></i>
                </a>
            </c:forEach>


        </div>
    </div>
</div>

</body>
</html>
