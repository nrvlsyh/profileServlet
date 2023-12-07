<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css'>
	<link rel="stylesheet" href="login.css">
<title>Register Page</title>
</head>
<body>


<div class="container">
	<div id="login-box">
		<div class="logo">
		<img src="http://placehold.it/100x100?text=:3" class="img img-responsive img-circle center-block"/>
		<h1 class="logo-caption"><span class="tweak">Sign Up First!</span></h1>
		</div>

		<div class="controls">
		
			<form id="login_form" class="loginform login_class" action="registerServlet" method="post">      <!-----forwarding responses to the servlet----->
          
          <div class="container">
          
          
    		<%
        	 	if(session.getAttribute("registerFail") != null && "true".equals(session.getAttribute("registerFail").toString())) {
        	%>
	 			<div class="alert alert-danger" role="alert"> 
	 				An account with the username already exist.<br>
	 			</div>
			<% 
					session.setAttribute("registerFail","false");			
        	 	}
    		%>
    		<%
        	 	if(session.getAttribute("registerSuccess") != null && "true".equals(session.getAttribute("registerSuccess").toString())) {
        	%>
	 			<div class="alert alert-success" role="alert"> 
	 				Register successful.<br>
	 			</div>
			<% 
					session.setAttribute("registerSuccess","false");			
        	 	} 
			%>
			
			<%
        	 	if(session.getAttribute("passwordFail") != null && "true".equals(session.getAttribute("passwordFail").toString())) {
        	%>
	 			<div class="alert alert-danger" role="alert"> 
	 				Your retype password does not match.<br>
	 			</div>
			<% 
					session.setAttribute("passwordFail","false");			
        	 	} 
			%>
			
			
			
    		<div class="box">
        		<p style=color:white>*Name</p>
        		<div> <input type="text" autocomplete="off" name="name" placeholder=" Enter your full name" required="true"> </div>
    		</div>
    		<div class="box">
        		<p style=color:white>*Email</p>
        		<div> <input type="email" autocomplete="off" name="email" placeholder=" Enter your email" required="true"> </div>
    		</div>
    		<div class="box">
        		<p style=color:white>*Username</p>
        		<div> <input type="text" autocomplete="off" name="username" placeholder=" Enter your username" required="true"> </div>
    		</div>
    		<div class="box">
        		<p style=color:white>Password (8 characters minimum):</p>
        		<div> <input id="pass" type="password"  minlength="8" autocomplete="off" name="password" placeholder=" Enter your password" required="true"> </div>
        		<div class="box">
        		<p style=color:white>Re-type password:</p>
        		<div> <input id="rpass" type="password"  minlength="8" autocomplete="off" name="password1" placeholder=" Enter your password" required="true"> </div>

    		</div> <button class="loginBtn" type="submit" id=sub >Register</button>
    		<p class="text" style=color:white>Have an account? Sign in now!<br>
        	<a href="login.jsp">Sign in</a></p>
			</div>
			</div>
			</form>
		</div>
	</div>
</div>

<div id="particles-js"></div>
  <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css'></script>
<script src='https://code.jquery.com/jquery-1.11.1.min.js'></script><script  src="./script.js"></script>

</body>

</html>