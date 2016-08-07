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
                <h1 class="page-header">Profile</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form action="/user-profile" method="post">
                                    <form:errors path="profileForm.*"  cssClass="alert alert-danger" element="div" />
                                    <div class="form-group">
                                        <label>Login</label>
                                        <input type="text" class="form-control" name="login" placeholder="Login" required autofocus value="${profileForm.login}" />
                                        <form:errors path="profileForm.login" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text" class="form-control" name="email" placeholder="Email" required autofocus value="${profileForm.email}" />
                                        <form:errors path="profileForm.email" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input type="text" class="form-control" name="firstName" placeholder="First Name" required autofocus value="${profileForm.firstName}" />
                                        <form:errors path="profileForm.firstName" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input type="text" class="form-control" name="lastName" placeholder="Last Name" required autofocus value="${profileForm.lastName}" />
                                        <form:errors path="profileForm.lastName" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Отправить</button>
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
