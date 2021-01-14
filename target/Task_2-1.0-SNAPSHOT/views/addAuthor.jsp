<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/addAuthor.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body class="add_author">
<h1>New Author</h1></br></br>
    <form action="${pageContext.servletContext.contextPath}/Author" class="add_author__form" method="post">
        <div class="form-group">
            <label for="name">Author's Name:</label>
            <input type="name" class="form-control" id="name" name="name" placeholder="Enter name">
            <c:if test="${error != ''}">
                <div class="alert alert-danger add_book__alert">
                    <strong>Danger!</strong> ${error}
                </div>
            </c:if>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</body>
</html>
