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
                <h1 class="page-header">Project</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading"><c:out value="${project.title}"/></div>
                    <div class="panel-body">
                       <p><c:out value="${project.description}"/></p>
                    </div>
                </div>
            </div>
        </div>

         <sec:authorize access="hasRole('ROLE_FREELANCER')">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Ответить на проэкт
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form action="/project-reply/<c:out value="${project.id}"/>" modelAttribute="projectReply" method="post">
                                        <div class="form-group">
                                            <label>Ответить</label>
                                            <textarea name="reply" class="form-control" rows="3"></textarea>
                                        </div>
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </sec:authorize>


        <div class="row">
            <c:forEach items="${replies}" var="reply" >
            <%--<c:forEach items="${project.replies}" var="reply" >--%>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <c:out value="${reply.id}"/>
                        </div>
                        <div class="panel-body">
                            <p><c:out value="${reply.reply}"/></p>
                        </div>
                    </div>
                </div>
               <%-- <c:forEach items="${reply.subProjectReply}" var="r" >
                    <c:out value="${r.id}"/><br>
                </c:forEach>--%>
            </c:forEach>
        </div>

    </div>
    <%@ include file="/WEB-INF/views/section/footerJs.jsp" %>
</body>
</html>
