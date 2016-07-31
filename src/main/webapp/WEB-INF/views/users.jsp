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
                <h1 class="page-header">ALL Project</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        ALL Project
                    </div>
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
                                        <th>lastName</th>
                                        <th>created</th>
                                        <th>type</th>
                                        <th>status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user" varStatus="status">
                                        <tr class="gradeA">
                                            <td><c:out value="${user.id}"/></td>
                                            <td><c:out value="${user.login}"/></td>
                                            <td><c:out value="${user.email}"/></td>
                                            <td><c:out value="${user.password}"/></td>
                                            <td><c:out value="${user.firstName}"/></td>
                                            <td><c:out value="${user.lastName}"/></td>
                                            <td><c:out value="${user.created}"/></td>
                                            <td><c:out value="${user.type}"/></td>
                                            <td><c:out value="${user.status}"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/section/footerJs.jsp" %>
</body>
</html>
