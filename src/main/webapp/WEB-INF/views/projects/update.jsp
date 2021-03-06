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
                                        <th>authorId</th>
                                        <th>title</th>
                                        <th>description</th>
                                        <th>created</th>
                                        <th>status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${projects}" var="project" varStatus="status">
                                        <tr class="gradeA">
                                            <td><a href="/project/<c:out value="${project.id}"/>"><c:out value="${project.id}"/></a></td>
                                            <td><c:out value="${project.user.id}"/></td>
                                            <td>
                                                <a href="/project/<c:out value="${project.id}"/>"><c:out value="${project.title}"/></a>
                                                <c:if test="${authorId.equals(project.user.id)}">
                                                    <br>
                                                    <a href="/project/update/<c:out value="${project.id}"/>">Update Project</a>
                                                </c:if>
                                            </td>
                                            <td><c:out value="${project.description}"/></td>
                                            <td><c:out value="${project.created}"/></td>
                                            <td><c:out value="${project.status}"/></td>
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
