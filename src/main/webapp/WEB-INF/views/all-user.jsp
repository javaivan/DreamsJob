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
                <h1 class="page-header">User</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        All User
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>login</th>
                                        <th>email</th>
                                        <th>password</th>
                                        <th>firstName</th>
                                        <th>LastName</th>
                                        <th>creared</th>
                                        <th>type</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="user" items="${users}" varStatus="status">
                                        <tr class="gradeA">
                                            <td>${user.id}</td>
                                            <td>${user.login}</td>
                                            <td>${user.email}</td>
                                            <td>${user.password}</td>
                                            <td>${user.firstName}</td>
                                            <td>${user.lastName}</td>
                                            <td>${user.creared}</td>
                                            <td>${user.type}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<%@ include file="/WEB-INF/views/section/footerJs.jsp" %>
</body>
</html>
