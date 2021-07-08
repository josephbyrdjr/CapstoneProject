<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Add New Item</title>
        <link rel = "icon" href = 
"https://t3.ftcdn.net/jpg/00/91/21/44/240_F_91214478_4YVDMLguSsobtMnFqgTuySCNFayrCOA6.jpg" 
        type = "image/x-icon">
        <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
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
    <body>
	<div class="topnav">
  	<a class="active" href="/">Home</a>
  	<a href="/admin">Admin Home</a>
	</div>
        <div class="container">
            <form method="POST" action="/admin/addItem" >
                <div class="container">
                    <h2 class="form-heading">New Item</h2>

                    <hr>
					
					<h3>Item Info</h3>
                    <b>Price</b><input type="text" class="form-control"
                    placeholder="Enter Price" name="price" id="price" required> <br>

                    <b>Name</b><input
                    type="text" class="form-control" placeholder="Enter Name" name="name" id="name"
                    required> <br>
                    
                    <b>Picture</b><input
                    type="text" class="form-control" placeholder="Enter Thumbnail" name="thumbnail" id="thumbnail"
                    required> <br>
                    
                    <b>Categories</b><input
                    type="text" class="form-control" placeholder="Enter Categories" name="category" id="category">
                    <br>
                    
                    <b>Description</b><input
                    type="text" class="form-control" placeholder="Enter Description" name="description" id="description">
                    <br>
                    
                     <b>Inventory</b><input
                    type="text" class="form-control" placeholder="Enter Inventory" name="inventoryLeft" id="inventoryLeft">
                    <br>
                    

                     <hr>
                    <button type="submit" class="btn btn-md btn-primary">Add Item</button>
                </div>
            </form>
        </div>
        <br>
        <br>
    </body>
</html>