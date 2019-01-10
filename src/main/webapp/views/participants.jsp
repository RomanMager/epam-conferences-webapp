<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello, fellow participants!</h1>
    <%-- TODO: Is that a good practice? --%>
    <jsp:useBean id="participants" scope="request" type="java.util.List"/>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>LOGIN</th>
            <th>EMAIL</th>
            <th>PASSWORD</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="element" items="${participants}">
            <tr>
                <td>${element.personId}</td>
                <td>${element.login}</td>
                <td>${element.email}</td>
                <td>${element.password}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
