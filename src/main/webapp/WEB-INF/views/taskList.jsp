<%@ include file = "common/taglibs_pagetags.jspf" %>
<!DOCTYPE html>
<html>
<%@ include file = "common/header.jspf" %>
<body>
	<%@ include file = "common/navigation.jspf" %>
	<div class="container">
		The Task with Title "${taskName}" has ${taskCount} tasks: <br />
		Details:<br />
		<table class="table table-striped ">
			<caption>Task Details for "${taskName}"</caption>
			<thead>
				<tr>
					<th>Task ID</th>
					<th>Task Name</th>
					<th>Task Description</th>
					<th>Target Date</th>
					<th>Complete?</th>
					<th>Delete Task</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="task">
					<tr>
						<td>${task.taskID}</td>
						<td>${task.taskName}</td>
						<td>${task.taskDesc}</td>
						<td><fmt:formatDate pattern ="MM/dd/yyyy hh:mm" value="${task.targetDate}"/></td>
						<td>${task.open}</td>
						<td>
						<a type="btn" class="btn btn-warning"
							href="/my-web/updateTaskAction?taskID=${task.taskID}&taskName=${task.taskName}">Update</a>
						<a type="btn" class="btn btn-danger"
							href="/my-web/deleteTaskAction?taskID=${task.taskID}&taskName=${task.taskName}">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div>
			<a class=" btn btn-success" href="/my-web/addTaskForm"> Add more
				Task </a>
		</div>
	</div>
		<%@ include file = "common/footer.jspf" %>
</body>
</html>