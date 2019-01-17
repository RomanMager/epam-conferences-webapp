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
        <div class="row">
            <div class="card" style="width: 18rem;">
                <img src="https://img.icons8.com/ios/1600/user-male-circle-filled.png" alt="" class="card-img-top">
                <div class="card-body">
                    <h5>${participantData.name} ${participantData.surname}</h5>
                    <p class="card-text">${participantInfo.login}</p>
                    <p class="card-text">${participantInfo.email}</p>

                    <button class="btn btn-info">Edit Info</button>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="common/footer.jsp"/>
</body>
</html>
