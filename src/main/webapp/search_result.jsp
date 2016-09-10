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

<div class="modal fade" id="buyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" method="post" action="/but_ticket">
                    <div class="form-group">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    </div>
                    <div class="form-group">
                        <label for="inputName" class="col-sm-4 control-label">Name:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputName" name="name" placeholder="Enter your name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputSurname" class="col-sm-4 control-label">Surname:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputSurname" name="surname" placeholder="Enter your surname">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="birth" class="col-sm-4 control-label">Date of Birth:</label>
                        <div class="col-sm-8">
                            <input type="date" class="form-control" id="birth" name="birth_date" placeholder="Enter date of birth">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-8 col-sm-4">
                            <button type="submit" class="btn btn-primary">Buy</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-8 col-sm-4">
                            <input type="hidden" id="number-holder" name="trainNumber"/>
                        </div>
                    </div>
                </form>
            </div>
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
                    $resultsHolder.append('<div class="well search-unit row"><form class="form-inline row"> <div class="form-group col-md-4"> <label class="sr-only">Train</label> <p class="form-control-static">Train:'+ train.trainNumber +'</p></div> <div class="form-group col-md-4"> <label class="sr-only">Price</label> <p class="form-control-static">Price:'+ 50 +'</p> </div> <input type="hidden" name="trainNumber" value="'+ train.trainNumber +'"><button type="button" class="btn btn-default col-md-4 modal_button" data-toggle="modal" data-target="#buyModal" data-number_train="'+ train.trainNumber+'">Buy</button> </form> </div>');
                })

            }
        });
    }

    showSearchResult();

    $(document).on("click", ".modal_button", function () {
        var trainNumber = $(this).data('number_train');
        $(".modal-body #number-holder").val( trainNumber );
    });

</script>
</html>