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
		<img src="http://placehold.it/100x100?text=:3" class="img img-responsive img-circle center-block"/>
		<h1 class="logo-caption"><span class="tweak">Please Sign In</span></h1>
		</div>

		<div class="controls">
			<form id="login_form" class="loginform login_class" action="LoginServlet" method="post">
			
			<%
        	 	if(session.getAttribute("loginFail") != null && "true".equals(session.getAttribute("loginFail").toString())) {
        	%>
	 			<div class="alert alert-danger" role="alert"> 
	 				Invalid username or password.
	 			</div>
			<% 
					session.setAttribute("loginFail","false");			
        	 	} 
			%>
			
    		<input type="text" autocomplete="off" name="username" placeholder=" Enter your Username" required="true"><br>
    
    		<input id="pass" type="password" autocomplete="off" name="password" placeholder=" Enter your password" required="true"><br>

			<button type="submit" value="login" class="btn btn-default btn-block btn-custom">Login</button>
			
			<p class="text" style=color:white>Don't have an account? Create one now!<br>
        <a href="register.jsp">Sign up</a></p>
			
			</form>
		</div>
	</div>
</div>

<div id="particles-js"></div>
  <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css'></script>
<script src='https://code.jquery.com/jquery-1.11.1.min.js'></script><script  src="./script.js"></script>

</body>
</html>
