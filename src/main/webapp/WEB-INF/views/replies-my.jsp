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
                <h1 class="page-header">My Project Replies</h1>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${replies}" var="reply" >
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <c:out value="${reply.id}"/>
                        </div>
                        <div class="panel-body">
                            <p><c:out value="${reply.reply}"/></p>
                        </div>
                        <div class="panel-footer">
                            <a href="/project/<c:out value="${reply.project}"/>"><c:out value="${reply.project}"/></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/section/footerJs.jsp" %>
</body>
</html>
