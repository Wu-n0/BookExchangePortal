<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>	RegisterPage</title>
		
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
			<main class="d-flex align-items-center bg-primary banner-background  " style="height: 92vh">
				<div class="container">
					<div class="row">
						<div class="col-md-6 offset-md-3">
							<div class="card ">
								<div class="card-header bg-primary text-white text-center">
									<span class="fa fa-user-plus fa-3x"></span>
									<br>
									<p>Login here</p>
								</div>
								<div class="card-body ">
									<form id="reg-form" action="RegisterServlet" method="POST">
									  <div class="form-row">
									  
									    <div class="form-group col-md-6">
									      <label for="inputEmail4">UserID</label>
									      <input name="user_id" type="text" class="form-control" id="inputEmail4" placeholder="UserID">
									    </div>
									    <div class="form-group col-md-6">
									      <label for="inputPassword4">Username</label>
									      <input name="user_name" type="text" class="form-control" id="inputPassword4" placeholder="username">
									    </div>
									  </div>
									
									
									  <div class="form-row">
									    <div class="form-group col-md-6">
									      <label for="inputEmail4">Email</label>
									      <input  name="user_email" type="email" class="form-control" id="inputEmail4" placeholder="Email">
									    </div>
									    <div class="form-group col-md-6">
									      <label for="inputPassword4">Password</label>
									      <input name="user_password" type="password" class="form-control" id="inputPassword4" placeholder="Password">
									    </div>
									  </div>
									  
									  <div class="form-group">
									    <label for="inputAddress">Address</label>
									    <input name="user_address" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
									  </div>
									  
									    
									    <div class="form-group">
									      <label for="inputZip">Phone number</label>
									      <input name="user_number" type="tel" class="form-control" id="inputZip">
									    </div>
							
									  
									  <div class="form-group">
										  <div class="form-check form-check-inline">
											  <input class="form-check-input" type="radio" name="user_options" id="inlineRadio1" value="1">
											  <label class="form-check-label" for="inlineRadio1">NormalUser</label>
										  </div>
										  <div class="form-check form-check-inline">
											  <input class="form-check-input" type="radio" name="user_options" id="inlineRadio2" value="2">
											  <label class="form-check-label" for="inlineRadio2">Admin</label>
										  </div>
									  </div>
									  
									  <button id="sumbimt-btn" type="submit" class="btn btn-primary">Register</button>
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
		
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script>
            $(document).ready(function () {
                console.log("loaded........")
                $('#reg-form').on('submit', function (event) {
                    event.preventDefault();
                    let form = new FormData(this);
                    $("#sumbimt-btn").hide();
                    //send register servlet:
                    $.ajax({
                        url: "RegisterServlet",
                        type: 'POST',
                        data: form,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data)
                            $("#sumbimt-btn").show();
                            if (data.trim() === 'successful')
                            {
                            	alert("your are being directed to login page.......");
                            	window.location = "login.jsp"
                                
                            } else
                            {
                            	alert("User already exists!!!");
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $("#sumbimt-btn").show();
                            $("#loader").hide();
                            swal("something went wrong..try again");
                        },
                        processData: false,
                        contentType: false
                    });
                });
            });
        </script>
	</body>
</html>