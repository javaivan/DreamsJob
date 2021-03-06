<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@include file="/WEB-INF/views/section/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dreams Job</title>
    <%@ include file="/WEB-INF/views/section/head.jsp" %>
</head>
<body>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/section/header.jsp" %>
        <div id="page-wrapper">
            <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Login</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form action="/security_check" method="post">
                                    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                        <div class="form-group has-error">
                                            <label class="control-label" for="inputError">There was error with your Login/Password combination. Please try again.</label>
                                        </div>
                                    </c:if>
                                    <div class="form-group">
                                        <label for="login">Login</label>
                                        <input id="login" type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="admin">
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input id="password" type="password" class="form-control" name="j_password" placeholder="Password" required value="123456">
                                    </div>
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/section/footerJs.jsp" %>
</body>
</html>
