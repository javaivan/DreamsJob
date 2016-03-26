<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item</title>
</head>
<body>
<%@include file="/blocks/header.jsp" %>
    <form action="<%=request.getContextPath()%>/item" method="post">
        ID:<input name="id" type="text"><br>
        Name:<input name="name" type="text"><br>
        Description:<input name="description" type="text"><br>
        <input type="submit" value="submit" />
    </form>
    <table width="100%">
        <tr>
            <th>Id</th>
            <th>User Id</th>
            <th>name</th>
            <th>description</th>
        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td><c:out value="${item.getId()}"/></td>
                <td><c:out value="${item.getUserId()}"/></td>
                <td><c:out value="${item.getName()}"/></td>
                <td><c:out value="${item.getDescription()}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
