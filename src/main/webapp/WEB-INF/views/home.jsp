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
                <h1 class="page-header">New Project</h1>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Last Project
                    </div>
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>title</th>
                                        <th>description</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${projects}" var="project" varStatus="status">
                                        <tr class="gradeA">
                                            <td>
                                                <a href="/project/<c:out value="${project.id}"/>"><c:out value="${project.title}"/></a>
                                            </td>
                                            <td><c:out value="${project.description}"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        New Employers
                    </div>
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Login</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${employers}" var="employer" varStatus="status">
                                    <tr class="gradeA">
                                        <td><c:out value="${employer.user.id}"/></td>
                                        <td><c:out value="${employer.user.login}"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        New Freelancers
                    </div>
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Login</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${freelancers}" var="freelancer" varStatus="status">
                                    <tr class="gradeA">
                                        <td><c:out value="${freelancer.user.id}"/></td>
                                        <td><c:out value="${freelancer.user.login}"/></td>
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
