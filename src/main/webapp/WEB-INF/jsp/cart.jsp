<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<title>Your Cart</title>
<link rel = "icon" href = 
"https://t3.ftcdn.net/jpg/00/91/21/44/240_F_91214478_4YVDMLguSsobtMnFqgTuySCNFayrCOA6.jpg" 
        type = "image/x-icon">
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

</style>
        
    </head>

    <body>
    <div class="topnav">
  	<a class="active" href="/">Home</a>
  	<a href="/catalog">Products</a>
  	<a href="/about">About</a>
  	<c:choose>
  		<c:when test="${username == null}">
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
	<h1 style="text-align: center">${msg}</h1>
	<div class="container" style="margin-top: 5rem; height: 10; width: 20">
		<table id="cartTable" class="display">
			<thead>
				<tr>
					<th>Item Name</th>
					<th>Item</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Quantity x Price</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderItems}" var="orderItem">
					<tr>
						<td><c:out value="${orderItem.item.name}" /></td>
						<td><img height="100" width="125"
							src="<c:out value="${orderItem.item.thumbnail}"/>" /></td>
						<td><fmt:formatNumber value="${orderItem.item.price}"
								type="currency" /></td>
						<td><c:out value="${orderItem.quantity}" /></td>
						<td id="money"><fmt:formatNumber value="${orderItem.item.price}"
								type="currency" /> x ${orderItem.quantity} = <fmt:formatNumber
								value="${orderItem.item.price * orderItem.quantity}" type="currency" /></td>

						<td>
							<c:choose>
								<c:when test="${orderItem.quantity > orderItem.item.inventoryLeft}">
									Please enter a quantity of ${orderItem.item.inventoryLeft} or less
								</c:when>
							</c:choose>
							<form method="POST" action="/updateOrderItem"
								style="margin-top: 2rem">

								<div class="input-group">
									<input type="number" style="width: 7rem" min="1" max=${orderItem.item.inventoryLeft} class="form-control" style="width: 50px;"
										placeholder=${orderItem.quantity} name="quantity" id="quantity">
									<span> <input type="hidden" class="form-control"
										name="orderId" id="orderId" value=${orderItem.id}>
									</span><span>
										<button class="btn bt-sm btn-primary" style="" type="submit">Edit</button>
									</span>
								</div>

								<br>

							</form>
						</td>
						<td>
							<form action="/deleteOrderItem/${orderItem.id}" method="GET">
								<input class="btn btn-primary" type="submit" value="Delete">
							</form>


						</td>
					</tr>
				</c:forEach>

			</tbody>
			<tfoot>

			</tfoot>
		</table>
		<div style="float: right;">
			<h3 style="">Total: $${total}</h3>
			<c:choose>
			<c:when test="${cartQuantity > 0}">
			<form action="/checkout" method="GET">
				<input class="btn btn-warning" type="submit" value="Proceed to Checkout">
			</form>
			</c:when>
			<c:otherwise>
			<form action="/checkout" method="GET">
				<input class="btn btn-warning" type="submit" disabled value="Proceed to Checkout">
			</form>
			</c:otherwise>
			</c:choose>
		</div>
	</div>
	
</body>

<script>
	var table = $(document).ready(function() {
		$('#cartTable').DataTable();

	});
	

</script>


</html>