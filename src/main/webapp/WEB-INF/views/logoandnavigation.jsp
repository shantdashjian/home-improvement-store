
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
			<form action="displayProduct.do" method="GET">
				<input class= "centered" type="number" name="id"  min="1"> 
				<input class="btn btn-primary btn-sm" type="submit"
					value="Search Product By ID">
			</form><br>
			<form action="getInventory.do" method="GET">
				<input class="btn btn-primary btn-sm" type="submit"
					value="List Inventory">
			</form>

			<form action="addProduct.do" method="GET">
				<input class="btn btn-primary btn-sm" type="submit"
					value="Add Product">
			</form>
		</div>


	</div>