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
  			<a href="/logout">Logout</a>
  		</c:otherwise>
  	</c:choose>
  	<a href="/order/shoppingCart" class="glyphicon glyphicon-shopping-cart" style="float:right"><span class="badge" style="background-color: blue">${cartQuantity}</span></a>
	</div>
	
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
				<c:forEach items="${orders}" var="order">
					<tr>
						<td><c:out value="${order.item.name}" /></td>
						<td><img height="100" width="125"
							src="<c:out value="${order.item.thumbnail}"/>" /></td>
						<td><fmt:formatNumber value="${order.item.price}"
								type="currency" /></td>
						<td><c:out value="${order.quantity}" /></td>
						<td id="money"><fmt:formatNumber value="${order.item.price}"
								type="currency" /> x ${order.quantity} = <fmt:formatNumber
								value="${order.item.price * order.quantity}" type="currency" /></td>

						<td>
							<form method="POST" action="/updateOrder"
								style="margin-top: 2rem">

								<div class="input-group">
									<input type="text" class="form-control" style="width: 50px;"
										placeholder=${order.quantity} name="quantity" id="quantity">
									<span> <input type="hidden" class="form-control"
										name="orderId" id="orderId" value=${order.id}>
									</span><span>
										<button class="btn bt-sm btn-primary" style="" type="submit">Edit</button>
									</span>
								</div>

								<br>

							</form>
						</td>
						<td>
							<form action="/deleteOrder/${order.id}" method="GET">
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
		</div>
	</div>
</body>

<script>
	var table = $(document).ready(function() {
		$('#cartTable').DataTable();

	});
</script>


</html>