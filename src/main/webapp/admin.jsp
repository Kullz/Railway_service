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
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">LOGO</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
                    <button type="button" id="trains-btn" class="btn btn-primary">
                        Trains
                    </button>

                    <button type="button" id="passengers-btn" class="btn btn-primary">
                        Passengers
                    </button>

                    <button type="button" id="stations-btn" class="btn btn-primary">
                        Stations
                    </button>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid text-center">
    <div class="row content">
        <!--=============================
        ==			TABLE AREA         ==
        ==============================-->
        <div class="col-sm-8 text-left" id="table-holder">
            <iframe src="/show/alltrains" width="100%" height="100%"></iframe>
        </div>
        <!--=============================
        ==			FORMS AREA         ==
        ==============================-->
        <div class="col-sm-4 sidenav">
            <div class="well">
                <form action="/add/addtrain" method="get">
                    <input type="text" name="train" placeholder="Train number">
                    <input type="text" name="seats" placeholder="Number of seats">
                    <br>
                    <div class="addition">
                        <input list="stations" name="station" placeholder="Station" >
                        <datalist id="stations">
                            <%--<% for(String name : StationService.getStationsNames()){%>--%>
                            <%--<option value="<%= name%>">--%>
                                    <%--<%}%>--%>
                        </datalist>
                        <input type="time" name="time" placeholder="Arrival time">
                    </div>
                    <div class="addsP">
                        <input type="button" id="add" value="+">
                        <input type="button" id="remove" value="-">
                    </div>
                    <input type="submit" value="Add">
                </form>
                <script type="text/javascript">

                    $("#add").click(function(){
                        var node = $("<div> <input list=\"stations\" name=\"station\" placeholder=\"Station\" > <input type=\"time\" name=\"time\" placeholder=\"Arrival time\"> </div>");
                        $(".addsP").before(node);
                    });

                    $("#remove").click(function(){
                        if ($(".addsP").prev() != $(".addition")) {
                            $(".addsP").prev().remove();
                        }
                    });

                </script>
            </div>

            <div class="well">
                <form action="/add/addstation" method="get">
                    <input type="text" name="station" placeholder="Station">
                    <br>
                    <div class="addition">
                        <input list="stations" name="train" placeholder="Train number" >
                        <datalist id="train">
                            <%--<% for(String name : StationService.getStationsNames()){%>--%>
                            <%--<option value="<%= name%>">--%>
                            <%--<%}%>--%>
                        </datalist>
                        <input type="time" name="time" placeholder="Arrival time">
                    </div>
                    <div class="adds">
                        <input type="button" id="addP" value="+">
                        <input type="button" id="removeP" value="-">
                    </div>
                    <input type="submit" value="Add">
                </form>
                <script type="text/javascript">

                    $("#addP").click(function(){
                        var node = $("<div> <input list=\"trains\" name=\"train\" placeholder=\"Station\" > <input type=\"time\" name=\"time\" placeholder=\"Arrival time\"> </div>");
                        $(".adds").before(node);
                    });

                    $("#removeP").click(function(){
                        if ($(".adds").prev() != $(".addition")) {
                            $(".adds").prev().remove();
                        }
                    });

                </script>
            </div>
        </div>
    </div>
</div>
<script>
    $("#passengers-btn").click(function(){
        $("#table-holder").children("iframe").remove();
        var pNode = $('<iframe src="/show/allpassengers" width="100%" height="100%"></iframe>');
        $("#table-holder").prepend(pNode);
    });

    $("#trains-btn").click(function(){
        $("#table-holder").children("iframe").remove();
        var pNode = $('<iframe src="/show/alltrains" width="100%" height="100%"></iframe>');
        $("#table-holder").prepend(pNode);
    });

    $("#stations-btn").click(function(){
        $("#table-holder").children("iframe").remove();
        var pNode = $('<iframe src="/show/allstations" width="100%" height="100%"></iframe>');
        $("#table-holder").prepend(pNode);
    });
</script>
</body>
</html>
