<html>
<body>

	<h1>Spring Boot Web JSP Example</h1>
	<h2>Message: ${msg}</h2>


	<H3>Object Data: ${viewProduct}</H3>
	<br>
	<br>

	<table border="1" cellpadding="5">
		<caption>
			<h2>Product Details</h2>
		</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Band</th>
			<th>Madein</th>
			<th>Price</th>
		</tr>

		<tr>
			<th>${viewProduct.id }</th>
			<th>${viewProduct.name}</th>
			<th>${viewProduct.brand }</th>
			<th>${viewProduct.madein}</th>
			<th>${viewProduct.price}</th>
		</tr>
	</table>
</body>
</html>