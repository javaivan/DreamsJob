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
    <title>DreamsJob Login</title>
</head>
<body>
<%@include file="blocks/header.jsp" %>
<%

    Object error = request.getAttribute("eroor.login");
    if(error!=null){
        %>
            <div style="background: #f00">
                <%=error%>
            </div>
        <%
    }
%>
<form action="<%=request.getContextPath()%>/login" method="post">
    login: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
