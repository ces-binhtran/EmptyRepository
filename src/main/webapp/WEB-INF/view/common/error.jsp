<%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 27/01/2021
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <%@include file="../common/reset_font.jsp"%>
</head>
<body style=" background: #E9EAEA" class="d-flex justify-content-center align-items-center w-100 h-100">
    <div class="container d-flex justify-content-center align-item-center align-items-center flex-column">
        <div><i class="fas fa-exclamation-triangle mb-3 " style="color: #DBDEEB; font-size: 200px;"></i></div>
        <p class="fs-1 text-danger" style="color: #4E4D4F;">Server error: </p>
        <p class="fs-4 "><span class="fs-3 text-muted">Cause:</span> ${exception.message}</p>
    </div>
</body>
</html>
