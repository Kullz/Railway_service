<%@ page import="com.tsystems.js.services.StationService" %><%--
  Created by IntelliJ IDEA.
  User: kull
  Date: 31.08.16
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
                </ul>
        </div>
    </nav>
    <div>
        <form action="/show/search" method="get" class="form-inline text-center">
            <div class="form-group">
                <label for="stA">From:</label>
                <input type="text" class="form-control" name="stA" id="stA">
            </div>
            <div class="form-group">
                <label for="stB">To:</label>
                <input type="text" class="form-control" name="stB" id="stB">
            </div>
            <br>
            <div class="form-group" style="padding-left: 40px">
                <input type="time" class="form-control" name="start" id="start">
            </div>
            <div class="form-group">
                <label for="finish">-</label>
                <input type="time" class="form-control" name="finish" id="finish">
            </div>
            <br>
            <button type="submit" class="btn btn-default">Search</button>
        </form>
    </div>

</div>


</body>
</html>
