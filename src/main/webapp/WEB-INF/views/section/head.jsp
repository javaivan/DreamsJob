<%@include file="/WEB-INF/views/section/taglib.jsp" %>

<!-- Bootstrap Core CSS -->
<spring:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />

<!-- MetisMenu CSS -->
<spring:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.css" var="metisMenuCss" />
<link href="${metisMenuCss}" rel="stylesheet" />

<!-- Timeline CSS -->
<spring:url value="/resources/dist/css/timeline.css" var="timelineCss" />
<link href="${timelineCss}" rel="stylesheet" />

<!-- Custom CSS -->
<spring:url value="/resources/dist/css/sb-admin-2.css" var="sbAdminCss" />
<link href="${sbAdminCss}" rel="stylesheet" />

<!-- Morris Charts CSS -->
<spring:url value="/resources/bower_components/morrisjs/morris.css" var="morrisCss" />
<link href="${morrisCss}" rel="stylesheet" />

<!-- Custom Fonts -->
<spring:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css" var="fontAwesomeCss" />
<link href="${fontAwesomeCss}" rel="stylesheet" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->