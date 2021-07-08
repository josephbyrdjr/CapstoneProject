<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang= "en">
    <head>
        <meta charset="ISO-8859-1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Register New User</title>
        <link rel = "icon" href = 
"https://t3.ftcdn.net/jpg/00/91/21/44/240_F_91214478_4YVDMLguSsobtMnFqgTuySCNFayrCOA6.jpg" 
        type = "image/x-icon">
        <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
    /* Add a black background color to the top navigation */
.topnav {
	background-color: #1B2039;
	overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
	float: left;
	color: #d3e0e8;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}
.topnav a.active {
  	background: #2CC8E5;
  	color: white;
	}
/* Change the color of links on hover */
.topnav a:hover {
  	background: #2CC8E5;
	color: white;
	transition: 0.3s;
	
}


</style>
        
    </head>

    <body>
    <div class="topnav">
  	<a class="active" href="/">Home</a>
  	<a href="/catalog">Products</a>
  	<a href="/about">About</a>
  	<c:choose>
  		<c:when test="${username == 'anonymousUser'}">
  			<a href="/login">Login</a>
  			<a href="/register">Register</a>
  		</c:when>
  		<c:otherwise>
  			<a href="/logout">Logout</a>
  		</c:otherwise>
  	</c:choose>
  	<a href="/orderItem/shoppingCart" class="glyphicon glyphicon-shopping-cart" style="float:right"></a>
        </div>
        <br>
        <div class="container">
            <form method="POST" action="/register" class="form-signin">
                <div class="container">
                    <h2 class="form-heading">Register</h2>

                    <hr>
					
					<h3>Basic Info</h3>
                    <b>Username</b><input type="text" class="form-control"
                    placeholder="Enter Name" name="username" id="username" required> <br>

                    <b>Password</b><input
                    type="password" class="form-control" placeholder="Enter Password" name="pwd" id="pwd"
                    required> <br>
                    
                    <b>First Name</b><input
                    type="text" class="form-control" placeholder="Enter First Name" name="firstName" id="firstName"
                    required> <br>
                    
                    <b>Last Name</b><input
                    type="text" class="form-control" placeholder="Enter Last Name" name="lastName" id="lastName"
                    required> <br>
                    
                    <b>Email</b><input
                    type="text" class="form-control" placeholder="Enter Email" name="email" id="email"
                    required> <br>
                    
                    <b>Phone Number</b><input
                    type="text" class="form-control" placeholder="Enter Phone Number" name="phoneNumber" id="phoneNumber"
                    required> <br>
                    
                    <h3>Billing Info</h3>
                    
                    <b>Street Address</b><input
                    type="text" class="form-control" placeholder="Enter Street Address" name="address" id="address"
                    required> <br>
                    
                    <b>Apartment Number</b><input
                    type="text" class="form-control" placeholder="Enter Apartment Number" name="apartmentNumber" id="apartmentNumber"
                    > <br>
                    
                    <b>City</b><input
                    type="text" class="form-control" placeholder="Enter City" name="city" id="city"
                    required> <br>
                    
                    <b>State</b><input
                    type="text" class="form-control" placeholder="Enter State" name="state" id="state"
                    required> <br>
                    
                    <b>Zip</b><input
                    type="text" class="form-control" placeholder="Enter Zip Code" name="zip" id="zip"
                    required> <br>

                     <hr>
                    <button type="submit" class="btn btn-md btn-primary">Register</button>
                </div>
            </form>
        </div>
        <br>
        <br>
    </body>
</html>