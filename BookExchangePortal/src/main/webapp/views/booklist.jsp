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
        response.sendRedirect("login.jsp");
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
 <%@include file="dashboard.jsp"%>
 <div class="container"  >
    
   <p>${message}</p>
    <div class="input-group rounded">
        <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
             <span class="input-group-text border-0" id="search-addon">
             <span>
     
              <i class="fas fa-search"></i>
            </span>
     </div>
      <table class="table table-striped table-bordered">
         <thead>
            <tr class="thead-dark">
               <th scope="col">S.no</th>
               <th scope="col">Title</th>
               <th scope="col">Author</th>
               <th scope="col">Edition</th>
               <th scope="col">Action</th>
            </tr>
          </thead>
     <tbody>
      <c:set var="count" value="0" scope="page" />
     
      <c:forEach items ="${ list}"  var  = "book">

         <c:set var="count" value="${count + 1}" scope="page"/>
            <tr>
              <td>${count }</td>
              <td>${book.title}</td>
              <td>${book.author}</td>
              <td>${book.edition}</td>
              <td><a href = "${pageContext.request.contextPath}/BookController?action=DELETE&id=${book.title}">Delete</a> </td>
           </tr>
     </c:forEach>
      </tbody>
   </table> 
         <button type="button" class="btn btn-primary" onclick ="window.location.href='${pageContext.request.contextPath}/views/addbook.jsp'">Add</button>
</div>
</body>
</html>