<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
        <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>

    <body>
        <br>
        <div class="container">
            <form method="POST" action="/editUser" class="form-signin">
                <div class="container">
                    <h2 class="form-heading">Edit User</h2>

                    <hr>

                     <input type="text" class="form-control"
                    placeholder="Enter Name" name="username" id="username" required>

                     <br><input
                    type="password" class="form-control" placeholder="Enter Password" name="pwd" id="pwd"
                    required> <br>

                     <hr>
                    <button type="submit" class="btn btn-md btn-primary">Edit User</button>
                </div>
            </form>
        </div>
        <br>
        <br>
    </body>
</html>