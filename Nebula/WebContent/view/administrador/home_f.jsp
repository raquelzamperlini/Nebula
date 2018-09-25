<%@ page import="br.com.nebula.model.Usuario" %>

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
		<h1>Nebula</h1>
		
		<%
			if ((session.getAttribute("autenticado")) != null)
			{
				Usuario autenticado = (Usuario)session.getAttribute("autenticado");
				out.println("Bem-vindo, " + autenticado.getUs_nome() + "! =)");
			}
			else
			{
				response.sendRedirect(request.getContextPath() + "/view/login/loginErro.jsp");
			}
			
		%>
		
		<br />
		<br />
		
		<jsp:include page="<%=request.getContextPath()%>/view/administrador/cabecalho_f.jsp"></jsp:include>
		
		<br />
	</body>
</html>