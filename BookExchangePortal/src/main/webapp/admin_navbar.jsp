<%@page import="com.my.entities.User"%>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#"><span class="fa fa-book"></span>BookExchange</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="profile.jsp">Home </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/views/booklist.jsp">Booklist</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
      
      
      
    </ul >
    

	<ul class="navbar-nav ml-auto">
		<li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          <%=user.getName() %>
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="changepassword.jsp">ChangePassword</a>
	          <a class="dropdown-item" href="DeleteUserServlet">DeleteUser</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="LogoutServlet">Logout</a>
	          
	        </div>
	        
	      </li>
	      
		
	    <a href="LogoutServlet" type="button" class="btn btn-secondary"><span class="fa fa-user-times"></span> Logout</a>
    </ul>
  </div>
  
</nav>