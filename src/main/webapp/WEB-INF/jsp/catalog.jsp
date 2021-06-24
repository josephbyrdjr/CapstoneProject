<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  	<a href="/order/shoppingCart" class="glyphicon glyphicon-shopping-cart" style="float:right"></a>
	</div>
	
	
	<div class="container">
		<h1>All Items</h1>
		<table id="itemTable" class="display">

			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Image</th>
					<th>Category</th>
					<th>Description</th>
					<th>View Item</th>

				</tr>
			</thead>
		</table>
	</div>

</body>




<script>
	$(document).ready(function() {
		var table = $('#itemTable').DataTable(
		{
			"sAjaxSource" : "/item",
			"sAjaxDataProp" : "",
			"order" : [ [ 0, "asc" ] ],
			"aoColumns" : [
				{"mData" : "name"},
				{"mData" : "price",
				 "mRender": function(mData, type, row){
					 return '$'+mData
				}
				},
				{"mData" : "thumbnail",
				"mRender" : function(mData, type, row) {
					return '<img src='+mData+' alt="images" width="100" height="75">'
				}
				}, 
				{"mData" : "category"},
				{"mData" : "description"},
				{"mData" : "id",
				"mRender" : function(mData, type, row) {
					return '<a class="btn btn-primary" href="/catalog/'+mData+'" role="button">View</button>'
				}}
				]
		})

	});
</script>


</html>