<jsp:include page="header.jsp"></jsp:include>
    <script type="text/javascript" src="js/role.js"></script>
            <div class="container" style="margin-top: 5%">
    <h2>Insert Role</h2>
    <div class="row">
        <div class="col-lg-6">
            <form id="roleForm">
                <div class="form-group">
                    <input type="hidden" class="form-control" id="roleid" name="roleid">
                </div>
                <div class="form-group">
                    <label for="title">Enter Role Title</label>
                    <input type="text" class="form-control" id="title" placeholder="role title goes here" name="title">
                </div>
                <button type="submit" class="btn btn-default" id="btnRoleSave">Insert</button>
            </form>
        </div>
    </div>
    <div class="row" style="margin-top: 5%">
        <div class="col-lg-6">
            Click a row to update
            <table id="roletable" class="table table-striped">
                <thead>
                    <th>ID</th>
                    <th>Role Title</th>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>