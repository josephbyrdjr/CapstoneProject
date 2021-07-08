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
<title>About</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
<meta charset="ISO-8859-1">
<title>About Page</title>
<link rel = "icon" href = 
"https://t3.ftcdn.net/jpg/00/91/21/44/240_F_91214478_4YVDMLguSsobtMnFqgTuySCNFayrCOA6.jpg" 
        type = "image/x-icon">
</head>

<body>
	<div class="topnav">
		<a class="active" href="/">Home</a> <a href="/catalog">Products</a> <a
			href="/about">About</a>
		<c:choose>
			<c:when test="${username == 'anonymousUser'}">
				<a href="/login">Login</a>
				<a href="/register">Register</a>
			</c:when>
			<c:otherwise>
				<a href="/editUser">Edit User</a>
				<a href="/logout">Logout</a>
			</c:otherwise>
		</c:choose>
		<a href="/orderItem/shoppingCart" class="glyphicon glyphicon-shopping-cart" style="float:right"><span class="badge" style="background-color: blue">${cartQuantity}</span></a>

	</div>
	<div style="top: 0px; z-index: 999; text-align: center">
		<h2 class="form-heading"></h2>
	</div>



	<div class="container" style="width: 100rem; margin-top: 7rem;">
		<div class="jumbotron" style="vertical-align: middle">
			<h2 id="title" style="text-align: center; margin-bottom: 5rem;">About The Project</h2>
			<section style="display: flex; justify-content:center">
				<section style="margin-right: 5rem; width: 40rem; background-color: white; border-radius: 0.7rem;">
					<h3 style="text-align: center">Summary</h3>
					<p style="font-size: small; margin-left: 3rem; margin-right: 3rem">
					The main goal of this project is to simulate a real life music store.
					Users are able to register or login and browse the inventory. Buying is simplified
					by the easy-to-read design. Administration is able to view, edit, and delete users, 
					orders, and items. Securities are set in place to restrict unauthorized and unrecognized users.
					<br><br>Developers: Joseph Byrd, Braiden King, Michael Crawford, Austin Emert, Katharyn Eimandoust
					</section>

				<section style="margin-left: 5rem; width: 40rem; background-color: white; border-radius: 0.7rem;">
					<h3 style="text-align: center">Technologies Used</h3>
					<ul style="text-align: center">
						<li style="text-align: center">Java</li>
						<li>Spring Boot</li>
						<li>Maven</li>
						<li>MySQL</li>
						<li>Javascript</li>
						<li>Azure</li>
						<li>Heroku</li>
					</ul>
					</section>
			</section>

		</div>
	</div>
</body>
</html>