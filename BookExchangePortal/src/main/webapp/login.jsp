<%@page import="com.my.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>LoginPage</title>
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link href="../css/mystyle.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
			.banner-background{
				clip-path: polygon(0 0, 100% 0, 100% 30%, 100% 89%, 70% 100%, 31% 92%, 0 100%, 0% 30%);
			}
		</style>
	
	</head>
		<body>
			<!-- navbar  -->
			<%@include file="normal_navbar.jsp"%>
				
			<main class="d-flex align-items-center bg-primary banner-background  " style="height: 70vh">
				<div class="container">
					<div class="row">
						<div class="col-md-4 offset-md-4">
							<div class="card ">
								<div class="card-header bg-primary text-white text-center">
									<span class="fa fa-user-circle-o fa-3x"></span>
									<br>
									<p>Login here</p>
								</div>
								
								<%
                                Message m = (Message) session.getAttribute("msg");
                                if (m != null) {
	                            %>
	                            <div class="alert <%= m.getCssClass() %>" role="alert">
	                                <%= m.getContent() %>
	                            </div> 
	
	
	                            <%        
	                                    session.removeAttribute("msg");
	                                }
	                            %>
	                            
								<div class="card-body ">
									<form action="LoginServlet" method="POST">
									   <div class="form-group">
									    <label for="formGroupExampleInput">User ID</label>
									    <input name="user_id" type="text" class="form-control" id="formGroupExampleInput" placeholder="Enter User ID" required>
									  </div>
									  <div class="form-group">
									    <label for="exampleInputPassword1">Password</label>
									    <input name="user_password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
									  </div>
									  <label>Login as:  </label>
									  <br>
									  
									  <div class="form-group">
										  <div class="form-check form-check-inline">
											  <input class="form-check-input" type="radio" name="user_options" id="inlineRadio1" value="1" required>
											  <label class="form-check-label" for="inlineRadio1">NormalUser</label>
										  </div>
										  <div class="form-check form-check-inline">
											  <input class="form-check-input" type="radio" name="user_options" id="inlineRadio2" value="2">
											  <label class="form-check-label" for="inlineRadio2">Admin</label>
										  </div>
									  </div>
									<br>
									  <button type="submit" class="btn btn-primary">Submit</button>
									</form>
								</div>
							</div>
						</div>	
					</div>
				</div>
			</main>
		
			
			<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
			<script>
				$(document.ready(function()
				{
					alert("document loaded")
				})
			</script>
		</body>
</html>