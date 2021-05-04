<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Open Store</title>
		<link href="webjars/bootstrap/5.0.0-beta3/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<script src="webjars/bootstrap/5.0.0-beta3/js/bootstrap.min.js"></script>
		
		<nav class="navbar navbar-dark bg-dark">
		  <div class="container-fluid">
		    <span class="navbar-brand mb-0 h1">Open Store</span>
		  </div>
		</nav>
		
		<table>
			<tr>
				<th colspan="3">Products</th>
			</tr>
			
			<tr>
				<td>Name</td>
				<td>Price</td>
				<td>Qty</td>
			</tr>
			<s:iterator value="products">
				<tr>
				<td><s:property value="name"/></td>
				<td><s:property value="price"/></td>
				<td></td>
			</tr>
			</s:iterator>
			<tr>
				<td>BOOK</td>
				<td>$12.49</td>
				<td></td>
			</tr>
			<tr>
				<td>MUSIC CD</td>
				<td>$14.99</td>
				<td></td>
			</tr>
			<tr>
				<td>CHOCOLATE BAR</td>
				<td>$0.85</td>
				<td></td>
			</tr>
			<tr>
				<td>IMPORTED BOX OF CHOCOLATES</td>
				<td>$10.00</td>
				<td></td>
			</tr>
			<tr>
				<td>IMPORTED BOTTLE OF PERFUME</td>
				<td>$11.25</td>
				<td></td>
			</tr>
			<tr>
				<td>IMPORTED BOTTLE OF PERFUME</td>
				<td>$47.50</td>
				<td></td>
			</tr>
			<tr>
				<td>IMPORTED BOTTLE OF PERFUME</td>
				<td>$27.99</td>
				<td></td>
			</tr>
			<tr>
				<td>BOTTLE OF PERFUME</td>
				<td>$18.99</td>
				<td></td>
			</tr>
			<tr>
				<td>PACKET OF HEADACHE PILLS</td>
				<td>$9.25</td>
				<td></td>
			</tr>
			
			
		
		
		</table>
		
		<h2><s:property value="product.name"/></h2>

	</body>
</html>