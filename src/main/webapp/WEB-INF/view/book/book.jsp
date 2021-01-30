<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 20/01/2021
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
    <%@include file="../common/reset_font.jsp"%>
    <link rel="stylesheet" href="/static/css/book.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<div class="content">
    <%@include file="../common/sidebar.jsp"%>
    <div class="content_right">
        <div class="book__action">
            <a href="create"> Add more Book</a>
            <a href="author/create"> Add more Author</a>
        </div>
        <div class="book_list" >
            <c:forEach var="book" items="${books}" varStatus="status">
                <a class="book_item" href="/book/edit/${book.id}">
                    <div class="book_item__image">
                        <img src="https://images-na.ssl-images-amazon.com/images/I/41jk+Ueey9L._SX348_BO1,204,203,200_.jpg" alt="book"/>
                    </div>
                    <div class="book_item__name">${book.name}</div>
<%--                    <div class="book_item__author">Kathy Sierra - Bert Bates</div>--%>
                    <div>${authorsOfBooks.get(status.index)}</div>
                </a>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>

