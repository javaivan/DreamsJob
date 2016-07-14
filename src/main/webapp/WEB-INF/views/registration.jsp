<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Maven + Spring MVC</title>
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
                                <form role="form">
                                    <div class="form-group">
                                        <label>Login</label>
                                        <input type="text" name="login" class="form-control" placeholder="login">
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="email" name="email" class="form-control" placeholder="form">
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" name="password" class="form-control" placeholder="password">
                                    </div>
                                    <div class="form-group">
                                        <label>Type</label>
                                        <select name="type" class="form-control">
                                            <option value="freelancer" selected>Freelancer</option>
                                            <option value="employer">Employer</option>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-default">Submit</button>
                                </form>
                            </div>
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
