
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!-- Commenting -->
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Home Improvement Store</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/master.css" rel="stylesheet">
<!-- <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
 -->
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/images/favicon.ico" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>


	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="col-md-12 clear-area">
					<img class="image-responsive" src="images/logo.png">
				</div>
			</div>
			<div class="col-md-9">
				<div class="col-md-12 clear-area">
					<h1>Home Improvement Store</h1>
					<h3>Product Management System</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="col-md-12 clear-area">
					<form action="getInventory.do" method="GET">
						<input class="btn btn-primary btn-sm" type="submit"
							value="List Inventory">
					</form>

					<form action="addProduct.do" method="POST">
						<input class="btn btn-primary btn-sm" type="submit"
							value="Add Product">
					</form>
				</div>


			</div>
			<div class="col-md-9">
				<div class="col-md-12 clear-area">
					<table class="table table-bordered">
						<tr>
							<th>Product ID</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Description</th>
						</tr>
						<tr>
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.price}</td>
							<td>${product.description}</td>
						</tr>
					</table>
					<c:if test="${! empty response}">
						<b>${response}</b>
						<br>
					</c:if>
					<form class="horizontal" action="deleteProduct.do" method="POST">
						<button class="btn btn-primary btn-sm" type="submit" name="id"
							value="${product.id}">Delete</button>

					</form>

					<form class="horizontal" action="editProduct.do" method="POST">
						<button class="btn btn-primary btn-sm" type="submit" name="id"
							value="${product.id}">Edit</button>

					</form>
				</div>
			</div>
		</div>
	</div>



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script src="js/bootstrap.min.js"></script>
</body>

</html>


