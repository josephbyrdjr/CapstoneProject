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
        <title>Welcome to the Admin Page</title>
        <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>

    <body>
        <div style="top:0px; z-index:999;text-align:center">
        <h2 class="form-heading">Welcome, ${firstName}!</h2>
        </div>
		<div style="position:absolute;top:60px;right:15px; z-index:999" >
            <form method="POST" action="/logout">
                <button class="btn bt-sm btn-primary" type="submit">Log Out</button>
            </form>
        </div>
        <div>
            <form method="GET" action="/admin/allUsers">
                <button class="btn bt-sm btn-primary" type="submit">All Users</button>
            </form>
        </div><br>
        <div>
            <form method="GET" action="/admin/allOrders">
                <button class="btn bt-sm btn-primary" type="submit">All Orders</button>
            </form>
        </div><br>
        <div>
            <form method="GET" action="/admin/allItems">
                <button class="btn bt-sm btn-primary" type="submit">All Items</button>
            </form>
        </div><br>
        
        <div>
            <form method="GET" action="/addItem">
                <button class="btn bt-sm btn-primary" type="submit">Add Item</button>
            </form>
        </div>

        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>