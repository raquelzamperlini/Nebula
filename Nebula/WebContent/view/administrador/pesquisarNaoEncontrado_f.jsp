<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>Pesquisar - Usuário Não Encontrado!</title>
	</head>
	
	<body>
		<jsp:include page="/view/administrador/cabecalho_f.jsp"></jsp:include> <br />
		
		<form id="crud_form" action="Pesquisar" method="post" >
			<input type="text" id="crud_id" name="crud_id" style="width:300px" maxlength="38"> 
			
			<input type="submit" id="crud_pesquisar" name="crud_pesquisar" value="Pesquisar"> <br/>
			
			<h1>
			<%
				out.print("Usuário não encontrado!");
			%>
			</h1>
		</form>
	</body>
</html>