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
<script src="https://kit.fontawesome.com/296765ba8c.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<%@include file="dashboard.jsp"%>
      <div class="container"  >
    
   <p>${message}</p>
   
      <table class="table table-striped table-bordered">
         <thead>
            <tr class="thead-dark">
               <th scope="col">S.no</th>
               <th scope="col">Title</th>
               <th scope="col">GivenBy</th>
               <th scope="col">TakenBy</th>
               <th scope="col">DateTaken</th>
               <th scope="col">Duration</th>
            </tr>
          </thead>
     <tbody>
      <c:set var="count" value="0" scope="page" />
     	
      <c:forEach items ="${list}"  var  = "req">

         <c:set var="count" value="${count + 1}" scope="page"/>
            <tr>
              <td>${count }</td>
              <td>${req.title}</td>
              <td>${req.givenby}</td>
              <td>${req.takenby}</td>
              <td>${req.datetaken}</td>
              <td>${req.returnduration}</td>
           </tr>
     </c:forEach>
      </tbody>
   </table> 
         
</div>
</body>
</html>