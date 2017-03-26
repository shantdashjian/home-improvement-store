
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
		<jsp:include page="logoandnavigation.jsp" />
		<div class="col-md-9">
			<div class="col-md-12 clear-area">
				<div class="form_main">
					<h3 class="heading">
						<strong>Add a New Product </strong><span></span>
					</h3>
					<div class="form">
						<form action="createProduct.do" method="POST">
							<label for="name">Enter product name: </label>
							<input type="text" name="name"  size="40"> <br>
							<label for="price">Enter price: </label><input
								type="number" name="price" value="1.00" step="0.01" min="1.00"><br>
<!-- 								enter category_id (as drop down list)
 -->						<label for="quantity">Enter quantity: </label> 
 							<input type="number" name="quantity" value="1" min="1"/><br>
 							<label for="categoryId">Select Category: </label>
							<select name="categoryId">
								<c:forEach var="category" items="${categories}">
									<option value="${category.id}">${category.name}</option>
								</c:forEach>
							</select><br>
 							<label for="description">Enter description: </label>
							<textarea name="description" type="text" class="txt_3"></textarea><br>
							<input class="btn btn-primary btn-md" type="submit" value="Add Product to the System">
						</form>
					</div>
				</div>
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


