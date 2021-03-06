<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="wed, 01 Dec 2021 00:00:00 GMT">
<title>Map-Me-Mate</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Map-Me-Mate</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/register">Signup</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_REG' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>Hello ${user.firstname}, Welcome to Map-Me-Mate</h2><br>
					<h5>You have registered successfully! click here to <a href="/login">login</a></h5>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_HOME' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>Dear Student, Welcome to Map-Me-Mate</h2>
					<h5>To find accomdation! click here to <a href="/login">login</a></h5>
				</div>
				<div class="text-center">
				<p>Developed By SER531 Team 11 Fall 2021</p>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_HOME_LOGOUT' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>Thanks for your time</h2>
					<h5>You have logged out successfully! click here to <a href="/login">login</a></h5>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="user-registration">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-5">First Name</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="firstname"
								value="${user.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-5">Last Name</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="lastname"
								value="${user.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-5">Email</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="mail"
								value="${user.mail }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-5">University</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="university"
								value="${user.university }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-5">Password</label>
						<div class="col-md-3">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary" value="Register" /><br><br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/login">Already have an account?</a>
				<br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Developed By SER531 Team 11 Fall 2021
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Update User</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Mail id</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="mail"
								value="${user.mail }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstname"
								value="${user.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastname"
								value="${user.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Age </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="age"
								value="${user.age }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Address </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="address"
								value="${user.address }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Role</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="role"
								value="${user.role}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</form>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/search">
					<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<c:out value="${error }"></c:out>
						</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-5">Username</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-5">Password</label>
						<div class="col-md-3">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary" value="Login" />
					</div>
				</form>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/register">Don't have an account?</a>
				<br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Developed By SER531 Team 11 Fall 2021
			
			</div>
		</c:when>
	</c:choose>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	</body>
</html>