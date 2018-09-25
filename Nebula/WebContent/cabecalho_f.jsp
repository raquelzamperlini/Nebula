<!--
/*
 * @author Raquel Zamperlini
 * 
 */
 -->
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>CRUD</title>
	</head>
	<body>
		<jsp:include page="loginOk.jsp"></jsp:include> <br /> <br />
		<a href="home.jsp">Início</a> <br /> <br />
		<a href="Crud.jsp">Cadastro</a> <br /> <br />
		<a href="pesquisar.jsp">Pesquisar</a> <br /> <br />
		<a href="UsuarioServletCTRL?acao=listar">Lista de Usuários</a> <br />
	</body>
</html>