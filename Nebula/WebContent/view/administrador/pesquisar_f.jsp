<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>Pesquisar</title>
	</head>
	
	<body>
		<jsp:include page="/view/administrador/cabecalhoADM_f.jsp"></jsp:include> <br />
		
		<form id="crud_form" action="Pesquisar" method="post" style="width:300px" >
			<input type="text" id="parametroBuscaUsuario" name="parametroBuscaUsuario"> 
			
			<input type="submit" id="pesquisar" name="pesquisar" value="Pesquisar"> <br/>
		</form>
	</body>
</html>