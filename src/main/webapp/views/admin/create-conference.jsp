<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Conference</title>
    <jsp:include page="../common/header.jsp"/>
</head>
<body>
    <style>
        .create-conference-form {
            margin-top: 100px;
        }
    </style>
    <jsp:include page="../common/navbar.jsp"/>

    <div class="container">
        <form action="controller" method="post" class="create-conference-form">
            <input type="hidden" name="command" value="create_conference"/>

            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h2>Create Conference</h2>
                    <hr/>
                </div>
            </div>

            <div class="form-group row">
                <label for="conferenceTitle" class="col-sm-2 col-form-label">Conference Title*</label>
                <div class="col-sm-10">
                    <input type="text" name="title" class="form-control" id="conferenceTitle"
                           placeholder="Conf Name" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="conferenceTopic" class="col-sm-2 col-form-label">Conference Topic*</label>
                <div class="col-sm-10">
                    <input type="text" name="topic" class="form-control" id="conferenceTopic"
                           placeholder="Conf Topic" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="conferenceDescription" class="col-sm-2 col-form-label">Conference Description*</label>
                <%--<div class="col-sm-10">--%>
                <%--<input type="text" name="description" class="form-control" id="conferenceDescription"--%>
                <%--placeholder="Conf Description" required>--%>
                <%--</div>--%>
                <div class="col-sm-10">
                <textarea class="form-control" name="description" id="conferenceDescription"
                          placeholder="Conf Description" required>
                </textarea>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i> Create Conference
                    </button>
                </div>
            </div>

        </form>
    </div>

    </div>
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>
