<%@ page import="com.ivanmix.entity.Account" %>
<%@ page import="com.ivanmix.service.AccountService" %>
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
    <%@include file="blocks/header.jsp" %>
    <form action="${pageContext.servletContext.contextPath}/account-add" method="post">
        <input name="id" type="hidden" value="${account.id}">
        Login:<input name="login" type="text" value="${account.login}"><br>
        Password:<input name="password" type="text" value="${account.password}"><br>
        <input type="submit" value="submit" />
    </form>
    <%@include file="blocks/footer.jsp" %>
</body>
</html>
