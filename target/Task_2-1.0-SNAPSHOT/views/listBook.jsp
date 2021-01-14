<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <c:import url="header.jsp"><c:param name="title" value="Home page" /></c:import>
    <form action="${pageContext.servletContext.contextPath}/Book?type=create-form" class="add_book__form" method="post">
        <button type="submit" class="btn btn-default">Add Book</button>
    </form>
    </br></br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Book</th>
            <th scope="col">Author</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}" varStatus="status">
                <tr>
                    <td>${book.name}</td>
                    <td>
                        <c:forEach var="author" items="${book.authors}" varStatus="status">
                            ${author.name} </br>
                        </c:forEach>
                    </td>
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/Book?id=${book.id}" method="post">
                            <input type="submit" name="type" value="Delete">
                            <input type="submit" name="type" value="Edit">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
