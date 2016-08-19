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
    <!-- /.navbar-header -->
    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-messages">
                <li>
                    <a href="#">
                        <div>
                            <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                        </div>
                        <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>Read All Messages</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
            <!-- /.dropdown-messages -->
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-tasks">
                <li>
                    <a href="#">
                        <div>
                            <p>
                                <strong>Task 1</strong>
                                <span class="pull-right text-muted">40% Complete</span>
                            </p>
                            <div class="progress progress-striped active">
                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                    <span class="sr-only">40% Complete (success)</span>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>See All Tasks</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
            <!-- /.dropdown-tasks -->
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-comment fa-fw"></i> New Comment
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>See All Alerts</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
            <!-- /.dropdown-alerts -->
        </li>
        <!-- /.dropdown -->
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
                    <li><a href="<c:out value="${rootURL}"/>project-answer"><i class="fa fa-money"></i>Project Answer</a></li>
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
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                    </div>
                    <!-- /input-group -->
                </li>
                <li>
                    <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="flot.html">Flot Charts</a>
                        </li>
                        <li>
                            <a href="morris.html">Morris.js Charts</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="tables.html"><i class="fa fa-table fa-fw"></i> Tables</a>
                </li>
                <li>
                    <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="panels-wells.html">Panels and Wells</a>
                        </li>
                        <li>
                            <a href="buttons.html">Buttons</a>
                        </li>
                        <li>
                            <a href="notifications.html">Notifications</a>
                        </li>
                        <li>
                            <a href="typography.html">Typography</a>
                        </li>
                        <li>
                            <a href="icons.html"> Icons</a>
                        </li>
                        <li>
                            <a href="grid.html">Grid</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#">Second Level Item</a>
                        </li>
                        <li>
                            <a href="#">Second Level Item</a>
                        </li>
                        <li>
                            <a href="#">Third Level <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                            </ul>
                            <!-- /.nav-third-level -->
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="blank.html">Blank Page</a>
                        </li>
                        <li>
                            <a href="login.html">Login Page</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>