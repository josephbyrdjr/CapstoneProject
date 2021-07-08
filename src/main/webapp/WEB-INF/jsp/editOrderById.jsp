<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Edit Order</title>
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
  	<a href="/admin">Admin Home</a>
	</div>
        <br>
        
        <div class="container">
            <form method="POST" action="/admin/editOrderById/${order.id}" class="form-signin">
                <div class="container">
                
                    <h2 class="form-heading">Edit Order</h2>

                    <hr>
                    
                    <b>Status</b><input
                    type="text" class="form-control" value="${order.status}" name="status" id="status"
                    required> <br>

                     <hr>
                    <button type="submit" class="btn btn-md btn-primary">Edit Order</button><br>
                    
                </div>
            </form>
            <br><form  action = "../deleteOrder/${order.id}"  method = "delete" >
            <input  class = "btn btn-danger btn-md"  type = "submit" value="Delete Order" />
        </ form>
        </div>

        <br>
        <br>
    </body>
</html>