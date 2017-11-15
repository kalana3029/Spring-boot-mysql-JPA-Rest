var pickedup;
$(document).ready(function () {

    getTask();
    $("#taskForm").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();


        fire_ajax_submit();

    });

    $("#tasktable").on('click','tr',function(e){
        e.preventDefault();

        if (pickedup != null) {
            pickedup.css( "background-color", "#ffccff" );
        }
        var id = $(this).find("td").eq(0).html();
        var title = $(this).find("td").eq(1).html();
        $("#taskid").val(id);
        $("#description").val(title);
        $( this ).css( "background-color", "red" );

        pickedup = $( this );
    });

});

function fire_ajax_submit() {

    var search = {}
    search["taskid"] = $("#taskid").val();
    search["description"] = $("#description").val();

    $("#btntaskSave").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/add-task",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            console.log("SUCCESS : ", data);
            $("#btntaskSave").prop("disabled", false);
            alert(data.msg);
            location.reload();

        },
        error: function (e) {
            console.log("ERROR : ", e);
            $("#btntaskSave").prop("disabled", false);

        }
    });

}

function getTask() {

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/get-tasks",
        cache: false,
        timeout: 600000,
        success: function (data) {

            console.log("SUCCESS : ", data);
            $.each(data, function( index, value ) {
                var row = $("<tr><td>" + value.taskid + "</td><td>" + value.description + "</td></tr>");
                $("#tasktable").append(row);
            });

        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}
