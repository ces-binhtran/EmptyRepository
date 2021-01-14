<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="views/css/addBook.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body class="add_book">
    <c:if test="${book != null}">
        <h1>Update Book</h1>
    </c:if>
    <c:if test="${book == null}">
        <h1>New Book</h1>
    </c:if>
    <form
        <c:if test="${book != null}">
            action="${pageContext.servletContext.contextPath}/Book?type=update&id=${book.id}"
        </c:if>
        <c:if test="${book == null}">
            action="${pageContext.servletContext.contextPath}/Book?type=create"
        </c:if>
        method="post"
        class="add_book__form"
    >
        <div class="form-group book_name">
            <label for="name">Book's Name:</label>
            <input
                type="name"
                class="form-control"
                id="name"
                name="name"
                <c:if test="${book != null}">
                        value="${book.name}"
                </c:if>
            >
            <c:if test="${error != null}">
                <div class="alert alert-danger add_book__alert">
                    <strong>Danger!</strong> ${error}
                </div>
            </c:if>
        </div>
        <div class="row">
            <a href="views/addAuthor.jsp">Add Author</a>
        </div>
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
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</body>
</html>
