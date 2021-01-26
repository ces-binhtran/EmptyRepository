<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/authorForm.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body style="padding: 0 10rem 10rem 10rem;">
<jsp:include page="header.jsp" />
<h1 style="text-align: center; margin-top: 1rem">Create author</h1>
<div class="create_book">
    <form:form action="${pageContext.request.contextPath}/author/save" cssClass="was-validated" modelAttribute="author" method="post">
        <div class="form-group">
            <div style="display: flex; justify-content: space-between">
                <label for="name">Name:</label>
                <form:errors path="name" cssStyle="color: red"/>
            </div>
            <form:input path="name" type="text" class="form-control" placeholder="Enter name" id="name" />

        </div>
        <div class="form-group">
            <label for="birthday">Birthday:</label>
            <form:input path="birth" type="date" class="form-control" placeholder="Enter birthday" id="birthday" />
        </div>
        <div class="form-group">
            <div style="display: flex; justify-content: space-between">
                <label for="price">Email:</label>
                <form:errors path="email" cssStyle="color: red"/>
            </div>
            <form:input path="email" type="text" class="form-control" placeholder="Enter email" id="price" />
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form:form>
</div>
</body>
</html>
