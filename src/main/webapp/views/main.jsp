<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Main Page | Conferences</title>
    <jsp:include page="common/header.jsp"/>
</head>
<body>
    <jsp:include page="common/navbar.jsp"/>
    <div class="jumbotron jumbotron-fluid">
        <div class="container" align="center">
            <h1>
                Main Content!!!
            </h1>
            <div class="auth">
                <h2>Register</h2>
                <h2>
                    <a href="controller?command=to_login_page">
                        Log In
                    </a>
                </h2>
                <h2>Log Out</h2>
            </div>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
