<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
        <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
    /* Add a black background color to the top navigation */
	.topnav {
  		background-color: #333;
  		overflow: hidden;
	}

	/* Style the links inside the navigation bar */
	.topnav a {
  		float: left;
  		color: #f2f2f2;
  		text-align: center;
 		padding: 14px 16px;
 		text-decoration: none;
  		font-size: 17px;
	}

	/* Change the color of links on hover */
	.topnav a:hover {
 		background-color: #ddd;
  		color: black;
	}

	/* Add a color to the active/current link */
	.topnav a.active {
  		background-color: #04AA6D;
  		color: white;
	}
</style>
    </head>

    <body>
    <div class="topnav">
  	<a class="active" href="/">Home</a>
  	<a href="/catalog">Products</a>
  	<a href="#about">About</a>
  	<a href="/login">Login</a>
  	<a href="/register">Register</a>
	</div>
        <br>
        
        <div class="container">
            <form method="POST" action="/admin/editUserById/${userId}" class="form-signin">
                <div class="container">
                
                    <h2 class="form-heading">Edit User</h2>

                    <hr>
					<b>Username</b><input
                    type="text" class="form-control" placeholder="Enter Username" name="username" id="username"
                    required> <br>
                    
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
                    <button type="submit" class="btn btn-md btn-primary">Edit User</button>
                </div>
            </form>
        </div>
        <br>
        <br>
    </body>
</html>