<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/addBook.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body class="add_book">
    <h1>New Book</h1>
    <form action="${pageContext.servletContext.contextPath}/Book?type=create" method="post" class="add_book__form">
        <div class="form-group">
            <label for="name">Book's Name:</label>
            <input type="name" class="form-control" id="name" name="name">
        </div>
        <div class="checkbox">
            <c:forEach var="author" items="${authors}" varStatus="varStatus">
                <label><input type="checkbox" name="author" value="${author}"> ${author.name} </label>
            </c:forEach>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</body>
</html>
