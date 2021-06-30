<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Add New Item</title>
        <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>

    <body>
        <br>
        <div class="container">
            <form method="POST" action="/admin/addItem" >
                <div class="container">
                    <h2 class="form-heading">New Item</h2>

                    <hr>
					
					<h3>Item Info</h3>
                    <b>Price</b><input type="text" class="form-control"
                    placeholder="Enter Price" name="price" id="price" required> <br>

                    <b>Name</b><input
                    type="text" class="form-control" placeholder="Enter Name" name="name" id="name"
                    required> <br>
                    
                    <b>Picture</b><input
                    type="text" class="form-control" placeholder="Enter Thumbnail" name="thumbnail" id="thumbnail"
                    required> <br>
                    
                    <b>Categories</b><input
                    type="text" class="form-control" placeholder="Enter Categories" name="category" id="category">
                    <br>
                    
                    <b>Description</b><input
                    type="text" class="form-control" placeholder="Enter Description" name="description" id="description">
                    <br>
                    
                     <b>Inventory</b><input
                    type="text" class="form-control" placeholder="Enter Inventory" name="inventoryLeft" id="inventoryLeft">
                    <br>
                    

                     <hr>
                    <button type="submit" class="btn btn-md btn-primary">Add Item</button>
                </div>
            </form>
        </div>
        <br>
        <br>
    </body>
</html>