<jsp:include page="header.jsp"></jsp:include>
    <script src="js/task.js"></script>
    <div class="container" style="margin-top: 5%">
        <h2>Insert Task</h2>
        <div class="row">
            <div class="col-lg-6">
                <form id="taskForm">
                <div class="form-group">
                    <input type="hidden" class="form-control" id="taskid" name="taskid">
                </div>
                <div class="form-group">
                    <label for="description">Enter Task Description</label>
                    <input type="text" class="form-control" id="description" placeholder="task description goes here" name="description">
                </div>
                <button type="submit" class="btn btn-default" id="btntaskSave">Insert</button>
            </form>
            </div>
        </div>
                <div class="row" style="margin-top: 5%">
                    <div class="col-lg-6">
                        Click a row to update
                        <table id="tasktable" class="table table-striped">
                            <thead>
                            <th>ID</th>
                            <th>Task Description</th>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
    </div>