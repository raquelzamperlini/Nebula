<%@ page import="br.com.nebula.model.Usuario" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
		
		<title>Nebula</title>
	</head>
	
	<body>
		<jsp:include page="cabecalho_f.jsp"></jsp:include>
		
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
		<br />
		
		<!-- Bootstrap core JavaScript -->
    	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	</body>
</html>