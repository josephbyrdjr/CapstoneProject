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
<title>Item Page</title>
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

<body style="background-color:">
<div class="topnav">
  	<a class="active" href="#home">Home</a>
  	<a href="/catalog">Products</a>
  	<a href="#about">About</a>
  	<a href="/login">Login</a>
  	<a href="/register">Register</a>
	</div>
	<div class="card mb-3 bg-danger"
		style="max-width: 500px; max-height: 20rem; margin: 0 auto; margin-top: 100px">
		<div class="row no-gutters">
			<div class="col-md-4">
				<img src=${item.thumbnail } class="card-img"
					style="width: auto; height: 20rem; padding: 1px; border: 1px solid #021a40; background-color: #ff0;"
					alt="...">
			</div>
			<div class="col-md-8">
				<div class="card-body" style="margin-left: 50px;">
					<h4 class="card-title">${item.name}</h4>
					<h6 class="card-text">${item.category}</h6>
					<p class="card-text">${item.description}</p>
					<p class="card-text">$${item.price}</p>
					<form method="POST" action="/order">
						<b>Quantity</b>
						<div class="input-group">
							<input type="text" class="form-control" style="width: 150px;"
								placeholder="Enter Quantity" name="quantity" id="quantity"
								required> <span>
								<button class="btn bt-sm btn-primary" style="" type="submit">Buy</button>
							</span>
						</div>

						<br>
						<td><input type="hidden" name="itemId" value=${item.id
				}
							size="64" /></td>
					</form>


				</div>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>