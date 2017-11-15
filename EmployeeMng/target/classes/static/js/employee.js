var pickedup;
var roleobj = {}
$(document).ready(function () {

    getRole();
    getEmployee();
    $("#employeeForm").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();


        fire_ajax_submit();

    });

    $("#employees-table").on('click','tr',function(e){
        e.preventDefault();

        if (pickedup != null) {
            pickedup.css( "background-color", "#ffccff" );
        }
        var id = $(this).find("td").eq(0).html();
        var name = $(this).find("td").eq(1).html();
        var role = $(this).find("td").eq(2).html();
        $("#employeeid").val(id);
        $("#name").val(name);
        $("#role").val(role);
        $( this ).css( "background-color", "red" );

        pickedup = $( this );
    });

});

function fire_ajax_submit() {

    var search = {}
    search["employeeid"] = $("#employeeid").val();
    search["name"] = $("#name").val();

    search["role"] = roleobj;

    console.log("search : ", search);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/add-employee",
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
            $("#btnEmployeeSave").prop("disabled", false);

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
                $('#role').append('<option value="'+value.roleid+'">'+value.title+'</option>');
            });

        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}

function getEmployee() {

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/get-employees",
        cache: false,
        timeout: 600000,
        success: function (data) {

            console.log("SUCCESS : ", data);
            console.log("SUCCESS : ", data);
            $.each(data, function( index, value ) {
                var row = $("<tr><td>" + value.employeeid + "</td><td>" + value.name + "</td><td hidden>" + value.role.roleid + "</td><td>" + value.role.title + "</td></tr>");
                $("#employees-table").append(row);
            });

        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}

function getRoleByid(roleid) {

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/role/"+roleid.value,
        cache: false,
        timeout: 600000,
        success: function (data) {

            roleobj = data;
            console.log("SUCCESS : ", roleobj);

        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}