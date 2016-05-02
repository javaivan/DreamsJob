<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item</title>
</head>
<body>
    <%@include file="/WEB-INF/views/blocks/header.jsp" %>
    <table width="100%">
        <tr>
            <th>Id</th>
            <th>user</th>
            <th>name</th>
            <th>description</th>
            <th>creating</th>
            <th>Children</th>
        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td><a href="${pageContext.servletContext.contextPath}/item-user-view?id=<c:out value="${item.getId()}"/>"><c:out value="${item.getId()}"/></a></td>
                <td><c:out value="${item.getUser()}"/></td>
                <td><c:out value="${item.getName()}"/></td>
                <td><c:out value="${item.getDescription()}"/></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd H-m-s"
                                    value="${item.getCreating()}" /></td>
                <td><c:out value="${item.getChildren()}"/></td>
            </tr>
        </c:forEach>
    </table>
    <%@include file="/WEB-INF/views/blocks/footer.jsp" %>
</body>
</html>
