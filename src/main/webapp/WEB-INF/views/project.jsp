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
                    <div class="panel-heading">
                        <c:out value="${project.title}"/>
                        <sec:authorize access="hasRole('ROLE_FREELANCER')">
                            <button
                                    class="pull-right btn btn-primary btn_project_replies"
                                    data-toggle="modal"
                                    project-replies="<c:out value=""/>"
                                    data-target="#projectReplies">
                                Ответить
                            </button>
                        </sec:authorize>
                        </br></br>
                    </div>
                    <div class="panel-body">
                       <p><c:out value="${project.description}"/></p>
                    </div>
                </div>
            </div>
        </div>

<%--         <sec:authorize access="hasRole('ROLE_FREELANCER')">
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
        </sec:authorize>--%>
        <div class="row">
            <c:forEach items="${project.replies}" var="replyOne" >
                <c:if test="${empty replyOne.parent}">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <c:out value="${replyOne.id}"/>
                                <sec:authorize access="hasRole('ROLE_FREELANCER')">
                                    <button
                                            class="pull-right btn btn-primary btn_project_replies"
                                            data-toggle="modal"
                                            project-replies="<c:out value="${replyOne.id}"/>"
                                            data-target="#replies">
                                        Ответить
                                    </button>
                                    </br></br>
                                </sec:authorize>
                            </div>
                            <div class="panel-body">
                                <p><c:out value="${replyOne.reply}"/></p>
                                <c:if test="${not empty replyOne.children}">
                                    <div class="row">
                                        <c:forEach items="${replyOne.children}" var="replyTwo" >
                                            <div class="col-lg-12">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <c:out value="${replyTwo.id}"/>
                                                        <sec:authorize access="hasRole('ROLE_FREELANCER')">
                                                            <button
                                                                    class="pull-right btn btn-primary btn_project_replies"
                                                                    data-toggle="modal"
                                                                    project-replies="<c:out value="${replyTwo.id}"/>"
                                                                    data-target="#replies">
                                                                Ответить
                                                            </button>
                                                            </br></br>
                                                        </sec:authorize>
                                                    </div>
                                                    <div class="panel-body">
                                                        <p><c:out value="${replyTwo.reply}"/></p>
                                                        <c:if test="${not empty replyTwo.children}">
                                                            <div class="row">
                                                                <c:forEach items="${replyTwo.children}" var="replyTree" >
                                                                    <div class="col-lg-12">
                                                                        <div class="panel panel-default">
                                                                            <div class="panel-heading">
                                                                                <c:out value="${replyTree.id}"/>
                                                                                <sec:authorize access="hasRole('ROLE_FREELANCER')">
                                                                                    <button
                                                                                            class="pull-right btn btn-primary btn_project_replies"
                                                                                            data-toggle="modal"
                                                                                            project-replies="<c:out value="${replyTree.id}"/>"
                                                                                            data-target="#replies">
                                                                                        Ответить
                                                                                    </button>
                                                                                    </br></br>
                                                                                </sec:authorize>
                                                                            </div>
                                                                            <div class="panel-body">
                                                                                <p><c:out value="${replyTree.reply}"/></p>
                                                                                <c:if test="${not empty replyTree.children}">
                                                                                    <div class="row">
                                                                                        <c:forEach items="${replyTree.children}" var="replyFour" >
                                                                                            <div class="col-lg-12">
                                                                                                <div class="panel panel-default">
                                                                                                    <div class="panel-heading">
                                                                                                        <c:out value="${replyFour.id}"/>
                                                                                                    </div>
                                                                                                    <div class="panel-body">
                                                                                                        <p><c:out value="${replyFour.reply}"/></p>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                        </c:forEach>
                                                                                    </div>
                                                                                </c:if>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </c:forEach>
                                                            </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/section/footerJs.jsp" %>
    <sec:authorize access="hasRole('ROLE_FREELANCER')">
        <div class="modal fade" id="replies" tabindex="-1" role="dialog" aria-labelledby="repliesLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="/project-reply" method="post">
                        <input class="parent" type="hidden" name="parent" value="">
                        <input type="hidden" name="id" value="<c:out value="${project.id}"/>">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="repliesLabel">Ответить на проэкт</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Ответить</label>
                                <textarea name="reply" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Submit</button>
                            <input type="submit" class="btn btn-primary" value="Submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </sec:authorize>
</body>
</html>