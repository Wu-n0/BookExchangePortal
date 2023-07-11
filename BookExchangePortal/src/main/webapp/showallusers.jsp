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
	<%@include file="/views/dashboard.jsp"%>
      <div class="container"  >
    
   <p>${message}</p>
   
      <table class="table table-striped table-bordered">
         <thead>
            <tr class="thead-dark">
            	<th scope="col">S.No</th>
               <th scope="col">ID</th>
               <th scope="col">Name</th>
               <th scope="col">Email</th>
               <th scope="col">Action</th>
            </tr>
          </thead>
     <tbody>
      <c:set var="count" value="0" scope="page" />
     	
      <c:forEach items ="${list}"  var  = "req">

         <c:set var="count" value="${count + 1}" scope="page"/>
            <tr>
              <td>${count }</td>
              <td>${req.id}</td>
              <td>${req.name}</td>
              <td>${req.email}</td>
              <td><a href = "${pageContext.request.contextPath}/DeleteUsers?action=deleterequest&id=${req.id}">Delete</a> </td>
           </tr>
     </c:forEach>
      </tbody>
   </table> 
         
</div>
</body>
</html>