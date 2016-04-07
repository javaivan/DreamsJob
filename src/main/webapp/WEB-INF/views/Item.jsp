<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item</title>
</head>
<body>
<%@include file="blocks/header.jsp" %>
    <form action="<%=request.getContextPath()%>/item" method="post">
        ID:<input name="id" type="text"><br>
        Name:<input name="name" type="text"><br>
        Description:<input name="description" type="text"><br>
        <input type="submit" value="submit" />
    </form>
    <form action="<%=request.getContextPath() %>/item-view" method="post">
        <table width="100%">
            <tr>
                <th>Id</th>
                <th>User Id</th>
                <th>name</th>
                <th>description</th>
                <th>checkbox</th>
            </tr>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td><a href="/item-view?id=<c:out value="${item.getId()}"/>"><c:out value="${item.getId()}"/></a></td>
                    <td><c:out value="${item.getUserId()}"/></td>
                    <td><c:out value="${item.getName()}"/></td>
                    <td><c:out value="${item.getDescription()}"/></td>
                    <td><input type="checkbox" name="item" value="<c:out value="${item.getId()}"/>"></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" name="submit" value="Submit">
    </form>
<%@include file="blocks/footer.jsp" %>
</body>
</html>
