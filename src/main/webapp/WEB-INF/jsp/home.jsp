<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>

<script>
    $(document).on("click", ".btn-delete", function () {
        var itemid= $(this).attr('data-item');
        $("#lineitem").attr({method:"POST", action: "${pageContext.request.contextPath}/book/delete/" + itemid})
    });
</script>

<body style="padding: 0 10rem; padding-bottom: 10rem">
    <jsp:include page="header.jsp" />
    <div class="home">
        <c:forEach items="${books}" var="book" varStatus="status">
            <div class="card" style="width:376px">
                <div class="container">
                    <img class="card-img-top" src="${book.image}" alt="Card image">
                    <div class="overlay">
                        <h3 class="card-title">${book.name}</h3>
                        <p class="card-text">
                            <c:forEach items="${book.authors}" var="author">
                                ${author.name}</br>
                            </c:forEach>
                        </p>
                        <p style="display: flex; justify-content: flex-end; font-size: .9rem"> ${book.publish.getDate()} - ${book.publish.getMonth() + 1} - ${book.publish.getYear() + 1900} </p>
                    </div>
                </div>

                <div class="card-body">
                    <div class="books_actions">
                        <a href="${pageContext.request.contextPath}/book/updateForm/${book.id}" class="btn btn-primary" style="margin-right: .5rem">Edit</a>
                        <a href="#" class="btn btn-primary btn-delete" data-item="${book.id}" data-toggle="modal" data-target="#exampleModalCenter">Delete</a>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Delete book</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Do you wanna delete this book?
                        </div>
                        <form method="post" class="modal-footer" id="lineitem">
                            <a href="#" class="btn btn-secondary" data-dismiss="modal">Close</a>
                            <button class="btn btn-primary">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
