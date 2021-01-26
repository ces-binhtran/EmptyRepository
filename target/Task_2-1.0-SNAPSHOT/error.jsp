<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/1/2021
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <c:import url="WEB-INF/views/header.jsp"><c:param name="title" value="Home page" /></c:import>
    <div class="row">
        Something went wrong
    </div>
    <c:import url="WEB-INF/views/footer.jsp"></c:import>
</div>
</body>
</html>
