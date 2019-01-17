<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error Page</title>
    <jsp:include page="../common/header.jsp"/>

</head>
<body>
    <jsp:include page="../common/navbar.jsp"/>

    <div class="container" style="margin-top: 100px">
        Request from ${pageContext.errorData.requestURI} is failed
        <br/>
        Servlet name: ${pageContext.errorData.servletName}
        <br/>
        Status code: ${pageContext.errorData.statusCode}
        <br/>
        Exception: ${pageContext.exception}
        <br/>
        Message from exception: ${pageContext.exception.message}

        <form action="controller" method="get">
            <input type="hidden" name="command" value="to_main_page"/>
            <button type="submit" class="btn btn-danger">Go to the main page</button>
        </form>
    </div>

    <jsp:include page="../common/footer.jsp"/>
</body>
</html>
