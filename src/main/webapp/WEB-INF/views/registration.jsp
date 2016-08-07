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
                <h1 class="page-header">Registration</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form action="/registration" method="post">
                                    <form:errors path="registrationForm."  cssClass="alert alert-danger" element="div" />
                                    <div class="form-group">
                                        <label for="login">Login</label>
                                        <input id="login" type="text" class="form-control" name="login" placeholder="Login" required autofocus value="${registrationForm.login}" />
                                        <form:errors path="registrationForm.login" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input id="email" type="text" class="form-control" name="email" placeholder="Email" required autofocus value="${registrationForm.email}" />
                                        <form:errors path="registrationForm.email" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input id="password" type="password" class="form-control" name="password" placeholder="Password" required value="${registrationForm.password}" />
                                        <form:errors path="registrationForm.password" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm_password">Confirm Password</label>
                                        <input id="confirm_password" type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" required value="${registrationForm.confirmPassword}" />
                                        <form:errors path="registrationForm.confirmPassword" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="role">Role</label>
                                        <select id="role" class="form-control" name="role">
                                            <option value="freelancer">Freelancer</option>
                                            <option value="employer">Employer</option>
                                        </select>
                                    </div>
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрироватся</button>
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
