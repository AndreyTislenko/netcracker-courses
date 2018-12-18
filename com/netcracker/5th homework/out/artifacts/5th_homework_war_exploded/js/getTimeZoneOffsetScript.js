//jQuery.get( url [, data ] [, success ] [, dataType ] )
$(document).ready(function() {
    $.ajax({
        type:"POST",
        url:"time",
        data:JSON.stringify({timezoneAttribute:new Date()}),
        dataType:"html",
        success:function (response) {
            $("html").html(response);
            console.log(response);
        },
        error:function (e) {
            alert("Error!");
            console.log("Error: ",e);
        }
    });
});