$( document ).ready(function() {

	// GET REQUEST
	$("#toggleHistoryId").click(function(event){
		event.preventDefault();
		let table = $("#historyTableContainer");
        table.empty();

        createHistoryFor(table);
		if(this.innerText === "Show History") {
            this.innerText = "Close History";

		    ajaxGet();

		    createClearHistoryButton();

            //GET CLEAR REQUEST
            $("#clearHistoryId").click(function (event) {
                event.preventDefault();
                clearHistory();
                $("#my_history_table tbody").empty();
            });
        }
		else if(this.innerText === "Close History") {
            this.innerText = "Show History";
            $("#clearHistoryId").remove();
		    table.empty();
        }
	});
});

// DO GET
function ajaxGet(){
    $.ajax({
        type : "GET",
        url : window.location + "controller/rest/get",
        success: function(result){
            if(result.status === "Done"){
                $.each(result.data, (key, value) => {
                    let polynomial = value;
                    let a = polynomial.a;
                    let b = polynomial.b;
                    let c = polynomial.c;
                    let count = (~polynomial.countOfRoots) ? polynomial.countOfRoots : Infinity;

                    $("#my_history_table tbody").append(
                        "<tr><td>"+key+"</td><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+count+"</td></tr>"
                    );
                });
                console.log("Success: ", result.data);
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

//DO CLEAR
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

function createHistoryFor(table, string = "") {
	table.append(
		"<table id=\"my_history_table\">\n" +
        "        <thead>\n" +
        "        <tr><th>index</th><th>A</th><th>B</th><th>C</th><th>count of roots</th></tr>\n" +
        "        </thead>\n" +
        "        <tbody>"+string+"</tbody>\n" +
        "</table>")
}

function createClearHistoryButton() {
    $("#buttons").append(
        "<button id=\"clearHistoryId\" type=\"button\" class=\"btn btn-primary\">Clear History</button>"
    );
}