<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ONLINE EXAM PORTAL</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<header>

			<jsp:include page="nav_user.jsp">
				<jsp:param name="name" value="" />
			</jsp:include>
		</header>
		<form class="form-horizontal" method="post" action="/submitQuiz">
			<fieldset>
				<legend>
					<span class="text-right">TOPIC : ${topic_name}</span>
				</legend>
				<c:forEach items="${quiz_list}" var="quiz_ques"
					varStatus="loopCounter">
					<div class="quiz-ques form-group">
						<label class="col-lg-2 control-label">Question
							${loopCounter.count}</label>
						<div class="col-lg-10 text-left">
							<input type="hidden" value="${quiz_ques.id}"
								name="question${loopCounter.count}_id">
							<h5>${quiz_ques.text}</h5>
							<label> <input type="radio"
								name="question${loopCounter.count}_option" required="required"
								value="1"> ${quiz_ques.option1}
							</label><br> <label> <input type="radio"
								name="question${loopCounter.count}_option" required="required"
								value="2"> ${quiz_ques.option2}
							</label><br> <label> <input type="radio"
								name="question${loopCounter.count}_option" required="required"
								value="3"> ${quiz_ques.option3}
							</label><br> <label> <input type="radio"
								name="question${loopCounter.count}_option" required="required"
								value="4"> ${quiz_ques.option4}
							</label>
						</div>
					</div>
				</c:forEach>

				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-5">
						<button type="submit" class="btn btn-primary">Submit your
							Quiz</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>