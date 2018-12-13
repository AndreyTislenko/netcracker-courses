$(document).ready(function () {
    $("#clearHistoryId").click(function (event) {
        event.preventDefault();
        clearHistory();
        $("#my_history_table tbody").empty();
    });
});

function clearHistory() {
    $.ajax({
        type : "GET",
        url : window.location + "controller/rest/clear",
        success : function (result) {
            if(result.status = "Done") {
                console.log("Success! polynomialHistory now is ", result.data);
            }else{
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("Fail: ", result);
            }
        },
        error : function(e) {
            $("#getResultDiv").html("<strong>Error</strong>");
            console.log("ERROR: ", e);
        }
    });
}