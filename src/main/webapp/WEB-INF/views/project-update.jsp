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
                <h1 class="page-header">Update Project</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form action="/project/update" method="post">
                                    <div class="form-group">
                                        <label>Imagas</label>
                                        <a class="btn btn-primary" id=""  href="javascript:edit.showUploadDialog();">Upload Imagas</a>
                                    </div>

                                    <input type="hidden" name="id" required value="${project.id}" />
                                    <div class="form-group">
                                        <label for="title">Title</label>
                                        <input id="title" type="text" class="form-control" name="title" placeholder="Title" required autofocus value="${project.title}" />
                                        <form:errors path="project.title" cssClass="alert alert-danger" element="div" />
                                        <form:errors path="project.id" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="status">Status</label>
                                        <select name="status" id="status" class="form-control" >
                                            <c:forEach items="${status}" var="state">
                                                <option <c:if test="${state.equals(project.status)}">selected</c:if> value="${state}">${state}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="description">Description</label>
                                        <textarea id="description" class="form-control" name="description" rows="3">${project.description}</textarea>
                                        <form:errors path="project.description" cssClass="alert alert-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <button class="btn btn-lg btn-primary btn-block" type="submit">Добавить</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <c:if test="${not empty project.images}">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Images</div>
                                        <div class="panel-body">
                                            <c:forEach items="${project.images}" var="image" >
                                                <p>
                                                    <c:out value="${image.big}"/>
                                                    <span class="deleted_image" image_id="<c:out value="${image.id}"/>" >delet</span>
                                                </p>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/section/footerJs.jsp" %>

    <form:form action="/project/add-image/{id}" method="POST" commandName="projectImage" enctype="multipart/form-data">
    <div id="photoUploaderBox" class="modal fade" role="dialog" >
        <input type="hidden" name="project_id" id="project_id" required value="${project.id}" />
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Загрузить Фотографию</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12 form-group">
                            <input id="image" name="image" type="file" multiple placeholder="Выберите файл-картинку" >
                        </div>
                        <div class="col-xs-12 text-center">
                            <a href="javascript:edit.addImage()" class="btn btn-primary" >Загрузить Фотографию</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form:form>

</body>
</html>
