<%@ page import="com.tsystems.js.services.StationService" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"  %>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form action="#" method="post">
    <input type="text" name="train_number" placeholder="Train number">
    <br>
    <div>
        <input list="stations" name="station" placeholder="Station">
        <datalist id="stations">
            <% for(String name : StationService.getStationsNames()){%>
            <option value="<%= name%>">
            <%}%>
        </datalist>
        <input type="time" name="train_number" placeholder="Arrival time">
        <br>
    </div>
    <div class="adds">
        <input type="button" onclick="addField()" id="add" value="+">
        <input type="button" onclick="removeField()" id="remove" value="-">
    </div>
    <input type="submit" value="Add">
</form>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
    function addField(){
        var node = $("<div><input list=\"stations\" name=\"station\" placeholder=\"Station\"><datalist id=\"stations\"><option value=\"Internet Explorer\"><option value=\"Firefox\"><option value=\"Chrome\"><option value=\"Opera\"><option value=\"Safari\"></datalist> <input type=\"time\" name=\"train_number\" placeholder=\"Arrival time\"><br></div>");
        $("#add").on("click", function(){
            $(".adds").before(node);
        });
    }

    function removeField(){
        $("#remove").on("click", function(){
            $(".adds").prev().remove();
        });
    }
</script>
</body>
</html>
