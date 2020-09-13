<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body class="container">
	<header>
		<jsp:include page="nav_public.jsp">
			<jsp:param name="page" value="signup" />
		</jsp:include>
	</header>
	<c:if test="${not empty message}">
		<div class="alert alert-dismissible alert-danger">
			<h3>
				<b>${message}</b>
			</h3>
		</div>
	</c:if>

	<form:form action="/newUserReg" method="post" name="form1"
		modelAttribute="User">

		<fieldset>
			<legend>Registration Form</legend>
			<div class="form-group">
				<label for="inputUsername" class="control-label">USER NAME</label>
				<div>
					<form:input type="text" name="username" class="form-control"
						path="username" maxlength="50" title="MAXIMUM 50 CHARACTERS ONLY"
						id="inputUsername" placeholder="Username" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="control-label">PASSWORD</label>
				<div>
					<form:input type="password" name="passWord" class="form-control"
						path="password" id="inputPassword" placeholder="Password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8  and not more than 50 characters."
						maxlength="50" required="required" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail" class="control-label">Email</label>
				<div>
					<form:input type="email" name="email" class="form-control"
						required="required" path="eMail" id="inputEmail"
						placeholder="Email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">Gender</label> <br>
				<div class="col-sm-5">
					<div class="radio">
						<label> <form:radiobutton name="gender" path="gender"
								required="required" id="optionsRadios1" value="m" checked="" />
							Male
						</label>
					</div>
				</div>
				<div class="col-sm-5">
					<div class="radio">
						<label> <form:radiobutton name="gender" path="gender"
								required="required" id="optionsRadios2" value="f" /> Female
						</label>
					</div>
				</div>
			</div>
			<br> <br>
			<div class="form-group">
				<div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</fieldset>
	</form:form>

</body>
</html>