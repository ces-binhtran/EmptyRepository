<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create</title>
    <%@include file="../common/reset_font.jsp"%>
</head>
<body>

<f:form action="../author" method="post" modelAttribute="author" cssStyle="width: 500px" cssClass="mx-auto">
    <h1 class="mb-5">Create Author</h1>
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <f:input type="text" path="name" class="form-control"  placeholder="Enter name..."/>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</f:form>
</body>
</html>
