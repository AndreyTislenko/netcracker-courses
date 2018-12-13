$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#polynomial_form").submit(function(event) {

		// Prevent the form from submitting via the browser.
		event.preventDefault();

		let a = $("#A").val();
		let b = $("#B").val();
		let c = $("#C").val();

		if(!inputIsCorrect(a, b, c)) return;

		ajaxPost(a , b, c);

        //refreshing history table if innerText of toggleHistoryButton is Close History.
		$("#my_history_table tbody").empty();
		ajaxGet();
	});


    function ajaxPost(a, b, c){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		a : Number(a),
    		b : Number(b),
			c : Number(c),
			countOfRoots : 0
    	};

    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
            url : window.location + "controller/rest/post",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status === "Done"){
					let count = (~result.data.countOfRoots) ? result.data.countOfRoots : Infinity;
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" +
												"---> Your coefficients: A = " + result.data.a +
                                                " ,B = " + result.data.b +
                                                " ,C = " + result.data.c + ".<br>" +
						                        "---> And the amount of roots: " + count + "</p>");
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!");
				console.log("ERROR: ", e);
			}
		});
    }

    function inputIsCorrect() {
    	for(let i = 0; i < arguments.length; i++) {
    		if(isNaN(parseFloat(arguments[i])) || !isFinite(arguments[i])) {
                $("#postResultDiv").html("<p style='background-color:red; color:white; padding:20px 20px 20px 20px'>" +
                    "Error! <br>" +
                    "---> " + arguments[i] + " is not a number! </p>");

                return false;
			}
		}

		return true;
	}
});