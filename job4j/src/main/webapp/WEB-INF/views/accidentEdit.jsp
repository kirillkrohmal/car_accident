<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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
    <title>Edit accident</title>
</head>

<body>

<spring:form method="POST" action='<%=(request.getContextPath()) + "/add-accident"%>' modelAttribute="accident">
    <div class="input-group mb-3" style="margin-top: 20px">
        <spring:input type="text" class="form-control" path="name" placeholder="Name" cssStyle="margin: 10px"/>
        <spring:input type="text" class="form-control" path="text" placeholder="Text" cssStyle="margin: 10px"/>
        <spring:input type="text" class="form-control" path="address" placeholder="Address" cssStyle="margin: 10px"/>
        <button type="submit" class="btn btn-outline-primary" style="margin: 10px">Add</button>
    </div>
</spring:form>

</body>
</html>