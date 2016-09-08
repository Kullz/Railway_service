<%--
  Created by IntelliJ IDEA.
  User: kull
  Date: 07.09.16
  Time: 19:39
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
<div class="container text-center">
    <div class="row content">
        <div class="col-sm-8 text-left well holder" style="background-color: #8888bb">
        </div>

        <div class="col-sm-4 sidenav well">
        </div>
    </div>
</div>
</body>
<script>

    function showSearchResult() {
        var $resultsHolder = $('.holder');
        $.ajax({
            url:"/show/search",
            cache:false,
            type: "GET",
            data: "json",
            success: function (list_trains) {
                $.each(list_trains.trains, function (i, train) {
                    $resultsHolder.append('<div class="well search-unit row"><form class="form-inline row"> <div class="form-group col-md-4"> <label class="sr-only">Train</label> <p class="form-control-static">Train:'+ train.trainNumber +'</p></div> <div class="form-group col-md-4"> <label class="sr-only">Price</label> <p class="form-control-static">Price:'+ 50 +'</p> </div> <button type="submit" class="btn btn-default col-md-4">Buy</button> </form> </div>');
                })

            }
        });
    }

    showSearchResult();

</script>
</html>