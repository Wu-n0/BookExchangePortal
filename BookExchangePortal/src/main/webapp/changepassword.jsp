<%@page import="com.my.entities.User"%>
<%@page import="com.my.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null ) {
    	Message msg = new Message("you need to login!", "error", "alert-danger");
        HttpSession s = request.getSession();
        s.setAttribute("msg", msg);
        response.sendRedirect("login.jsp");
    }
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ChangePassword</title>
		
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
			
			<%@include file="/views/dashboard.jsp"%>
				
			<main class="d-flex align-items-center bg-primary banner-background  " style="height: 70vh">
				<div class="container">
					<div class="row">
						<div class="col-md-4 offset-md-4">
							<div class="card ">
								<div class="card-header bg-primary text-white text-center">
									<p>ChangePassword</p>
								</div>
								
								<%
                                Message m = (Message) session.getAttribute("msg");
                                if (m != null) {
	                            %>
	                            <div class="alert <%= m.getCssClass() %>" role="alert">
	                            	<h1>you have a message</h1>
	                                <%= m.getContent() %>
	                            </div> 
	
	
	                            <%        
	                                    session.removeAttribute("msg");
	                                }
	                            %>

	                            
								<div class="card-body ">
									<form id="reg-form" action="ChangePasswordServlet" method="POST">
									   <div class="form-group">
									    <label for="exampleInputPassword1">OldPassword</label>
									    <input name="old_password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
									  </div>
									  <div class="form-group">
									    <label for="exampleInputPassword1">NewPassword</label>
									    <input name="new_password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
									  </div>
									<br>
									  <button id="sumbimt-btn" type="submit" class="btn btn-primary">Submit</button>
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
			
		</body>
</html>