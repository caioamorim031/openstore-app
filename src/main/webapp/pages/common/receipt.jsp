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
				<th colspan="3">Receipt</th>
			</tr>
			
			<tr>
				<td>Name</td>
				<td>Price</td>
				<td>Qty</td>
			</tr>
			
				<s:iterator value="products" status="key">
					<tr>
						<td><s:property value="name"/></td>
						<td>$<s:property value="#action.getText('{0,number,#,##0.00}', {selectedProducts[%{#key.index}].PriceTaxes})"/></td>
						<td><s:textfield id="qty_%{productId}" class="campo-escondido" name="selectedProducts[%{#key.index}].quantity" type="number" theme="simple" min="1" max="99" size="2"></s:textfield></td>
						
					</tr>
				</s:iterator>
		</table>
		<h2>Sales Taxes: <s:property value="order.totalTaxes"/></h2>

	</body>
</html>