<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Registration</title>
</head>
<body background="${pageContext.request.contextPath}/images/blue-cloud.jpg">
<div class="container-fluid">
    		<p><br/></p>
  		<div class="row">
  		<div class="col-md-4"></div>
  			<div class="col-md-4">
  				<div class="panel panel-default">
  					<div class="panel-body">
    						<div class="page-header">
  							<h3>Registration</h3>
						</div>
						<form action="SignUp" method="post">
  							<div class="form-group">   								
    								<label for="FirstName">First Name</label>
    								<div class="input-group">
    								<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
  									<input type="text"  class="form-control" id="FirstName" name="FirstName" placeholder="First Name">
  									</div>
  									
  									
    								<label for="LastName">Last Name</label>
    								<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
  									<input type="text"  class="form-control" id="LastName"  name="LastName"placeholder="Last Name">					
  							</div>
  								
  							</div>
  							
  							<div class="form-group">
    								<label for="exampleInputEmail1">Email or Username</label>
    								<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
  									<input type="email" class="form-control" id="UserName" name="UserName" placeholder="Enter email">
								</div>
  							</div>
  							
  							<div class="form-group">
    								<label for="Password">Password</label>
    								<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-star"></span></span>
  									<input type="password"  class="form-control" id="Password"  name="Password" placeholder="Password">
								</div>
  							</div>			
  							<div class="form-group">
    								<label for="Phone">Phone Number</label>
    								<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
  									<input type="text"  class="form-control" id="Phone" name="Phone" placeholder="Phone number">
								</div>
  							</div>
  							
  							<div class="form-group">
    								<label for="City">City</label>
    								<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span>
  									<input type="text"  class="form-control" id="City" name="City" placeholder="City">
								</div>
  							</div>
  							
  							<div class="form-group">
    								<label for="State">State</label>
    								<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span>
  									<input type="text" class="form-control" id="State" name="State" placeholder="State">
								</div>
  							</div>
  							
  							<div><label for="dropdown">Country</label>
  								<div class="dropdown">
    								<input type="hidden" name="Country1" id="dropdown">
    								<select name="Country"> 
    									<span class="caret"></span>
        								<option value="dropdown">Please select one</option>
        								<option value="UnitedStates">United States</option>
        								<option value="UnitedKingdom">United Kingdom</option>
        								<option value="India">India</option>
        								<option value="Australia">Australia</option>
    								</select>			
  								</div>
  							
  							</div>
  							<hr/>
  							<button type="button" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left"></span> Back</button>
  							<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-circle-arrow-right"></span> Register</button>
  							<p><br/></p>
						</form>
  					</div>
				</div>
  			</div>
		</div>
    </div>


<div class="col-md-4"></div>

</body>
</html>