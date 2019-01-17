<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top nav-conference">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <c:choose>
                    <c:when test="${empty login}">
                        <li class="nav-item active">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}controller?command=to_main_page">
                                <i class="fas fa-home" aria-hidden="true"></i> Home
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}controller?command=to_login_page">
                                <i class="fa fa-sign-in-alt" aria-hidden="true"></i> Sign In
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}controller?command=to_register_page">
                                <i class="fa fa-user-plus" aria-hidden="true"></i> Register
                            </a>
                        </li>
                    </c:when>

                    <c:otherwise>
                        <li class="nav-item active">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}controller?command=to_main_page">
                                <i class="fas fa-home" aria-hidden="true"></i> Home
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}controller?command=to_profile_page">
                                <i class="fa fa-user" aria-hidden="true"></i> Account
                            </a>
                        </li>

                        <c:if test="${role == 'admin'}">
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="${pageContext.request.contextPath}controller?command=create_conference">
                                    <i class="fa fa-calendar-plus" aria-hidden="true"></i> Create Conference
                                </a>
                            </li>
                        </c:if>

                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}controller?command=sign_out">
                                <i class="fa fa-sign-out-alt" aria-hidden="true"></i> Sign Out
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
