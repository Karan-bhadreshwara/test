<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.examPortal.entity.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ONLINE EXAM PORTAL</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="bootstrap/js/jquery-2.2.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<header>

			<jsp:include page="nav_user.jsp">
				<jsp:param name="page" value="user_index" />
			</jsp:include>
		</header>
		<%
			HttpSession httpSession = request.getSession(false);
			UserEnt user = (UserEnt) httpSession.getAttribute("USER");
		%>

		<div class="row">
			<div class="col-lg-6">
				Name :
				<%=user.getUsername()%>
			</div>
			<div class="col-lg-6 text-right">

				Email Address :
				<%=user.geteMail()%>

			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-6">
				<h4 class="userlist">
					Average Score :
					<fmt:formatNumber type="number" maxFractionDigits="2"
						value="${average_score}" />
				</h4>
			</div>
			<div class="col-lg-6 text-right">
				<h4 class="userlist">Total No. of Quiz : ${total_quiz}</h4>
			</div>
		</div>
		<fieldset style="margin-top: 20px;">
			<legend style="margin-bottom: 0px;">Previous Result</legend>
		</fieldset>
		<div class="col-lg-12">
			<table id="previous-result" class="table table-striped table-hover ">
				<thead>
					<tr>
						<th>#</th>
						<th>Quiz Topic</th>
						<th>Total Question</th>
						<th>Correct Question</th>
						<th>Score</th>
						<th>%</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${resultset}" var="result">

						<tr>
							<td><c:out value="${result.id}" /></td>
							<td><c:out value="${result.topic_name}" /></td>
							<td><c:out value="${result.no_of_question}" /></td>
							<td><c:out value="${result.no_of_correct_question}" /></td>
							<td><c:out value="${result.no_of_correct_question * 10}" /></td>
							<td><fmt:formatNumber
									value="${(result.no_of_correct_question * 10/(result.no_of_question*10))*100}"
									minFractionDigits="2" maxFractionDigits="2" /></td>
							<td><c:out value="${result.created_at}" /></td>
						</tr>
						<br>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>

</html>