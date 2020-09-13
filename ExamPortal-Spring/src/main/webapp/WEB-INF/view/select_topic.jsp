<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ONLINE EXAM PORTAL</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<div class="container">
		<header>

			<jsp:include page="nav_user.jsp" />

		</header>
		<form class="form-horizontal" action="" id="topics" method="get"
			name="form1">
			<fieldset>
				<legend> Select Topic </legend>
				<div class="form-group">
					<div class="col-lg-1"></div>
					<div class="text-center col-lg-10" style="margin: 40px 0px;">
						<select class="form-control" required="required" id="myList"
							class="playlistname">
							<option disabled="disabled" selected="selected">Select
								Topic</option>
							<c:forEach items="${topic_list}" var="topic">
								<option value="${topic.id}">${topic.name}</option>

							</c:forEach>
						</select>
					</div>
					<div class="col-lg-1"></div>
				</div>

				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-5">
						<button type="button" onclick="get()" class="btn btn-primary">Start
							Quiz</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<script type="text/javascript">
		function get() {

			var topicId = document.getElementById('myList').value;
			document.getElementById('topics').setAttribute('action',
					'/showQuestions' + '/' + topicId);
			document.getElementById('topics').submit();
		}
	</script>
</body>
</html>