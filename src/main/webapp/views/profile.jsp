<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profile</title>
    <jsp:include page="common/header.jsp"/>
</head>
<body>
<jsp:include page="common/navbar.jsp"/>

<div class="container" style="margin-top: 100px">
    <%--<div class="row col-sm-3">--%>
    <div>Id Session: ${pageContext.session.id}</div>
    <%--<p>${pageContext.session.getAttribute("participantInfo")}</p>--%>
    <div>${participantInfo.login}</div>
    <div>${participantInfo.email}</div>
    <div>${participantInfo.role.roleName}</div>
    <div>${participantData.name}</div>
    <div>${participantData.surname}</div>
    <%--</div>--%>
</div>

<jsp:include page="common/footer.jsp"/>
</body>
</html>
