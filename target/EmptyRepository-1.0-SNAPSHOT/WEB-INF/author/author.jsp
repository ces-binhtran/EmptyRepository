<%@ page import="com.tranhiep.util.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/5/2021
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authors</title>
    <link rel="stylesheet" href="assests/css/book.css">
    <%@include file="../common/context_path.jsp"%>
</head>
<body>
<%@include file="../common/header.jsp"%>
<c:set var="rootPath" value="<%= Utils.rootPath%>" scope="request"></c:set>
<div class="title">
    <div class="title--left">
        <h2 style="text-align: center;">List Author</h2>
    </div>
    <div class="title-right">
        <div class="action">
            <a href="author_action"><i class="fas fa-plus"></i>Add Author</a>
        </div>
    </div>
</div>
<div class="table_container">
    <table class="table">
        <thead>
        <tr>
            <th width="5%">Index</th>
            <th width="45%">Name</th>
            <th width="45%">Books</th>
        </tr>
        </thead>
        <tbody id="table--body">
        <c:forEach var="author" items="${authors}" varStatus="status">
            <tr id="${author.id}">
                <td >${status.index + 1}</td>
                <td style="text-align: center">${author.name}</td>
                <td style="text-align: center">

                    <c:choose>
                        <c:when test="${author.books.size() == 0}">
                            <p style="font-style: italic">None</p>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="book" items="${author.books}">
                                <p>${book.name}</p>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="assests/js/book.js"></script>
</html>
