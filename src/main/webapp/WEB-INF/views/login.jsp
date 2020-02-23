<%@ include file="common/taglibs_pagetags.jspf"%>
<!DOCTYPE html>
<html>
<%@ include file="common/header.jspf"%>
<body>
	<%@ include file="common/navigation.jspf"%>
	<div class="container">
		<font color="red">${errormsg}</font>
		<form:form action="/my-web/check" method="Post">
			<fieldset>
				<label>Enter your User Name</label> 
				<input type="text" name="name"
					value="${name}" class="form-control" required="required">
			</fieldset>
			<br />
			<fieldset>
				<label>Enter your Password</label> 
				<input type="password" name="pwd"
					class="form-control" required="required">
			</fieldset>
			<br />
			<input type="submit" class="btn btn-success">
		</form:form>
	</div>
	<%@ include file="common/footer.jspf"%>
</body>
</html>