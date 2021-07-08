<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<title>All Orders</title>
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
  	<a href="/admin">Admin Home</a>
	</div>
	<div class="container" >
		<h1>All Orders</h1>
		<table id="ordersTable" class="display">

			<thead>
				<tr>
					<th>ID</th>
					<th>Status</th>
					<th>User</th>
					<th>Items Ordered</th>
					<th>Edit</th>

				</tr>
			</thead>
		</table>
	</div>

</body>




<script>
	$(document).ready(function() {
		var table = $('#ordersTable').DataTable(
		{
			"sAjaxSource" : "/order",
			"sAjaxDataProp" : "",
			"orderItem" : [ [ 0, "asc" ] ],
			"columnDefs" : [{"width" : "35%", "targets" : 3}],
			"aoColumns" : [
				
				{"mData" : "id"},
				{"mData" : "status"},
				{"mData" : "user.username"},
				{"mData" : "orderItems",
				"mRender" : function(mData, type, row){
					var nameArr = [];
					for(var i = 0; i < mData.length; i++){
						nameArr.push(" " + mData[i].item.name + ": " + mData[i].quantity);
					}
					return nameArr;
				}
				
				},
				{"mData" : "id",
				"mRender" : function(mData, type, row) {
					return '<a class="btn btn-primary" href="/admin/editOrderById/'+mData+'" role="button">Edit</button>'
				}}
				]
		})
	});
</script>

</html>