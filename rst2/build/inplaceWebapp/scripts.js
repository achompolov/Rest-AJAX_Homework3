var defaultPagination = {
    totalPages: 1,
    visiblePages: 5,
    startPage: 1,
    onPageClick: function (event, page) {
        var filter = getFilter();
        filter.page = page - 1;
        getData(filter);
    }
};

var sentRequest = false;

function getFilter() {
    var filter = {
        page: 0,
        perPage: 10,
        withBrand: $("#brandFilter").val()
    };
    return filter;
}

function getData(filter) {
    if(sentRequest) return;
    sentRequest = true;
    $.get({
        url: "http://localhost:8080/rst2/api/motorcycles",
        dataType: "json",
        data: filter,
        success: function(data){
            $("#motorcyclesTableBody tr").remove();
            console.log(data.distinctBrands);

            $("#brandFilter").autocomplete({
                source: data.distinctBrands
            });

            if($('#paginationList').data("twbs-pagination")){
                    $('#paginationList').twbsPagination('destroy');
            }
            $('#paginationList').twbsPagination($.extend({}, defaultPagination, {
                startPage: data.page + 1,
                totalPages: data.totalPages
            }));

            $.each(data.data, function(index){
                var tr = $('<tr>');
                tr.append("<td> " + data.data[index].brand + "</td>");
                tr.append("<td> " + data.data[index].model + "</td>");
                tr.append("<td> " + data.data[index].maxSpeed + "</td>");
                tr.append("<td> " + data.data[index].horsePowers + "</td>");
                tr.append("<td> " + data.data[index].creationYear + "</td>");
                $("#motorcyclesTableBody").append(tr);
            });

            sentRequest = false;
        }

    });
}

$(document).ready(function() {
    getData(getFilter());

    $("#paginationList").twbsPagination(defaultPagination);
    $("#filterButton").click(function (e){
        getData(getFilter());
    });
});