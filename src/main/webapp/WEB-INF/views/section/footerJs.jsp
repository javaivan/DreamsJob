<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- jQuery -->
<spring:url value="/resources/bower_components/jquery/dist/jquery.min.js" var="jqueryMinJs" />
<script src="${jqueryMinJs}"></script>

<!-- Bootstrap Core JavaScript -->
<spring:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js" var="bootstrapMinJs" />
<script src="${bootstrapMinJs}"></script>

<!-- Metis Menu Plugin JavaScript -->
<spring:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.js" var="metisMenuJs" />
<script src="${metisMenuJs}"></script>

<!-- Morris Charts JavaScript -->

<%--<spring:url value="/resources/bower_components/raphael/raphael-min.js" var="raphaelMinJs" />
<script src="${raphaelMinJs}"></script>

<spring:url value="/resources/bower_components/morrisjs/morris.min.js" var="morrisMinJs" />
<script src="${morrisMinJs}"></script>
--%>
<spring:url value="/resources/js/main.js" var="mainJs" />
<script src="${mainJs}"></script>

<!-- Custom Theme JavaScript -->
<spring:url value="/resources/dist/js/sb-admin-2.js" var="sbAdminJs" />
<script src="${sbAdminJs}"></script>
