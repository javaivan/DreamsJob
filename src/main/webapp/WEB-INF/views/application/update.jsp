<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application Add</title>
</head>
<body>
    <%@include file="/WEB-INF/views/blocks/header.jsp" %>
    <form action="${pageContext.servletContext.contextPath}/application-update" method="post">
        <input name="id" type="hidden" value="${application.getId()}">
        Title:<input name="title" type="text" value="${application.getTitle()}"><br>
        Description:<input name="description" type="text" value="${application.getDescription()}"><br>
        Parent: <select name="parent">
                    <option value="0">Select</option>
                    <c:forEach var="app" items="${applications}">
                        <option <c:if test="${app.getId() == application.getParent()}">selected</c:if>
                                value="<c:out value="${app.getId()}"/>"><c:out value="${app.getTitle()}"/></option>
                    </c:forEach>
                </select>
        <input type="submit" value="submit" />
    </form>
    <%@include file="/WEB-INF/views/blocks/footer.jsp" %>
</body>
</html>