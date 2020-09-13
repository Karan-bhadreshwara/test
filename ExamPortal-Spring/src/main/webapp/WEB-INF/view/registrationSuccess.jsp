<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>RegistrationSuccess</title>
</head>
<body class="container">

	<header>
		<jsp:include page="nav_public.jsp">
			<jsp:param name="page" value="signup" />
		</jsp:include>
	</header>
	<h2 style="margin-left: 25px; margin-top: 100px">
		REGISTRATION SUCCESSFUL :) <br>
		 LOGIN WITH YOUR USERNAME AND
		PASSWORD:=> <a href="/Login1"> LOGIN </a>
	</h2>
</body>
</html>