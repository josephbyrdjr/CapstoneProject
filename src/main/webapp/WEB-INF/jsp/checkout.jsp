<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css"
		href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
	<script type="text/javascript" charset="uft8"
		src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
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


		p{
			font-size: 30px;
		}

		.enMoney::before {
			content:"$";
		}

	</style>
        <title>Checkout</title>
    </head>

    <body>
    <div class="topnav">
  	<a class="active" href="/">Home</a>
  	<a href="/catalog">Products</a>
  	<a href="#about">About</a>
  	<c:choose>
  		<c:when test="${user.username == null}">
  			<a href="/login">Login</a>
  			<a href="/register">Register</a>
  		</c:when>
  		<c:otherwise>
			<a href="/editUser">Edit User</a>
  			<a href="/logout">Logout</a>
  		</c:otherwise>
  	</c:choose>
  	</div>
  	
  <div class="container">
  <div class="row">
    <div class="col-12 col-sm-8 col-lg-5"  style="text-align: left;">
      <h4>Your Order</h4> 
      <ul class="list-group">
      	<c:forEach items="${orderItems}" var="orderItem">
        <li class="list-group-item d-flex  justify-content-start align-items-center">
          <span class="image-parent">
              <img src=${orderItem.item.thumbnail} style= "width: 10rem; height: 8;" alt="quixote">
          </span>
          <b style="margin-left: 5rem">${orderItem.quantity}x ${orderItem.item.name}:</b>
          <span id="money"><fmt:formatNumber value="${orderItem.item.price * orderItem.quantity}" type="currency" /> 
        </li>
		</c:forEach>
      </ul>
    </div>
    </div>
  	<div class="col-sm">
  		<h4><u> Shipping Information </u></h4>
  		<p>
 			<b style="font-size: 20px">Name: </b><h5>${user.firstName} ${user.lastName} </h5><br>
 			<b style="font-size: 20px">Address: </b><h5>${user.address}, ${user.apartmentNumber}
 			${user.city}, ${user.state} ${user.zip}</h5>
 		</p>	
  		
  	</div>
  </div>
	
	<form  action = "/confirmation"  method = "POST" style="margin-left: 6rem">
      		<input  class = "btn btn-warning btn-md"  type = "submit" value="Place Order" /> 
    </form>
  	
</body>

<script>


</script>


</html>