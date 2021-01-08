<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
    <title>Login</title>
</head>
<body>
<c:if test="${not empty errorMessage}">
    <div style="color:red; font-weight: bold; margin: 30px 0;">
            ${errorMessage}
    </div>
</c:if>
<div class="container">
    <h2>Login</h2>
    <form name='login' action='<%=request.getContextPath()%>/login' method='POST'>
        <div class="row" style="margin-top: 10px">
            <div class="col-1">
                <label for='name'>UserName:</label>
            </div>
            <div class="col-10">
                <input id='name' type='text' name='username'>
            </div>
        </div>
        <div class="row" style="margin-top: 10px">
            <div class="col-1">
                <label for='password'>Password:</label>
            </div>
            <div class="col-10">
                <input id='password' type='password' name='password'/>
            </div>
        </div>
        <div  class="row">
            <input type="submit" class="btn btn-outline-primary" name="submit" value="Sign in" style="margin: 10px"/>
            <button type="button" class="btn btn-outline-primary" onclick="location.href = '<%=request.getContextPath()%>/reg'" style="margin: 10px">Sign up</button>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>