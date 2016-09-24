<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${rootURL}">Dreams Job</a>
    </div>
    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-money"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu">
                <li><a href="<c:out value="${rootURL}"/>project-all"><i class="fa fa-money"></i> All Project</a></li>
                <li class="divider"></li>
                <sec:authorize access="hasRole('ROLE_EMPLOYER')">
                    <li><a href="<c:out value="${rootURL}"/>project-new"><i class="fa fa-money"></i>Project Add</a></li>
                    <li><a href="<c:out value="${rootURL}"/>project-my"><i class="fa fa-money"></i>Project My</a></li>
                    <li><a href="<c:out value="${rootURL}"/>replies-to-me"><i class="fa fa-money"></i>To Me</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_FREELANCER')">
                    <li><a href="<c:out value="${rootURL}"/>replies-my"><i class="fa fa-money"></i>My Replies</a></li>
                </sec:authorize>
            </ul>
        </li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <sec:authorize access="not isAnonymous()">
                    <li><a href="<c:url value="${rootURL}"/>user-profile"><i class="fa fa-user fa-fw"></i>User Profile</a></li>
                    <li><a href="<c:url value="${rootURL}"/>user-profile-change-password"><i class="fa fa-key fa-fw"></i>Change Password</a></li>
                    <li class="divider"></li>
                    <li><a href="<c:url value="${rootURL}"/>logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <li><a href="<c:url value="${rootURL}"/>login"><i class="fa fa-user fa-fw"></i>Login</a></li>
                    <li class="divider"></li>
                    <li><a href="<c:url value="${rootURL}"/>registration"><i class="fa fa-user fa-fw"></i> Registration</a></li>
                </sec:authorize>
            </ul>
        </li>
    </ul>

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li><a href="<c:url value="${rootURL}"/>project-all"><i class="fa fa-money"></i> All Project</a></li>
                <sec:authorize access="isAnonymous()">
                    <li>
                        <a href="<c:url value="${rootURL}"/>login"><i class="fa fa-user fa-fw"></i> Login</a>
                    </li>
                    <li>
                        <a href="<c:url value="${rootURL}"/>registration"><i class="fa fa-user fa-fw"></i> Registration</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="not isAnonymous()">
                    <li>
                        <a href="<c:url value="${rootURL}"/>users"><i class="fa fa-user fa-fw"></i> All user</a>
                        <a href="<c:url value="${rootURL}"/>project-new"><i class="fa fa-money"></i> New Project</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>