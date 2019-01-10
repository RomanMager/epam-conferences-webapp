<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top nav-conference">
    <div class="container">
        <%--TODO: on click should redirect to the MAIN page--%>
        <a class="navbar-brand mb-0 h1" id="brand">
            <i class="fa fa-leaf"></i>
            <%--<i class="fa fa-leaf"></i>--%>
            Conferences
        </a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link">
                        <i class="fas fa-home" aria-hidden="true"></i> Home
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link">
                        <%-- TODO: Redirect to profile page --%>
                        <i class="fa fa-user" aria-hidden="true"></i> Account
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="controller?command=sign_out">
                        <i class="fa fa-sign-out-alt" aria-hidden="true"></i> Sign Out
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="controller?command=to_login_page">
                        <i class="fa fa-sign-in-alt" aria-hidden="true"></i> Sign In
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="controller?command=to_register_page">
                        <i class="fa fa-user-plus" aria-hidden="true"></i> Register
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
