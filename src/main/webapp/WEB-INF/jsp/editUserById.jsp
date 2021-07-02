<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Edit User</title>
        <link rel = "icon" href = 
"https://t3.ftcdn.net/jpg/00/91/21/44/240_F_91214478_4YVDMLguSsobtMnFqgTuySCNFayrCOA6.jpg" 
        type = "image/x-icon">
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
  	<a href="/admin">Admin Home</a>

	</div>
        <br>
        
        <div class="container">
            <form method="POST" action="/admin/editUserById/${user.id}" class="form-signin">
                <div class="container">
                
                    <h2 class="form-heading">Edit User</h2>

                    <hr>
					<b>Username</b><input
                    type="text" class="form-control" value="${user.username}" name="username" id="username"
                    required> <br>
                    
                    <b>Password</b><input
                    type="password" class="form-control" value="${user.password}" name="pwd" id="pwd"
                    required> <br>
                    
                     <b>First Name</b><input
                    type="text" class="form-control" value="${user.firstName}" name="firstName" id="firstName"
                    required> <br>
                    
                    <b>Last Name</b><input
                    type="text" class="form-control" value="${user.lastName}" name="lastName" id="lastName"
                    required> <br>
                    
                    <b>Email</b><input
                    type="text" class="form-control" value="${user.email}" name="email" id="email"
                    required> <br>
                    
                    <b>Phone Number</b><input
                    type="text" class="form-control" value="${user.phoneNumber}" name="phoneNumber" id="phoneNumber"
                    required> <br>
                    
                    <h3>Billing Info</h3>
                    
                    <b>Street Address</b><input
                    type="text" class="form-control" value="${user.address}" name="address" id="address"
                    required> <br>
                    
                    <b>Apartment Number</b><input
                    type="text" class="form-control" value="${user.apartmentNumber}" name="apartmentNumber" id="apartmentNumber"
                    > <br>
                    
                    <b>City</b><input
                    type="text" class="form-control" value="${user.city}" name="city" id="city"
                    required> <br>
                    
                    <b>State</b><input
                    type="text" class="form-control" value="${user.state}" name="state" id="state"
                    required> <br>
                    
                    <b>Zip</b><input
                    type="text" class="form-control" value="${user.zip}" name="zip" id="zip"
                    required> <br>

                     <hr>
                    <button type="submit" class="btn btn-md btn-primary">Edit User</button><br>
                    
                </div>
            </form><br>
            <form  action = "../deleteUser/${user.id}"  method = "delete" >
                <input  class = "btn btn-danger btn-md"  type = "submit" value="Delete User" />
            </form>
            <br>
        </div>

        <br>
        <br>
    </body>
</html>