<%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 21/01/2021
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create</title>
    <%@include file="../common/reset_font.jsp"%>

</head>
<body>
<f:form id="form" modelAttribute="book" cssStyle="width: 500px" cssClass="mx-auto">
    <div hidden id="bookId" value="${book.id}"></div>
    <h1 class="mb-5">
        <c:choose>
            <c:when test="${createMode}">Create Book</c:when>
            <c:otherwise>Edit book</c:otherwise>
        </c:choose>
    </h1>
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <f:input type="text" path="name" class="form-control"  placeholder="Enter name..."/>
        <f:errors cssClass="alert alert-danger mt-1" path="name" element="div"/>
    </div>
    <div class="mb-3">
        <label for="type" class="form-label">Type</label>
        <f:select id="type" class="form-control" path="type.id">
            <option value="0">Select one type...</option>
            <f:options items="${types}" itemLabel="name" itemValue="id"></f:options>
        </f:select>
        <f:errors path="type.id" element="div" cssClass="alert alert-danger mt-1" />
    </div>
    <div class="mb-3">
        <label for="bookImage">Image</label>
        <input type="file" class="form-control-file" id="bookImage">
    </div>
    <div class="mb-3">
        <div class="mb-1" style="position: relative">
            <label for="author_input_search">Author</label>
            <input type="text" class="form-control" oninput="onInputHandler(this)" id="author_input_search"name="author" placeholder="Add more author..." autocomplete="off">
            <ul class="list-group" id="author_list_dropdown" style="position: absolute; z-index: 1; width: 100%">
                <%--author item dropdown--%>
            </ul>
        </div>

        <ul class="list-group" id="author_list">
                <%--author of current book--%>
        </ul>
    </div>
    <button type="button" class="btn btn-primary" onclick="onSummitFormHandler()">Submit</button>
</f:form>
</body>

<script src="/static/js/book/create_edit.js"></script>
</html>
