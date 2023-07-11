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
        response.sendRedirect("../login.jsp");
    }
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
<br>
<!--  <form ></form> -->
 <div class="container mb-5">
  <form action="${pageContext.request.contextPath}/BookController" method="POST" enctype="multipart/form-data">
   <li class="list-group-item ">
    
    <div class="form-group row">
      <label for="colFormLabel" class="col-sm-2 col-form-label">BookTitle :</label>
      <div class="col-sm-6">
      <input type="text" class="form-control" name="title"  placeholder="book title">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="colFormLabel" class="col-sm-2 col-form-label">Author :</label>
      <div class="col-sm-6">
      <input type="text" class="form-control"  name="author"  placeholder="author">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="colFormLabel" class="col-sm-2 col-form-label">Publisher :</label>
      <div class="col-sm-6">
      <input type="text" class="form-control" name="publisher"  placeholder="publisher">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="colFormLabel" class="col-sm-2 col-form-label">Edition :</label>
      <div class="col-sm-6">
      <input type="text" class="form-control" name="edition" placeholder="edition">
     </div>
    </div> 
    
    <div class="form-group row">
      <label for="colFormLabel" class="col-sm-2 col-form-label">Year :</label>
      <div class="col-sm-6">
      <input type="text" class="form-control"  name="year"  placeholder="year">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="colFormLabel" class="col-sm-2 col-form-label">File :</label>
      <div class="col-sm-6">
      <input type="file" class="form-control"  name="image"  placeholder="year">
      </div>
    </div>
    
    <button type="submit" class="margin:auto display:block btn btn-success">Add</button> 
    
     
   </li>
    </form>
  </div>
</body>
</html>