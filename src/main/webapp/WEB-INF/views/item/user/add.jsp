<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item</title>
</head>
<body>
    <%@include file="/WEB-INF/views/blocks/header.jsp" %>
    <form action="${pageContext.servletContext.contextPath}/item/user/add" method="post">
        Name:<input name="name" type="text"><br>
        Description:<input name="description" type="text"><br>
        <input type="submit" value="submit" />
    </form>
    <%@include file="/WEB-INF/views/blocks/footer.jsp" %>
</body>
</html>
