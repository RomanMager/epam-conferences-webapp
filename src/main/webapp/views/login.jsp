<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sign In</title>
    <jsp:include page="common/header.jsp"/>
</head>
<body>
    <jsp:include page="common/navbar.jsp"/>

    <div class="container">
        <form action="controller" method="post" class="sign-in-form">
            <input type="hidden" name="command" value="sign_in"/>

            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h2>Sign In</h2>
                    <hr>
                </div>
            </div>

            <div class="form-group row">
                <label for="login" class="col-sm-2 col-form-label">Login:</label>
                <div class="col-sm-10">
                    <input type="text" name="login" class="form-control" placeholder="Enter login" id="login" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="password" class="col-sm-2 col-form-label">Password:</label>
                <div class="col-sm-10">
                    <input type="password" name="password" class="form-control" placeholder="Enter password"
                           id="password" required>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <button type="submit" class="btn btn-success">Sign In</button>
                </div>
            </div>

        </form>
    </div>

    <jsp:include page="common/footer.jsp"/>
</body>
</html>
