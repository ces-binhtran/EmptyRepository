<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="assests/css/header.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <%@include file="./context_path.jsp"%>
</head>
<body>
    <div class="header">
        <div class="header--left">
            <h2>Task2</h2>
        </div>
        <div class="header--center">
            <ul class="header--features">
                <li><a href="Book">Books</a></li>
                <li><a href="Author">Authors</a></li>
            </ul>
        </div>
    </div>
</body>
<script src="assests/js/book.js"></script>
</html>
