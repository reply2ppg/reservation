$(document).ready(function () {

    if( $("#moive-name").val() == '' &&
        $("#theater-name").val() == '' &&
        $("#city-name").val() == '') {
        $("#search-button").prop("disabled", true);
    } else {
        $("#search-button").prop("disabled", false);
    }

    $("input[id$='-name']").on("keyup", function() {
        $("#search-button").prop("disabled", false);
    });

    $("#search-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var moviepriceurl = "http://localhost:9090/movieprices";
    let movie = $("#moive-name").val();
    let theater = $("#theater-name").val();
    let city = $("#city-name").val();

    $("#search-button").prop("disabled", true);
    $.ajax({

        type: "GET",
        contentType: "application/json",
        url: moviepriceurl,
        data: {
            "movie" : movie,
            "theater" : theater,
            "city" : city
        },
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
                $('#movie-details').html(json);

            console.log("SUCCESS : ", data);
            $("#search-button").prop("disabled", false);

        },
        error: function (e) {
            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#movie-details').html(json);

            console.log("ERROR : ", e);
            $("#search-button").prop("disabled", false);
        }
    });

}