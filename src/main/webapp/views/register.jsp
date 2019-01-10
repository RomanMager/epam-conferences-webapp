<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <jsp:include page="common/header.jsp"/>
</head>
<body>
    <jsp:include page="common/navbar.jsp"/>

    <div class="container">
        <form action="controller" method="post" class="register-form">
            <input type="hidden" name="command" value="register"/>

            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h2>Register</h2>
                    <hr>
                </div>
            </div>

            <div class="form-group row">
                <label for="nameInput" class="col-sm-2 col-form-label">Name*</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="nameInput" placeholder="John" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="surnameInput" class="col-sm-2 col-form-label">Surname*</label>
                <div class="col-sm-10">
                    <input type="text" name="surname" class="form-control" id="surnameInput" placeholder="Smith"
                           required>
                </div>
            </div>

            <div class="form-group row">
                <label for="emailInput" class="col-sm-2 col-form-label">Email*</label>
                <div class="col-sm-10">
                    <input type="email" name="email" class="form-control" id="emailInput" placeholder="you@example.com"
                           required>
                </div>
            </div>

            <div class="form-group row">
                <label for="loginInput" class="col-sm-2 col-form-label">Login*</label>
                <div class="col-sm-10">
                    <input type="text" name="login" class="form-control" id="loginInput" placeholder="login" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="passwordInput" class="col-sm-2 col-form-label">Password*</label>
                <div class="col-sm-10">
                    <input type="password" name="password" class="form-control" id="passwordInput"
                           placeholder="Password" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="passwordRepeat" class="col-sm-2 col-form-label">Repeat Password</label>
                <div class="col-sm-10">
                    <input type="password" name="password" class="form-control" id="passwordRepeat"
                           placeholder="Repeat your password" required>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i> Register
                    </button>
                </div>
            </div>

        </form>
    </div>

    <jsp:include page="common/footer.jsp"/>
</body>
</html>
