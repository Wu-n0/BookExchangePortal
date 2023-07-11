<%@page import="com.my.entities.User"%>
<%@page import="com.my.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
 <html>
     <head>
         <title>Dashboard</title>
         <script src="https://kit.fontawesome.com/296765ba8c.js" crossorigin="anonymous"></script>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css">
         
        <link rel="stylesheet" type="text/css" href="../css/style.css ">
     </head>
     <body>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			  <a class="navbar-brand" href="#"><span class="fa fa-book"></span> BookExchange</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
			    
			      <li class="nav-item active">
			        <a class="nav-link" href="http://localhost:8080/BookExchangePortal/BookController">Home <span class="sr-only">(current)</span></a>
			      </li>
			      
			       <li class="nav-item dropdown active">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Books
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			          <a class="dropdown-item" href="http://localhost:8080/BookExchangePortal/BookController?action=listbooks">My Book</a>
			          <a class="dropdown-item" href="./views/addbook.jsp">Add Book</a>
			          <a class="dropdown-item" href="http://localhost:8080/BookExchangePortal/BookController?action=borrowedbooks">Borrowed Book</a>
			        </div>
			      </li>
			      
			      
				<li class="nav-item dropdown active">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          My Requests
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			          <a class="dropdown-item" href="http://localhost:8080/BookExchangePortal/RequestController?action=acceptrequests">Accept Request</a>
			          <a class="dropdown-item" href="http://localhost:8080/BookExchangePortal/RequestController?action=listrequest">Sent Request</a>
			        </div>
			      </li>
			      
			      
			     	<div  padding="10px" align="center"><a class="navbar-brand" href="#"> Search or Borrow a book</a></div>
			       
			    </ul>
			    <ul class="navbar-nav ml-auto">
			    
			    <li class="nav-item dropdown active">
			        <a class="nav-link dropdown-toggle " href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          <i class="fa fa-user" aria-hidden="true"></i> <%=user.getId()%>
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			          <a class="dropdown-item" href="#">Action</a>
			          <a class="dropdown-item" href="./changepassword.jsp">ChangePassword</a>
			          <div class="dropdown-divider"></div>
			          
			          <a class="dropdown-item" href="http://localhost:8080/BookExchangePortal/ShowAllUsers">ShowAllUsers</a>
			          <a class="dropdown-item" href="LogoutServlet">Logout</a>
			        </div>
			      </li>
			      <li>
			    <form action="http://localhost:8080/BookExchangePortal/BookController" method="get" class="form-inline my-2 my-lg-0">
			      <input class="form-control mr-sm-2" type="search" placeholder="Author or Title" aria-label="Search" name="query">
			      <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
			    </form>
			    </li>
			      </ul>
			  </div>
			</nav>
			
			
			
        
     </body>
     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 </html>