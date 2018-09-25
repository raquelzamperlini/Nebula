<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>CRUD</title>
	</head>
	
	<body>
		<jsp:include page="loginOk_f.jsp"></jsp:include> <br /> <br />
		<a href="home_f.jsp">Início</a> <br /> <br />
		<a href="crud_f.jsp">Cadastro</a> <br /> <br />
		<a href="pesquisar_f.jsp">Pesquisar</a> <br /> <br />
		<a href="UsuarioServletCTRL?acao=listar">Lista de Usuários</a> <br />
	</body>
</html>