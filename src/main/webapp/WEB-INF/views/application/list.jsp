<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Applications</title>
</head>
<body>
    <%@include file="/WEB-INF/views/blocks/header.jsp" %>
    <table width="100%">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>description</th>
            <th>Update</th>
        </tr>
        <c:forEach var="application" items="${applications}">
            <tr>
                <td><a href="${pageContext.servletContext.contextPath}/application?id=<c:out value="${application.getId()}"/>"><c:out value="${application.getId()}"/></a></td>
                <td><c:out value="${application.getTitle()}"/></td>
                <td><c:out value="${application.getDescription()}"/></td>
                <td><a href="${pageContext.servletContext.contextPath}/application-update?id=<c:out value="${application.getId()}"/>">Update</a></td>
            </tr>
        </c:forEach>
    </table>
    <%@include file="/WEB-INF/views/blocks/footer.jsp" %>
</body>
</html>
