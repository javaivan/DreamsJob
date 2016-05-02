<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item</title>
</head>
<body>
    <%@include file="/WEB-INF/views/blocks/header.jsp" %>
    <form action="<%=request.getContextPath() %>/item-user-view" method="post">

        Name:
        <br>
        <input name="name" type="name" value="<c:out value="${item.getName()}"/>">

        <hr>
        Description:
        <br>
        <textarea name="description"><c:out value="${item.getDescription()}"/></textarea>

        <hr>
        Parent:<c:out value="${item.getParent()}"/>
        <br>
        <select name="parent">
            <option value="0">select</option>
            <c:forEach items="${items}" var="i">
                <option value="<c:out value="${i.getId()}" />"><c:out value="${i.getName()}" /></option>
            </c:forEach>
        </select>
        <hr>

        <input type="submit" value="submit" />
        <input name="itemId" type="hidden" value="<c:out value="${item.getId()}"/>">
    </form>
    <%@include file="/WEB-INF/views/blocks/footer.jsp" %>
</body>
</html>
