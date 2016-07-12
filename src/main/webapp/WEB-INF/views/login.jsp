<%@ page import="com.ivanmix.model.User" %>
<%@ page import="com.ivanmix.service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DreamsJob Login</title>
</head>
<body>
    <%@include file="blocks/header.jsp" %><Br>
    <c:if test="${eroor_login != null}">
        <div style="background: #f00">
            ${eroor_login}
        </div>
    </c:if>
    <form action="${pageContext.servletContext.contextPath}/login" method="post">
        login: <input type="text" name="login"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Submit">
    </form>
    <%@include file="blocks/footer.jsp" %>
</body>
</html>
