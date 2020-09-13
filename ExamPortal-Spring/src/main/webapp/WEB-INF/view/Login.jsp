<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

</head>
<body class="container">
	<header>
		<jsp:include page="nav_public.jsp">
			<jsp:param name="page" value="signup" />
		</jsp:include>
	</header>
	<div style="margin-left: auto; margin-right: auto" class="col-sm-10">
		<c:if test="${not empty error}">
			<div class="error alert alert-dismissible alert-danger">
				<h2>${error}</h2>
			</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<form action="/process" method="post">
			<fieldset>
				<legend>Login Form</legend>
				<div class="form-group">
					<label for="inputUsername" class="control-label">USER NAME:</label>
					<div>
						<input type="text" name="username" class="form-control"
							id="inputUsername" placeholder="Username">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="control-label">PASSWORD</label>
					<div>
						<input id="pwd" type="password" name="password" onchange="check()"
							class="form-control" id="inputPassword" placeholder="Password">
					</div>
				</div>
				<br> <br>
				<div class="form-group">
					<div>
						<button id="submitBtn" type="submit" disabled="disabled"
							class="btn btn-primary">Submit</button>
					</div>
				</div>
			</fieldset>



		</form>

	</div>

	<script type="text/javascript">
		function check() {
			var userName = document.getElementById('inputUsername').value;
			var pwd = document.getElementById('pwd').value;
			document.getElementById('submitBtn').disabled = true;
			if (userName.length > 0 && pwd.length > 0) {
				document.getElementById('submitBtn').disabled = false;
			}
		}
	</script>

</body>
</html>