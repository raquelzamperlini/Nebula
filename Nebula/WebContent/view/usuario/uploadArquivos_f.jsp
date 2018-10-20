<%@ page import="br.com.nebula.model.Usuario" %>
<%@ page import="br.com.nebula.controller.DiretorioCTRL" %>
<%@ page import="com.amazonaws.services.s3.model.S3ObjectSummary" %>
<%@ page import="java.util.List" %>

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
			if ((session.getAttribute("autenticado")) != null)
			{
				Usuario autenticado = (Usuario)session.getAttribute("autenticado");
				out.println("Upload de arquivos, " + autenticado.getUs_nome() + ".");
// 				Integer id = autenticado.getUs_id();
// 				String username = autenticado.getUs_username();
				
// 				session.setAttribute("userid", String.valueOf(id));
// 				session.setAttribute("username", username);
			}
			else
			{
				response.sendRedirect(request.getContextPath() + "/view/login/loginErro.jsp");
			}
			
		%>
		
		<br />
		<br />
				
		<form id="upload_form" action="DiretorioCRUD" method="post" enctype="multipart/form-data" >
			<label for="profile_pic">Escolha um arquivo para upload: </label>
		    <input type="file" id="file" name="file"
		          accept=".mp3"> <br/>
			<input type="hidden" id="usuario" name="usuario" value="${username}" />
			<input type="submit" id="diretorio" name="diretorio" value="Upload" />
		</form>
		
		<br />
		<br />
		
		<br />
	</body>
</html>