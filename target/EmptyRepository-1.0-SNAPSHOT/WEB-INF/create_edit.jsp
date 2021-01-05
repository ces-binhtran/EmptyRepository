<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/5/2021
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assests/css/create_edit.css">

</head>
<body>


<%--createMode varibale--%>
<c:if test="${empty param.id}" var="createMode" scope="request"></c:if>
<%---------------------------%>

<div class="title" align="center">
    <h2>
        <c:choose>
            <c:when test="${createMode}">
                Create Book
            </c:when>
            <c:otherwise>
                Edit book
            </c:otherwise>
        </c:choose>

    </h2>
</div>

<div class="form_container">
    <form class="form" action="book_action" method="post" onsubmit="return validate()">
        <c:if test="${!createMode}">
            <input type="hidden" name="id" value="${book.id}">
        </c:if>
        <div class="form--field">
            <label>Name (<span class="form--require">*</span>)</label>
            <div>
                <input name="name" placeholder="Name..." id="name" minlength="5" maxlength="50" value="${book.name}">
                <p class="form-error" id="form-error"></p>
            </div>
        </div>
        <div class="form--field">
            <label>Author</label>
            <div>
                <input name="author" placeholder="Author..."  id="author" value="${book.author}">
            </div>
        </div>
        <div class="form--action">
            <input type="submit" value="Submit"  id="submit">
            <a href="Book" >Cancel</a>
        </div>

    </form>
</div>

</body>
<script src="assests/js/create_edit.js"></script>
</html>
