<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item</title>
</head>
<body>
<%@include file="/blocks/header.jsp" %>
        <table width="100%">
            <tr>
                <th>Id</th>
                <th>User Id</th>
                <th>name</th>
                <th>description</th>
                <th>checkbox</th>
            </tr>
            <tr>
                <td><a href="/item-view?id=<c:out value="${id}"/>"><c:out value="${id}"/></a></td>
                <td><c:out value="${userId}"/></td>
                <td><c:out value="${name}"/></td>
                <td><c:out value="${description}"/></td>
                <th>checkbox</th>
            </tr>
        </table>
        <% if(session.getAttribute("item"+request.getAttribute("id"))!=null){ %>
                <form action="<%=request.getContextPath() %>/item-view" method="post">
                    <table width="100%">
                        <c:forEach var="item" items="${items}">
                           <%-- <c:if test="${id != item.getId()}">--%>
                                <tr>
                                    <td><a href="/item-view?id=<c:out value="${item.getId()}"/>"><c:out value="${item.getId()}"/></a></td>
                                    <td><c:out value="${item.getUserId()}"/></td>
                                    <td><c:out value="${item.getName()}"/></td>
                                    <td><c:out value="${item.getDescription()}"/></td>
                                    <td><input type="checkbox" name="item" value="<c:out value="${item.getId()}"/>"></td>
                                </tr>
                            <%--</c:if>--%>
                        </c:forEach>
                    </table>
                    <input type="hidden" name="id" value="<c:out value="${id}"/>">
                    <input type="submit" name="delete" value="Delete">
                </form>
        <% } %>
        <% if(session.getAttribute("selectedItems")!=null){ %>
                    <form action="<%=request.getContextPath() %>/item-view" method="post">
                        <input type="hidden" name="id" value="<c:out value="${id}"/>">
                        <input type="submit" name="insert" value="Insert">
                    </form>
        <% } %>
<%@include file="/blocks/footer.jsp" %>
</body>
</html>
