<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Welcome to the Admin Page</title>
        <link rel = "icon" href = "https://t3.ftcdn.net/jpg/00/91/21/44/240_F_91214478_4YVDMLguSsobtMnFqgTuySCNFayrCOA6.jpg"    
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
        <div style="top:0px; z-index:999;text-align:center">
        <h2 class="form-heading">Welcome, ${user.firstName}!</h2>
        </div>
		<div style="position:absolute;top:60px;right:15px; z-index:999" >
            <form method="POST" action="/logout">
                <button style="width: 10rem;" class="btn bt-sm btn-primary" type="submit">Log Out</button>
            </form>
        </div>
        <div class="container" style="width: 50rem;">
        <div class="jumbotron" style="vertical-align: middle; text-align: center">
        <h3 style="margin-bottom: 5rem; ">Administration Actions</h3>
        <div style="text-align: center; margin-top: 2rem;">
            <form method="GET" action="/admin/allUsers">
                <button style="width: 10rem;" class="btn bt-sm btn-primary" type="submit">All Users</button>
            </form>
        </div><br>
        <div style="text-align: center">
            <form method="GET" action="/admin/allOrders">
                <button style="width: 10rem;" class="btn bt-sm btn-primary" type="submit">All Orders</button>
            </form>
        </div><br>
        <div style="text-align: center">
            <form method="GET" action="/admin/allItems">
                <button style="width: 10rem;" class="btn bt-sm btn-primary" type="submit">All Items</button>
            </form>
        </div><br>
        
        <div style="text-align: center">
            <form method="GET" action="/admin/addItem">
                <button style="width: 10rem;" class="btn bt-sm btn-primary" type="submit">Add Item</button>
            </form>
        </div>
        </div>
        </div>

        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>