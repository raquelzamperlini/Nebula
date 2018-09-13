<!--
/*
 * @author Raquel Zamperlini
 * 
 */
 -->

<%@ page import="br.com.nebula.model.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
				response.sendRedirect("loginErro.jsp");
			}
			
		%>
		
		<br />
		<br />
		
		<jsp:include page="cabecalho.jsp"></jsp:include> <br />
		
	</body>
</html>