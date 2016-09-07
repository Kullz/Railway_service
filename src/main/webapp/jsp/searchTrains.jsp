<%@ page import="com.tsystems.js.services.TrainService" %>
<%@ page import="com.tsystems.js.models.Train" %>
<%@ page import="com.tsystems.js.models.Station" %>
<%@ page import="com.tsystems.js.utils.Util" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kull
  Date: 28.08.16
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Train</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/css/bootstrap.min.css" integrity="sha384-MIwDKRSSImVFAZCVLtU0LMDdON6KVCrZHyVQQj6e8wIEJkW4tvwqXrbMIya1vriY" crossorigin="anonymous">

</head>
<body>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Train number</th>
        <th>Available seats</th>
    </tr>
    </thead>
    <tbody>
    <% for(Train train : TrainService.searchExactTrains(new Station(request.getParameter("stA")),
            new Station(request.getParameter("stB")),
            Util.getTime(request.getParameter("start")),
            Util.getTime(request.getParameter("finish")))){ %>
    <tr>
        <td><%= train.getTrainNumber()%></td>
        <td><%= train.getNumberOfSeats()%></td>
    </tr>
    <%}%>
    </tbody>
</table>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/js/bootstrap.min.js" integrity="sha384-ux8v3A6CPtOTqOzMKiuo3d/DomGaaClxFYdCu2HPMBEkf6x2xiDyJ7gkXU0MWwaD" crossorigin="anonymous"></script>
</body>
</html>
