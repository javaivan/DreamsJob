<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item</title>
</head>
<body>
    <%@include file="blocks/header.jsp" %>
    <table width="100%">
        <tr>
            <th>Id</th>
            <th>User Id</th>
            <th>name</th>
            <th>description</th>
            <th>creating</th>
            <th>listItems</th>
        </tr>
        <tr>
            <th><a href="/item-public-view?id=<c:out value="${id}"/>"><c:out value="${id}"/></a></th>
            <th><c:out value="${userId}"/></th>
            <th><c:out value="${name}"/></th>
            <th><c:out value="${description}"/></th>
            <th><fmt:formatDate pattern="yyyy-MM-dd H-m-s"
                                value="${creating}" /></th>
            <th><c:out value="${listItems}"/></th>
        </tr>
        <c:forEach var="item" items="${items}">
            <%-- <c:if test="${id != item.getId()}">--%>
            <tr>
                <td><a href="/item-public-view?id=<c:out value="${item.getId()}"/>"><c:out value="${item.getId()}"/></a></td>
                <td><c:out value="${item.getUserId()}"/></td>
                <td><c:out value="${item.getName()}"/></td>
                <td><c:out value="${item.getDescription()}"/></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd H-m-s"
                                    value="${item.getCreating()}" /></td>
                <td>
                    <c:forEach items="${item.getListItems()}" var="itemId">
                        <c:out value="${itemId}" />,
                    </c:forEach>
                </td>
            </tr>
            <%--</c:if>--%>
        </c:forEach>
    </table>
    <%@include file="blocks/footer.jsp" %>
</body>
</html>
