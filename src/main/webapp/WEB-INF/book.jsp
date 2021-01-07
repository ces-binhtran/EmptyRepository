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
    <title>Title</title>
    <link rel="stylesheet" href="assests/css/book.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

</head>
<body>
    <c:set var="rootPath" value="<%= Utils.rootPath%>" scope="request"></c:set>
    <h2 style="text-align: center;">List Book</h2>
    <div class="action_add">
        <a href="book_action"><i class="fas fa-plus"></i>Add book</a>
    </div>
    <div class="table_container">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Author</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody id="table--body">
            <c:forEach var="book" items="${books}" varStatus="status">
                <tr id="${book.id}">
                    <td>${book.name}</td>
                    <td>
                        <c:choose>
                            <c:when test="${book.authors.size == 0}">
                                <p style="font-style: italic">unknown</p>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="author" items="${book.authors}">
                                    <p>- ${author.name}</p>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </td>

                    <td class="table--action" style="text-align: center">
                        <a href="book_action?id=${book.id}" href="/"><i class="fas fa-edit"></i></a>
                        <a href="#" onclick="deleteBookAJAX(`${rootPath}`, ${book.id}); return false;"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
<script src="assests/js/book.js"></script>
</html>
