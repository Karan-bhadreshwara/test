<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Processing</title>
</head>
<body>

	<div style="margin-left: 650px; margin-top: 250px">PLEASE WAIT
		...!!! GETTING YOUR ACCOUNT DETAILS :)</div>
	<br>
	<br>
	<i class="fa fa-spinner fa-spin"
		style="font-size: 100px; margin-left: 750px; margin-top: 25px"></i>


	<script type="text/javascript">
		window.onload = function() {
			setTimeout(function() {
				location.href = '/Home';
			}, 1500);
		}
	</script>
</body>
</html>