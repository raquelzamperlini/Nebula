<%@ page import="br.com.nebula.model.Usuario"%>
<%@ page import="br.com.nebula.controller.DiretorioCTRL"%>
<%@ page import="com.amazonaws.services.s3.model.S3ObjectSummary"%>
<%@ page import="java.util.List"%>

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
	<h1 id="nebula">Nebula</h1>

	<%
		if ((session.getAttribute("autenticado")) != null) {
			Usuario autenticado = (Usuario) session.getAttribute("autenticado");
			out.println("Escolha, " + autenticado.getUs_nome() + "!");
			out.println("");
			out.println(session.getAttribute("action"));
			Integer id = autenticado.getUs_id();
			String username = autenticado.getUs_username();

			session.setAttribute("userid", String.valueOf(id));
			session.setAttribute("username", username);
		} else {
			response.sendRedirect(request.getContextPath() + "/view/login/loginErro.jsp");
		}
	%>

	<br />
	<br />
	
	<form id="crud_diretorio" name="crud_diretorio" action="DiretorioCRUD" method="post">

		<input type="hidden" id="userid" name="userid" value="${userid}" /> 
		<input type="text" id="caminho" name="caminho" value="${file}" /> 
		<input type="submit" id="minha_conta" name="minha_conta" value="Minha Conta" />

	</form>

	<br />
	<br />
	
	<button id="diretorioArquivos" name="diretorioArquivos">
		<a href="diretorioArquivos_f.jsp">Voltar</a>
	</button>

	<br />
</body>
</html>