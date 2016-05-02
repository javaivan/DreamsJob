<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="/resources/css/bootstrap.min.css" %>
</style>
<style>
    <%@include file="/resources/css/grid.css" %>
</style>
<style>
    <%@include file="/resources/css/main.css" %>
</style>
<link rel="stylesheet" href="resources/css/main.css"/>
<link href="${pageContext.servletContext.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">

<c:choose>
    <c:when test="${sessionScope.login == null}">
        New User
    </c:when>
    <c:otherwise>
        Welcome back, ${sessionScope.login}. <br>
        Role:  <%=session.getAttribute("role")%> <br>
        <a href="${pageContext.servletContext.contextPath}/logout">Logout</a><br>
        <a href="${pageContext.servletContext.contextPath}/item-user-list">My Items</a><br>
        <a href="${pageContext.servletContext.contextPath}/item-user-add">add Items</a><br>
    </c:otherwise>
</c:choose>

<ul>
    <li><a href="<%=request.getContextPath()%>/">Home</a></li>
    <%
        if(session.getAttribute("role")=="ADMIN"){
    %>
        <li><a href="${pageContext.servletContext.contextPath}/user-add">Add User</a></li>
    <%
        }
    %>
    <li><a href="${pageContext.servletContext.contextPath}/user-all">Users</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/item-public-list">All Item</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/count">Count</a></li>
</ul>
