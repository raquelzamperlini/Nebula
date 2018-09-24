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
		<jsp:include page="loginOk_f.jsp"></jsp:include> <br /> <br />
		<a href="home_f.jsp">Início</a> <br /> <br />
		<a href="crud_f.jsp">Cadastro</a> <br /> <br />
		<a href="pesquisar_f.jsp">Pesquisar</a> <br /> <br />
		<a href="UsuarioServletCTRL?acao=listar">Lista de Usuários</a> <br />
	</body>
</html>