<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Car Accidents</title>
</head>

<body>

<div class="container">
    <h2 style="margin-top: 20px">Car Accidents</h2>
    <div style="margin: 20px">
        Login as : ${user.username}
    </div>
    <table class="table table-striped">
        <tr>
            <th><b>Id</b></th>
            <th><b>Name</b></th>
            <th><b>Text</b></th>
            <th><b>Address</b></th>
        </tr>
        <c:forEach items="${accidents}" var="accident">
            <tr>
                <td>${accident.id}</td>
                <td>${accident.name}</td>
                <td>${accident.text}</td>
                <td>${accident.address}</td>
            </tr>
        </c:forEach>
    </table>
    <button type="button" class="btn btn-outline-primary" onclick="location.href = '<%=request.getContextPath()%>/add-accident'" style="margin: 10px">Add</button>
    <button type="button" class="btn btn-outline-primary" onclick="location.href = '<%=request.getContextPath()%>/logout'" style="margin: 10px">Logout</button>
</div>

</body>
</html>