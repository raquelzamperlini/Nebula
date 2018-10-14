<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>Nebula</title>
	</head>
	
	<body>
		<jsp:include page="/view/login/loginOk_f.jsp"></jsp:include> <br /> <br />
		
		<a href="<%=request.getContextPath()%>/view/administrador/home_f.jsp">Início</a> <br /> <br />
		<a href="<%=request.getContextPath()%>/view/administrador/usuarioCadastro_f.jsp">Cadastro</a> <br /> <br />
		<a href="<%=request.getContextPath()%>/view/administrador/pesquisar_f.jsp">Pesquisar</a> <br /> <br />
		
		<a href="usuarioLista_f.jsp">Lista de Usuários</a> <br />
	</body>
</html>