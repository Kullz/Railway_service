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

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>



    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">




    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>





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

<section class="container-fluid text-center row content">
        <!--=============================
        ==			TABLE AREA         ==
        ==============================-->
        <div class="col-sm-8 text-left" id="table-holder">
            <iframe src="/show/alltrains" width="100%" height="100%"></iframe>
        </div>
        <!--=============================
        ==			FORMS AREA         ==
        ==============================-->

        <!--=============================
        ==			ADD TRAIN          ==
        ==============================-->
        <!--SIDE FORMS BAR START-->
        <div class="col-sm-4 sidenav">
            <!-- Add train Form Container START -->
            <div class="well">
                <!-- Add train form START -->
                <form action="/add/addtrain" method="get">

                    <!-- Single inputs for train number and max seats-->

                    <input type="text" data-validation="number"
                    name="train" placeholder="Train number"
                    data-validation-error-msg="wrong input for train number">

                    <input type="text" data-validation="number"
                    data-validation-allowing="range[1;3000]"
                    data-validation-error-msg="wrong input for number of seats"
                    name="seats" placeholder="Number of seats">

                    <br>

                    <!-- Time table inputs, include station and arrival time-->

                    <div id="additonals_train">

                        <input list="stations" onclick="showStationsList()"
                        data-validation="alphanumeric" data-validation-error-msg="wrong input for station"
                        data-validation-allowing="-_" name="station" placeholder="Station" >

                        <datalist id="stations" class="station">
                        </datalist>

                        <input type="time" data-validation="time"
                        data-validation-error-msg="wrong input for arrival time"
                        data-validation-help="HH:mm" name="time" placeholder="Arrival time">

                    </div>

                    <!-- Block is used to add additional inputs for stations and arr time -->
                    <div class="addsP">
                        <input type="button" id="add" value="+">
                        <input type="button" id="remove" value="-">
                    </div>

                    <input type="hidden" name="type" value="addtrain">
                    <input type="submit" value="Add">

                </form>

                <!-- Add train form END -->

                <!-- Script for addsP block-->
                <script>
                    var fieldsCounterTr = 1;

                    $("#add").click(function(){
                        fieldsCounterTr++;
                        var $node = $('#additonals_train').clone();
                        $(".addsP").before($node);
                    });

                    $("#remove").click(function(){
                        if (fieldsCounterTr != 1) {
                            $(".addsP").prev().remove();
                            fieldsCounterTr--;
                        }
                    });

                </script>
            <!-- Add train Form Container END -->
            </div>


            <!--=============================
            ==			ADD STATION        ==
            ==============================-->
            <!-- Add station container START-->
            <div class="well">
                <!-- Add station for START-->
                <form action="/add/addstation" method="get">

                    <!-- Input for station's name-->
                    <input type="text" data-validation="alphanumeric"
                    data-validation-error-msg="wrong input for station"
                    data-validation-allowings="_-" name="station" placeholder="Station">
                    <br>

                    <!-- Multiple input container, includes train's number and arrival time-->
                    <div id="additionals_station">
                        <input list="trains" onclick="showTrainsList()"
                        data-validation="number" data-validation-error-msg="wrong input for train number"
                        name="train" placeholder="Train number">

                        <datalist id="trains" class="train">
                        </datalist>

                        <input type="time" data-validation="time"
                        data-validation-error-msg="wrong input for arrival time"
                        data-validation-help="HH:mm" name="time" placeholder="Arrival time">

                    </div>

                    <!-- Additional inputs adding block-->
                    <div class="adds">
                        <input type="button" id="addP" value="+">
                        <input type="button" id="removeP" value="-">
                    </div>

                    <input type="hidden" name="type" value="addstation">
                    <input type="submit" value="Add">
                </form>

                <!-- Add additional field for number and time inputs above-->
                <script>
                    var fieldsCounterSt = 1;

                    $("#addP").click(function(){
                        var $node = $("#additionals_station").clone();
                        fieldsCounterSt++;
                        $(".adds").before($node);
                    });

                    $("#removeP").click(function(){

                        if (fieldsCounterSt != 1) {
                            $(".adds").prev().remove();
                            fieldsCounterSt--;
                        }
                    });

                </script>
            <!-- Add station container END-->
            </div>
        <!-- FORMS SIDE BAR END-->
        </div>
</section>

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

<script>
    $.validate({
        modules : 'date',
        validateOnBlur : false, // disable validation when input looses focus
        errorMessagePosition : 'top', // Instead of 'inline' which is default
        scrollToTopOnError : false // Set this property to true on longer forms
    });
</script>

<!-- POP-UP trains menu script-->
<script>
    function showTrainsList() {
        var $trains = $(".train");
        $.ajax({
            url:"/show/train_numbers",
            cache:false,
            type: "POST",
            data: "json",
            success: function (list_trains) {
                $trains.children().remove();
                $.each(list_trains.trains, function (i, train) {
                    $trains.append("<option value='"+ train+ "'>");
                })

            }
        });
    }
    
    function showStationsList() {
        var $stations = $(".station");
        $.ajax({
            url: "/show/station_names",
            cache: false,
            type: "POST",
            data: "json",
            success: function(list_stations){
                $stations.children().remove();
                $.each(list_stations.stations, function (i, station) {
                    $stations.append("<option value='" + station +"'>");
                })
            }
        });
    }
</script>

</body>
</html>
