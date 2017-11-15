<jsp:include page="header.jsp"></jsp:include>
    <script src="js/employee.js"></script>
        <div class="container" style="margin-top: 5%">
            <h2>Insert Employee</h2>
            <div class="row">
                <div class="col-lg-6">
                    <form id="employeeForm">
                    <div class="form-group">
                        <input type="hidden" class="form-control" id="employeeid" name="employeeid">
                    </div>
                    <div class="form-group">
                        <label for="name">Enter Employee name</label>
                        <input type="text" class="form-control" id="name" placeholder="Employee name goes here" name="name">
                    </div>
                    <div class="form-group">
                        <label for="role">Employee Role</label>
                        <fieldset>
                            <select name="role" id="role" onchange="getRoleByid(this)" class="form-control">
                                <option value="0" disabled selected>-Select Role-</option>
                            </select></fieldset>
                    </div>
                    <button type="submit" class="btn btn-default" id="btnEmployeeSave">Insert</button>
                </form>
                </div>
            </div>
            <div class="row" style="margin-top: 5%">
                <div class="col-lg-6">
                    Click a row to update
                    <table id="employees-table" class="table table-striped">
                        <thead>
                        <th>ID</th>
                        <th>Employee Name</th>
                        <th>Employee Role</th>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>