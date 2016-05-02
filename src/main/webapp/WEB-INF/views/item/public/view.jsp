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
            <th>User Id</th>
            <th>Parent</th>
            <th>name</th>
            <th>description</th>
            <th>creating</th>
            <th>listItems</th>
        </tr>
        <tr>
            <th><a href="${pageContext.servletContext.contextPath}/item-public-view?id=<c:out value="${item.getId()}"/>"><c:out value="${item.getId()}"/></a></th>
            <th><c:out value="${item.getUser()}"/></th>
            <th><c:out value="${item.getName()}"/></th>
            <th><c:out value="${item.getParent()}"/></th>
            <th><c:out value="${item.getDescription()}"/></th>
            <th><fmt:formatDate pattern="yyyy-MM-dd H-m-s"
                                value="${item.getCreating()}" /></th>
            <th><c:out value="${item.getChildren()}"/></th>
        </tr>
        <c:forEach var="item" items="${items}">
            <%-- <c:if test="${id != item.getId()}">--%>
            <tr>
                <td><a href="${pageContext.servletContext.contextPath}/item-public-view?id=<c:out value="${item.getId()}"/>"><c:out value="${item.getId()}"/></a></td>
                <td><c:out value="${item.getUser()}"/></td>
                <td><c:out value="${item.getParent()}"/></td>
                <td><c:out value="${item.getName()}"/></td>
                <td><c:out value="${item.getDescription()}"/></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd H-m-s"
                                    value="${item.getCreating()}" /></td>
                <td>
                    <c:forEach items="${item.getChildren()}" var="itemId">
                        <c:out value="${itemId}" />,
                    </c:forEach>
                </td>
            </tr>
            <%--</c:if>--%>
        </c:forEach>
    </table>
    <%@include file="/WEB-INF/views/blocks/footer.jsp" %>
</body>
</html>
