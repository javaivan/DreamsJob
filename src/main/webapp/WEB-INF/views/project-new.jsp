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
                <h1 class="page-header">Project new</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form action="/project-new" method="post">
                                    <div class="form-group">
                                        <label for="title">Title</label>
                                        <input id="title" type="text" class="form-control" name="title" placeholder="Title" required autofocus value="${project.title}" />
                                        <form:errors path="project.title" cssClass="alert alert-danger" element="div" />
                                    </div>

                                    <div class="form-group">
                                        <label for="status">Status</label>
                                        <select name="status" id="status" class="form-control" >
                                            <c:forEach items="${status}" var="state">
                                                <option value="${state}">${state}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="description">Description</label>
                                        <textarea id="description" class="form-control" name="description" rows="3">${project.description}</textarea>
                                        <form:errors path="project.description" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Добавить</button>
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
