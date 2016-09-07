<%@ page contentType="text/html" pageEncoding="UTF-8"  %>
<%@ page import="com.tsystems.js.models.Passenger" %>
<%@ page import="com.tsystems.js.services.PassengerService" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Passenger</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/css/bootstrap.min.css" integrity="sha384-MIwDKRSSImVFAZCVLtU0LMDdON6KVCrZHyVQQj6e8wIEJkW4tvwqXrbMIya1vriY" crossorigin="anonymous">

</head>
<body>

<table class="table table-striped">
    <thead>
    <tr>
        <th>id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Date of birth</th>
    </tr>
    </thead>
    <tbody>
    <% for(Passenger passenger : PassengerService.getAllPassengers()){ %>
    <tr>
        <th scope="row"><%= passenger.getId() %></th>
        <td><%= passenger.getPassengerName()%></td>
        <td><%= passenger.getPassengerSurname()%></td>
        <td><%= passenger.getDateOfBirth()%></td>
    </tr>
    <%}%>
    </tbody>
</table>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/js/bootstrap.min.js" integrity="sha384-ux8v3A6CPtOTqOzMKiuo3d/DomGaaClxFYdCu2HPMBEkf6x2xiDyJ7gkXU0MWwaD" crossorigin="anonymous"></script>
</body>
</html>