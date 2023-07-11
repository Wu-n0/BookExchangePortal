<%@page import="com.my.helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>BookExchangePortal</title>
		
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
		
		<div class = "jumbotron bg-primary text-white banner-background">
			<div class= "container ">
				<h2>Welcome to BookExchange</h3>
				<p>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus dapibus, erat id dignissim facilisis, enim orci rutrum neque, ac tincidunt dui nibh non ex. Nam nec tincidunt sapien. Aenean blandit dui eget lorem interdum, et sagittis ligula sodales. Cras mollis tincidunt semper. Nulla cursus est quis diam placerat, vitae ultrices eros feugiat. Nulla dolor dolor, cursus et risus et, faucibus mollis nibh. Duis ut tempor massa. Curabitur vitae metus commodo quam aliquet auctor sit amet eu leo. Duis a consequat risus. In vestibulum lectus a molestie gravida. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer ac mollis turpis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec tristique diam cursus purus lacinia, sit amet fermentum lectus maximus. Pellentesque quis gravida augue. Maecenas malesuada hendrerit posuere.
				</p>
				 
				 <a href="./login.jsp" type="button" class="btn btn-primary"><span class="fa fa-user-plus"></span> Get started</a>
				 <a href="./login.jsp" type="button" class="btn btn-primary"><span class="fa fa-user-circle-o"></span> login</a>
				 
			</div>
		</div>
		
		<h1>Testing...</h1>
		<% Connection con= ConnectionProvider.getConnection();%>
		<h1><%= con %></h1>
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