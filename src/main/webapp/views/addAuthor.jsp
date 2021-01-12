<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2021
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
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
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</body>
</html>
