<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application Add</title>
</head>
<body>
    <%@include file="/WEB-INF/views/blocks/header.jsp" %>
    <form action="${pageContext.servletContext.contextPath}/application-add" method="post">
        Title:<input name="title" type="text"><br>
        Description:<input name="description" type="text"><br>
        Parent: <select name="parent">
                    <option value="0">Select</option>
                    <c:forEach var="application" items="${applications}">
                        <option value="<c:out value="${application.getId()}"/>"><c:out value="${application.getTitle()}"/></option>
                    </c:forEach>
                </select>
        <input type="submit" value="submit" />
    </form>
    <%@include file="/WEB-INF/views/blocks/footer.jsp" %>
</body>
</html>
