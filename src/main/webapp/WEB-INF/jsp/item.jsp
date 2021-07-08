<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
  	<a href="#about">About</a>
  	<c:choose>
  		<c:when test="${username == 'anonymousUser'}">
  			<a href="/login">Login</a>
  			<a href="/register">Register</a>
  		</c:when>
  		<c:otherwise>
  			<a href="/logout">Logout</a>
  		</c:otherwise>
  	</c:choose>
		<a href="/orderItem/shoppingCart" class="glyphicon glyphicon-shopping-cart" style="float:right"><span class="badge" style="background-color: blue">${cartQuantity}</span></a>
	</div>
	<div class="card mb-3 bg-danger"
		style="max-width: 500px; max-height: 20rem; margin: 0 auto; margin-top: 100px">
		<div class="row no-gutters">
			<div class="col-md-4">

				<img src=${item.thumbnail } class="card-img"
					style="width: 22rem; height: 20rem; padding: 1px; border: 1px solid #021a40; background-color: black"
					alt="..." oncanplaythrough="">
			</div>
			<div class="col-md-8">
				<div class="card-body" style="margin-left: 60px;">
					<h4 class="card-title">${item.name}</h4>
					<h6 class="card-text">${item.category}</h6>
					<p class="card-text">${item.description}</p>
					<p class="card-text"><fmt:formatNumber
								value="${item.price}" type="currency" /></p>
					<form method="POST" action="/orderItem">
						<b>Quantity</b> Inventory: ${item.inventoryLeft}
						<div class="input-group">
							<input type="number" min="1" max=${item.inventoryLeft} class="form-control" style="width: 150px;"
								placeholder="Enter Quantity" name="quantity" id="quantity"
								required> <span>
								<input type="hidden" class="form-control"
								 name="itemId" id="itemId" value=${item.id}>
								 </span><span>
								<button class="btn bt-sm btn-primary" style="" type="submit">Add To Cart</button>
							</span>

						</div>

						<br>
						<td><input type="hidden" name="itemId" value=${item.id}
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