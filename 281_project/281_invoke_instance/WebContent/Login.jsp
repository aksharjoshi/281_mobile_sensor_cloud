<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body background="${pageContext.request.contextPath}/images/blue-cloud.jpg">

 <div class="container">
    		<p><br/></p>
  		<div class="row">
  			<div class="col-md-8"></div>
  			<div class="col-md-4">
  				<div class="panel panel-default">
  					<div class="panel-body">
    						<div class="page-header">
  							<h3>Login</h3>
						</div>
						<form role="form" action="Login" method="post">
  							<div class="form-group">
    								<label for="Username">Email or Username</label>
    								<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
  									<input type="email" name="Username" class="form-control"  placeholder="Enter email">
								</div>
  							</div>
  							<div class="form-group">
    								<label for="password">Password</label>
    								<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-star"></span></span>
  									<input type="password"  name="Password" class="form-control" placeholder="Password">
								</div>
  							</div>
  							<hr/>
  							<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-log-in"></span> Login</button>
  						<p><br/></p>	
  							<p> Not a member? <a href="SignUp.jsp">Register Here</a> <span class="glyphicon glyphicon-arrow-right"></span></p>
						<p><br/></p>
						</form>
  					</div>
				</div>
  			</div>
		</div>
    </div>
<script type="text/javascript">
var msg =${alertm}; 
	alert(msg);
if(msg.length){
	alert(msg);
}
</script>
</body>
</html>