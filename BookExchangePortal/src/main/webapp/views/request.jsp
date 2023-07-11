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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<%@include file="dashboard.jsp"%>
<div></div>
<div class="container mb-5">
	<% String book=request.getParameter("booktitle");  %>
  <form action="${pageContext.request.contextPath}/RequestController?action=addrequest&title=<%=book%>" method="POST">
  
<!--  <script>title=localStorage.getItem("myTitle");--> 
<!--console.log(title);--> 
<!--document.getElementById("titlefor").innerHTML = title;--> 
<!--</script>-->  
 	
 	
   <li class="list-group-item ">
   
   <div align="center">
     <div class="title">
           <img src="img/<%=request.getParameter("imagepath") %>" width="200" height="200">
      </div>
         <h1><%=request.getParameter("booktitle") %></h1>
               </div>
     
    <br>
    <div class="form-group row">
      <label for="colFormLabel" class="col-sm-2 col-form-label">Date :</label>
      <div class="col-sm-6">
      <input type="datetime-local" class="form-control" name="date"  placeholder="date">
      </div>
    </div>
    
    
    <div class="form-group row">
      <label for="colFormLabel" class="col-sm-2 col-form-label">Place :</label>
      <div class="col-sm-6">
      <input type="text" class="form-control" name="place"  placeholder="place">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="colFormLabel" class="col-sm-2 col-form-label">Duration :</label>
      <div class="col-sm-6">
      <input type="text" class="form-control" name="duration"  placeholder="No of Days">
      </div>
    </div>
    
     
    <button type="submit" class="margin:auto display:block btn btn-danger">Request</button> 
    
     
   </li>
    </form>
  </div>
    
</body>
</html>