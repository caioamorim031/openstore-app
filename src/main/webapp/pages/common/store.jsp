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
	
		<script type="text/javascript">
	
			function marcarSelecionado(pCampo){
				var campoHidden = document.getElementById("productId_" + pCampo.value);
				var campoQuantidade = document.getElementById("qty_" + pCampo.value);

				if(pCampo.checked){
					campoHidden.value = pCampo.value;
					campoQuantidade.value = 1;
					campoQuantidade.classList.remove("campo-escondido");
				} else {
					campoHidden.value = "";
					campoQuantidade.value = "";
					campoQuantidade.classList.add("campo-escondido");
				}
			}

			function validarEntrada(){
				var checkboxes = document.getElementsByName("checkboxes");
				var quantidadeCheck = 0;
				
				for (var count = 0; count < checkboxes.length; count++) {
					if(checkboxes[count].checked){
						var campoQuantidade = document.getElementById("qty_" + checkboxes[count].value);
						quantidadeCheck++;

						if(!validarCampoQuantidade()){
							return false;
						}
					}
				}

				if(quantidadeCheck == 0){
					alert("Escolha algum produto");
					return false;
				}

				
			}

			function validarCampoQuantidade(pCampo){

				if(pCampo.match(/^\d{1,2}$/) == null){
					alert("Campo inválido");
					pCampo.focus;
					return false;
				} 

			}
	
		</script>
	
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
				<td></td>
				<td>Name</td>
				<td>Price</td>
				<td>Qty</td>
			</tr>
			
			<s:form action="send" theme="simple" onsubmit="return validarEntrada()">
				<s:iterator value="products" status="key">
					<tr>
						<td>
							<s:checkbox name="checkboxes" id="productId" fieldValue="%{productId}" theme="simple" onchange="marcarSelecionado(this)" ></s:checkbox>
							<s:hidden id="productId_%{productId}" name="selectedProducts[%{#key.index}].productId" theme="simple"></s:hidden>
						</td>
						<td><s:property value="name"/></td>
						<td>$<s:property value="#action.getText('{0,number,#,##0.00}', {price})"/></td>
						<td><s:textfield id="qty_%{productId}" class="campo-escondido" name="selectedProducts[%{#key.index}].quantity" type="number" theme="simple" min="1" max="99" size="2"></s:textfield></td>
						
					</tr>
				</s:iterator>
				<div>
					<s:submit value="Submit" theme="simple"></s:submit>
				</div>
			</s:form>
		</table>

	</body>
</html>