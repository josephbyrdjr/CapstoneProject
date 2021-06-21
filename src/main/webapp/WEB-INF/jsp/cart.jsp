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

	/* Add a color to the active/current link */
	.topnav a.active {
  		background-color: #04AA6D;
  		color: white;
	}
</style>
</head>

<body>
<div class="topnav">
  	<a class="active" href="/home">Home</a>
  	<a href="/catalog">Products</a>
  	<a href="#about">About</a>
  	<a href="/login">Login</a>
  	<a href="/register">Register</a>
	</div>
	<div class="container" style="margin-top: 5rem">
		<table id="cartTable" class="display">
			<thead>
				<tr>
					<th>Item Name</th>
					<th>Item</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Quantity x Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders}" var="order">
					<tr>
						<td><c:out value="${order.item.name}" /></td>
						<td><img height="100" width="auto" src="<c:out value="${order.item.thumbnail}"/>"/></td>
						<td><fmt:formatNumber value="${order.item.price}"
								type="currency" /></td>
						<td><c:out value="${order.quantity}" /></td>
						<td id="money"><fmt:formatNumber
								value="${order.item.price * order.quantity}" type="currency" /></td>
					</tr>
				</c:forEach>
				
			</tbody>
			<tfoot>
				
			</tfoot>
		</table>
		<h3 style="text-align: right"> Total: $${total}</h3>
	</div>
</body>

<script>
	var table = $(document).ready(function() {
		$('#cartTable').DataTable();

	});
	
</script>


</html>