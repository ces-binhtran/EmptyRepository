<%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 18/01/2021
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/css/login.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
<div class="login">
    <div class="login__title"></div>
    <form class="form" action="" method="post">
        <input placeholder="Email..." name="email">
        <p id="name_error">* Some Think Error</p>
        <input placeholder="Password..." name="password" type="password">
        <p id="password_error">* </p>
        <input type="submit" value="LOGIN">
    </form>
</div>
</body>
</html>
