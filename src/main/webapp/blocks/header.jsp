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
     if(session.isNew()){
         %>
            New User
            <form action="<%=request.getContextPath()%>/login" method="post">
                login: <input type="text" name="login"><br>
                Password: <input type="password" name="password"><br>
                <input type="submit" value="Submit">
            </form>

        <%
     } else {
         %>Welcome back, <%=session.getAttribute("login")%>. <a href="<%=request.getContextPath()%>/logout">Logout</a><%
     }
 %>

<ul>
    <li><a href="<%=request.getContextPath()%>/">Home</a></li>
    <li><a href="<%=request.getContextPath()%>/user-add">Add User</a></li>
    <li><a href="<%=request.getContextPath()%>/user-all">Users</a></li>
    <li><a href="<%=request.getContextPath()%>/count">Count</a></li>
</ul>
