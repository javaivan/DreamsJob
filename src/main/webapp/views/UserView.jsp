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
</head>
<body>
    <table>
        <tr>
            <th>Id</th>
            <th>Login</th>
        </tr>
        <% for (User user : UserService.getInstance().getAll()){ %>
        <tr>
            <td> <%= user.getId() %></td>
            <td> <%= user.getLogin() %></td>
        </tr>
        <% } %>
    </table>
<form action="<%=request.getContextPath()%>/user" method="post">
    ID:<input name="id" type="text">
    Name:<input name="name" type="text">
    <input type="submit" value="submit" />
</form>
</body>
</html>
