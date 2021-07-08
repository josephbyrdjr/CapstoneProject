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
<title>Welcome to the Music Store</title>
<link rel = "icon" href = 
"https://t3.ftcdn.net/jpg/00/91/21/44/240_F_91214478_4YVDMLguSsobtMnFqgTuySCNFayrCOA6.jpg" 
        type = "image/x-icon">
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

.tradingview-widget-container {
	position: absolute;
	left: 20%;
}


</style>

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
		<c:choose>
			<c:when test="${username == 'anonymousUser'}">
				<h2 class="form-heading">Welcome to the Music Store!</h2>
			</c:when>
			<c:otherwise>
				<h2 class="form-heading">Welcome, ${username}!</h2>
			</c:otherwise>
		</c:choose>
	</div>
	

	<div class ="container" style="width: 100rem;">
	<div class="jumbotron">
		<h3 id="title" style="text-align: center"></h3>
		<div id="image" style="text-align: center"></div>
		<h5 id="description" style="text-align: center"></h5>
		<div id="url" style="text-align: center"></div>
		
	</div>
	</div>

<!-- BEGIN Stock Widget -->
<div class="tradingview-widget-container">
  <script type="text/javascript" src="https://s3.tradingview.com/external-embedding/embed-widget-market-overview.js" async>
  {
  "colorTheme": "light",
  "dateRange": "12M",
  "showSymbolLogo": true,
  "width": "78%",
  "height": "90%",
  "plotLineColorGrowing": "rgb(4,170,109)",
  "plotLineColorFalling": "rgb(4,170,109)",
  "gridLineColor": "rgba(240, 243, 250, 1)",
  "scaleFontColor": "rgba(120, 123, 134, 1)",
  "belowLineFillColorGrowing": "rgba(123, 234, 193, 0.27)",
  "belowLineFillColorFalling": "rgba(123, 234, 193, 0.27)",
  "symbolActiveColor": "rgba(33, 150, 243, 0.12)",
  "tabs": [
    {
      "title": "Music Stocks",
      "symbols": [
        {"s": "NYSE:SPOT", "d": "Spotify"},
        {"s": "NASDAQ:AAPL", "d": "Apple"},
        {"s": "NASDAQ:SIRI", "d": "Sirius XM"},
        {"s": "NASDAQ:AMZN", "d": "Amazon"},
        {"s": "NYSE:TME", "d": "Tencent Music Entertainment Group"},
        {"s": "NYSE:SONY", "d": "Sony"},
        {"s": "CRYPTOCAP:DOGE", "d": "Dogecoin"}
      ],
      "originalTitle": "Indices"
    }
  ]
}
</script>
</div>
<!-- END Stock Widget -->
	

	<script>
  $(document).ready(function() {
	    $.ajax({
	        url: "https://gnews.io/api/v4/search?q=music+performance&token=41ad6cca1555dd435aaa6a2fbe57d542"
	    }).then(function(data) {
	    	console.log(data);
	        let randNum = Math.floor(Math.random() * 9) + 1;
	      	var description = data.articles[randNum].description;
	      	var title = data.articles[randNum].title;
	      	var image = data.articles[randNum].image;
	      	var url = data.articles[randNum].source.url;

	      	$('#title').append(title);
	      	$('#description').append(description);
	      	$('#image').prepend('<img src ='+image+' style="width: 25rem; height: 20rem;"/>');
	      	$('#url').prepend('<a class="btn btn-primary" href="'+url+'" role="button">Go To Article</a>');

	    });
	});
  
  
  
  </script>

	

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
<footer> </footer>
</html>