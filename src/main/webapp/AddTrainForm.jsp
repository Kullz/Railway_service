<%@ page import="com.tsystems.js.services.StationService" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"  %>

<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<form action="/add/addtrain" method="get">
    <input type="text" name="train" placeholder="Train number">
    <br>
    <div class="addition">
        <input list="stations" name="station" placeholder="Station" >
        <datalist id="stations">
            <% for(String name : StationService.getStationsNames()){%>
            <option value="<%= name%>">
            <%}%>
        </datalist>
        <input type="time" name="time" placeholder="Arrival time">
        <br>
    </div>
    <div class="adds">
        <input type="button" id="add" value="+">
        <input type="button" id="remove" value="-">
    </div>
    <input type="submit" value="Add">
</form>
<script type="text/javascript">
    var node = $('<div> <input list="stations" name="station" placeholder="Station" > <datalist id="stations"><% for(String name : StationService.getStationsNames()){%> <option value="<%= name%>"><%}%> </datalist> <input type="time" name="train_number" placeholder="Arrival time"> <br></div>');
    $("#add").click(function(){
        $(".adds").before(node);
    });

    $("#remove").click(function(){
        $(".adds").prev().remove();
    });

</script>
</body>
</html>
