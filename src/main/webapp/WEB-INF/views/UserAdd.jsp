<%@ page import="com.ivanmix.model.User" %>
<%@ page import="com.ivanmix.service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: mix
  Date: 24.03.2016
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <style>
        <%@include file="/resources/css/bootstrap.min.css" %>
    </style>
    <style>
        <%@include file="/resources/css/grid.css" %>
    </style>
    <style>
        <%@include file="/resources/css/main.css" %>
    </style>
</head>
<body>
<%@include file="/blocks/header.jsp" %>
<form action="<%=request.getContextPath()%>/user-add" method="post">
    ID:<input name="id" type="text"><br>
    Name:<input name="name" type="text"><br>
    Password:<input name="password" type="password"><br>
    <input type="submit" value="submit" />
</form>
<%@include file="blocks/footer.jsp" %>
</body>
</html>
