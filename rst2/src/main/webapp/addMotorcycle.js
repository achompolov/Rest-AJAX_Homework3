function addMotorcycle() {
    var motorcycle = {
    	brand: $("#brand").val(),
        model: $("#model").val(),
        maxSpeed: $("#maxSpeed").val(),
        horsePowers: $("#horsePowers").val(),
        creationYear: $("#creationYear").val()
    }


    $.post({
        url: "http://localhost:8080/rst2/api/motorcycles",
        dataType: "json",
        data: JSON.stringify(motorcycle),
        contentType: "application/json",
        success: function(data) {
        	location.href = "index.html";
        }
    });
}