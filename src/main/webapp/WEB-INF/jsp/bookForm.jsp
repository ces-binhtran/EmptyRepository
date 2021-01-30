<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bookForm.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body style="padding: 0 10rem 10rem 10rem;">
<jsp:include page="header.jsp" />

<c:if test="${book.id != null}">
    <c:set value="${pageContext.request.contextPath}/book/update/${book.id}" var="action"/>
</c:if>
<c:if test="${book.id == null}">
    <c:set value="${pageContext.request.contextPath}/book/save" var="action"/>
</c:if>

<h1 style="text-align: center; margin-top: 1rem">Create book</h1>
<div class="create_book">
    <form:form action="${action}" modelAttribute="book"  method="post">
        <div class="form-group">
            <div style="display: flex; justify-content: space-between">
                <label for="name">Name:</label>
                <form:errors path="name" cssStyle="color: red"/>
            </div>
            <form:input
                type="text"
                path="name"
                class="form-control"
                placeholder="Enter book's name"
                id="name"
            />
        </div>
        <div class="form-group">
            <label for="image">Thumbnail:</label>
            <form:input type="text" path="image" class="form-control" placeholder="Enter book's thumbnail" id="image" />
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <form:input type="number" path="price" class="form-control" placeholder="Enter price" id="price" />
        </div>
        <div class="form-group">
            <label for="publish">Publish:</label>
            <form:input type="date" path="publish" class="form-control" id="publish" />
        </div>
        <div class="form-group">
            <label for="publish">Author: </label><a href="<c:url value="/author/create"/>" style="color: #007BFF">(Add author)</a>
            <div class="checkbox">
                <c:forEach var="author" items="${authors}" varStatus="varStatus">
                    <label>
                        <input
                                type="checkbox"
                                name="author"
                                value="${author.id}"
                                <c:if test="${book != null}">
                                    <c:forEach var="ele" items="${book.authors}">
                                        <c:if test="${author.id == ele.id}">
                                                checked="checked"
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                        > ${author.name}
                    </label></br>
                </c:forEach>

            </div>
        </div>

        <a href="<c:url value="/book"/>" class="btn btn-secondary" data-dismiss="modal">Close</a>
        <button style="background-color: #007BFF; color: white" type="submit" class="btn btn-default">Submit</button>
    </form:form>
</div>
</body>
</html>
