<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<%@include file="/blocks/header.jsp" %>
    <table width="100%">
        <tr>
            <th>Id</th>
            <th>Login</th>
            <th>Password</th>
            <th>Role</th>
            <th></th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.getId()}"/></td>
                <td><a href="<%=request.getContextPath()%>/user?id=<c:out value="${user.getId()}"/>"><c:out value="${user.getLogin()}"/></a></td>
                <td><c:out value="${user.getPassword()}"/></td>
                <td><c:out value="${user.getRole()}"/></td>
                <td>
                    <form action="<%=request.getContextPath()%>/user-all" method="post">
                        <input name="id" type="hidden" value="<c:out value="${user.getId()}"/>">
                        <input type="submit" value="deleted" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
