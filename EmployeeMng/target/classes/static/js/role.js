var pickedup;
$(document).ready(function () {

    getRole();
    $("#roleForm").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();


        fire_ajax_submit();

    });

    $("#roletable").on('click','tr',function(e){
        e.preventDefault();

        if (pickedup != null) {
            pickedup.css( "background-color", "#ffccff" );
        }
        var id = $(this).find("td").eq(0).html();
        var title = $(this).find("td").eq(1).html();
        $("#roleid").val(id);
        $("#title").val(title);
        $( this ).css( "background-color", "red" );

        pickedup = $( this );
    });

});

function fire_ajax_submit() {

    var search = {}
    search["roleid"] = $("#roleid").val();
    search["title"] = $("#title").val();

    $("#btnRoleSave").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/add-role",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            console.log("SUCCESS : ", data);
            $("#btnRoleSave").prop("disabled", false);
            alert(data.msg);
            location.reload();

        },
        error: function (e) {

            // var json = "<h4>Ajax Response</h4><pre>"
            //     + e.responseText + "</pre>";
            // $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btnRoleSave").prop("disabled", false);

        }
    });

}

function getRole() {

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/get-roles",
        cache: false,
        timeout: 600000,
        success: function (data) {

            console.log("SUCCESS : ", data);
            $.each(data, function( index, value ) {
                var row = $("<tr><td>" + value.roleid + "</td><td>" + value.title + "</td></tr>");
                $("#roletable").append(row);
            });

        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}
