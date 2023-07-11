<%@page import="com.my.entities.Message"%>
<%@page import="com.my.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%
    User user = (User) session.getAttribute("currentUser");
	
    if (user == null) {
    	Message msg = new Message("Invalid Details ! try with another", "error", "alert-danger");
        HttpSession s = request.getSession();
        s.setAttribute("msg", msg);
        response.sendRedirect("http://localhost:8080/BookExchangePortal/login.jsp");
    }
    String userid1=user.getId();
%> 
<!DOCTYPE html>
<html>
<head>
 <meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="./views/css/grid.css">-->
    <!--<link rel="stylesheet" href="./views/css/sidebar.css">-->
    <link
    rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
    crossorigin="anonymous"/>
    <title>Document</title>
</head>
<body>
    <!-- navigation to other pages starts here -->
  
<%@include file="dashboard.jsp"%>
<br>
<div class="col-sm">
<div class="card-deck ">
		<c:set var="userid" scope="session" value= "<%=userid1%>"></c:set>
        <c:forEach items="${bookposts}" var="post">
            <div class="card">
            	<div align="center">
               	<div class="title">
                    <img src="img/${post.imagepath}" width="200" height="200">
                </div>
               </div>
                <div class="title">
                    <h5 class="text-center text-success">${post.title}</h5>
                </div>
                <div class="text text-center">
                    <div class="row ml-3">
                    	<div class="col">
                    	<span class="text-primary font-weight-bold text-justify">Author:</span>
                    	</div>
                    	<div class="col">
                    	<p>${post.author}</p>
                    	</div>
                    </div>
                    <div class="row ml-3">
                    	<div class="col">
                    	<span class="text-primary font-weight-bold text-justify">Publisher:</span>
                    	</div>
                    	<div class="col">
                    	<p>${post.publisher}</p>
                    	</div>
                    </div>
                    <div class="row ml-3">
                    	<div class="col">
                    	<span class="text-primary font-weight-bold text-justify">Edition:</span>
                    	</div>
                    	<div class="col">
                    	<p>${post.edition}</p>
                    	</div>
                    </div>
                    <div class="row ml-3">
                    	<div class="col">
                    	<span class="text-primary font-weight-bold text-justify">Year:</span>
                    	</div>
                    	<div class="col">
                    	<p>${post.year}</p>
                    	</div>
                    </div>
                    <div class="row ml-3">
                    	<div class="col">
                    	<span class="text-primary font-weight-bold text-justify">BookStatus:</span>
                    	</div>
                    	<div class="col">
                    	<p>${post.bookstatus}</p>
                    	</div>
                    </div>
                   	
                   		<button <c:if test="${post.ownerid==userid}"><c:out value="disabled='disabled'"/></c:if>" type="submit" class="margin:auto display:block btn btn-secondary" onclick="window.location.href='views/request.jsp?booktitle=${post.title}&imagepath=${post.imagepath}'" >Borrow</button>
                   	
                      
                       <button type="submit" class="margin:auto display:block btn btn-secondary" onclick="window.location.href='BookController?action=showtransactions&q=${post.title}'" >Show Transactions</button>
                    
                </div>


            </div>
        </c:forEach>
    </div>
    </div>
</body>
</html>