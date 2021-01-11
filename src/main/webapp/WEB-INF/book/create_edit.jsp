<%@ page import="com.tranhiep.util.Utils" %>
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
    <%@include file="../common/context_path.jsp"%>
</head>
<body>

<%@include file="../common/header.jsp"%>
<%--createMode varibale--%>
<c:set var="rootPath" value="<%= Utils.rootPath%>" scope="request"></c:set>
<c:if test="${empty param.bookId}" var="createMode" scope="request"></c:if>
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
    <form class="form" id="form">
        <c:if test="${!createMode}">
            <input type="hidden" name="id" value="${book.id}">
        </c:if>
        <div class="form--field">
            <label>Name (<span class="form--require">*</span>):</label>
            <div>
                <input name="name" placeholder="Name..." id="name" minlength="5" maxlength="50" value="${book.name}">
                <span class="form--error" id="form-error"></span>
            </div>
        </div>
        <div class="form--field">
            <label>Type:</label>
            <div>
                <input name="type" placeholder="Type..."  id="type" value="${book.type}">
            </div>
        </div>
        <div class="form--field">
            <label>Author:</label>
            <div id="author--list">
                <c:forEach var="authorOfBook" items="${book.authors}">
                    <div class="author--item" id="${authorOfBook.id}">
                        <input  type="text" name="authorOfBook" readonly value="${authorOfBook.name}">
                        <button type="button" onclick="deleteAuthorOfBook( ${authorOfBook.id}, ${book.id})">Delete</button>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="form--field" clas>
            <label>Add more Author: </label>
            <div>
                <select  id="author" onchange="addAuthorForBook('vanhip', 1)">

                </select>
            </div>
        </div>
        <div class="form--action">
            <input type="button" value="Submit"  id="submit" onclick="onSubmitHandler()">
            <a href="Book" >Cancel</a>
        </div>
    </form>
</div>


</body>
<script src="assests/js/create_edit.js"></script>
</html>
