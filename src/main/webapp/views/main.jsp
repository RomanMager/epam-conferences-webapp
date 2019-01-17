<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Main Page | Conferences</title>
    <jsp:include page="common/header.jsp"/>
</head>
<body>
    <jsp:include page="common/navbar.jsp"/>

    <div class="container" align="center" style="margin-top: 100px">
        <div class="row">
            <c:forEach var="conf" items="${conferences}">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <i class="fas fa-ticket-alt card-img"></i>
                            <h5 class="card-title">${conf.title}</h5>
                            <h6 class="card-subtitle">Topic: ${conf.topic}</h6>
                            <p class="card-text">${conf.description}</p>
                            <c:if test="${role == 'participant'}">
                                <button class="btn btn-info">Register</button>
                            </c:if>
                            <c:if test="${role == 'admin'}">
                                <button class="btn btn-info">Edit</button>
                            </c:if>
                        </div>
                    </div>
                    <br/>
                </div>
            </c:forEach>
        </div>
    </div>

    <jsp:include page="common/footer.jsp"/>
</body>
</html>
