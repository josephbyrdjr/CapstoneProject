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
            <form method="POST" action="/admin/editItem/${item.id}" >
                <div class="container">
                    <h2 class="form-heading">Edit Item</h2>

                    <hr>
					
					<h3>Item Info</h3>
                    <b>Price</b><input type="text" class="form-control"
                    value="${item.price}" name="price" id="price" required> <br>

                    <b>Name</b><input
                    type="text" class="form-control" value="${item.name}" name="name" id="name"
                    required> <br>
                    
                    <b>Picture</b><input
                    type="text" class="form-control" value="${item.thumbnail}" name="thumbnail" id="thumbnail"
                    required> <br>
                    
                    <b>Categories</b><input
                    type="text" class="form-control" value="${item.category}" name="category" id="category">
                    <br>
                    
                    <b>Description</b><input
                    type="text" class="form-control" value="${item.description}"  name="description" id="description">
                    
                    
                    

                     <hr>
                    <button type="submit" class="btn btn-md btn-primary">Edit Item</button>
                </div>
            </form>
        </div>
        <br>
        <br>
    </body>
</html>