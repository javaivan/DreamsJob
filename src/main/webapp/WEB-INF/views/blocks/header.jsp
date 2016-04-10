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
<link href="<%=request.getContextPath()%>/resources/css/main.css" rel="stylesheet" type="text/css">


 <%
     if(session.isNew() || (session.getAttribute("login")==null)){
         %>
            New User
        <%
     } else {
        %> Welcome back, <%=session.getAttribute("login")%>. <br>
            Role:  <%=session.getAttribute("role")%> <br>
            <a href="<%=request.getContextPath()%>/logout">Logout</a><br>
            <a href="<%=request.getContextPath()%>/item-my">My Items</a>
<%
     }
 %>

<ul>
    <li><a href="<%=request.getContextPath()%>/">Home</a></li>
    <%
        if(session.getAttribute("role")=="ADMIN"){
    %>
        <li><a href="<%=request.getContextPath()%>/user-add">Add User</a></li>
    <%
        }
    %>

    <li><a href="<%=request.getContextPath()%>/user-all">Users</a></li>
    <li><a href="<%=request.getContextPath()%>/item-public">All Item</a></li>
    <li><a href="<%=request.getContextPath()%>/count">Count</a></li>
</ul>
