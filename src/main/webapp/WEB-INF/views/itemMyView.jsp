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
            <th>checkbox</th>
        </tr>
        <tr>
            <th><c:out value="${id}"/></th>
            <th><c:out value="${userId}"/></th>
            <th><c:out value="${name}"/></th>
            <th><c:out value="${description}"/></th>
            <th><fmt:formatDate pattern="yyyy-MM-dd H-m-s"
                                value="${creating}" /></th>
            <th><c:out value="${listItems}"/></th>
            <th>checkbox</th>
        </tr>
    </table>
    <form action="<%=request.getContextPath() %>/item-my-view" method="post">
        <table width="100%">
            <c:forEach var="item" items="${items}">
                <%-- <c:if test="${id != item.getId()}">--%>
                <tr>
                    <td><a href="/item-my-view?id=<c:out value="${item.getId()}"/>"><c:out value="${item.getId()}"/></a></td>
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
                    <td>
                        <c:if test="${(userId == item.getUserId()) || (role == 'ADMIN')}">
                            <input type="checkbox" name="item" value="<c:out value="${item.getId()}"/>">
                        </c:if>
                    </td>
                </tr>
                <%--</c:if>--%>
            </c:forEach>
        </table>
        <input type="hidden" name="id" value="<c:out value="${id}"/>">
        <input type="submit" name="delete" value="Delete">
    </form>
    <%
        if(session.getAttribute("sessionItems")!=null){
    %>
        <form action="<%=request.getContextPath() %>/item-my-view" method="post">
            <input type="hidden" name="id" value="<c:out value="${id}"/>">
            <input type="submit" name="insert" value="Insert">
        </form>
    <%
        }
    %>
    <%@include file="blocks/footer.jsp" %>
</body>
</html>
