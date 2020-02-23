<%@ include file="common/taglibs_pagetags.jspf"%>
<!DOCTYPE html>
<html>
<%@ include file="common/header.jspf"%>
<body>
	<%@ include file="common/navigation.jspf"%>
	<div class="container">
		Welcome ${name} to the First JSP. <BR />Your Login Time is
		<%Date date = new Date();%>
		<%=date%>
		<h1>Search Task</h1>
		<form:form action="/my-web/listTasks" method="Post">
			<fieldset>
				<label>Enter your Task Name to Search</label> 
				<input type="text" name="taskName" class="form-control" required="required">
			</fieldset>
			<br />
			<input type="submit" class="btn btn-success">
		</form:form>

</div>
	<%@ include file="common/footer.jspf"%>
</body>
</html>