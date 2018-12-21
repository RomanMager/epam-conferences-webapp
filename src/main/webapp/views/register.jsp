<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <jsp:include page="common/header.jsp"/>
</head>
<body>
    <jsp:include page="common/navbar.jsp"/>

    <div class="container">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="register"/>

        </form>
    </div>

    <jsp:include page="common/footer.jsp"/>
</body>
</html>
