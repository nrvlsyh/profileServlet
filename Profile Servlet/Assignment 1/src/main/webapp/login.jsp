<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css'>
	<link rel="stylesheet" href="login.css">
<title>Login Page</title>
</head>
<body>

<div class="container">
	<div id="login-box">
		<div class="logo">
		<img src="http://placehold.it/100x100?text=DD" class="img img-responsive img-circle center-block"/>
		<h1 class="logo-caption"><span class="tweak">Please Sign In</span></h1>
		</div>

		<div class="controls">
			<form action="LoginServlet" method="post">
    		<input type="text" placeholder="Name" name="name"><br>
    
    		<input type="password" placeholder="Password" name="password"><br>

			<button type="submit" value="login" class="btn btn-default btn-block btn-custom">Login</button>
			</form>
		</div>
	</div>
</div>

<div id="particles-js"></div>
  <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css'></script>
<script src='https://code.jquery.com/jquery-1.11.1.min.js'></script><script  src="./script.js"></script>

</body>
</html>
