<%@ include file = "common/taglibs_pagetags.jspf" %>
<!DOCTYPE html>
<html>
<%@ include file = "common/header.jspf" %>
<body>
	<%@ include file = "common/navigation.jspf" %>
	<div class="container">
		<h1>Add New Task</h1>
		<form:form action="/my-web/addTaskAction" method="Post"
			commandName="taskVO">
			<form:hidden path="taskID" />
			<form:hidden path="open" />
			<fieldset class="form-group">
				<form:label path="taskName">Enter your Task Name : </form:label>
				<form:input path="taskName" type="text" class="form-control"
					required="required" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="taskDesc">Enter your Task Description :</form:label>
				<form:input path="taskDesc" type="text" class="form-control"
					required="required" />
				<form:errors path="taskDesc" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Enter Task Target :</form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>
			<input type="submit" class="btn btn-success">
		</form:form>
		<%-- <div class="warning"> ${validationErrors} </div> --%>
	</div>
		<%@ include file = "common/footer.jspf" %>
</body>
</html>