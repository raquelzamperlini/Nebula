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
			out.println("Seu diretório, " + autenticado.getUs_nome() + ".");
		} else {
			response.sendRedirect(request.getContextPath() + "/view/login/loginErro.jsp");
		}
	%>

	<br />
	<br />

	<form id="upload_form" action="DiretorioCRUD" method="post"
		enctype="multipart/form-data">

		<label for="profile_pic">Escolha um arquivo para upload: </label> 
		<input type="file" id="file" name="file" accept=".mp3" multiple> <br /> <br />
		<input type="hidden" id="pathUp" name="pathUp" /> 
		<input type="hidden" id="usuario" name="usuario" value="${username}" /> 
		<input type="button" id="upload" name="action" value="upload" /> 
		<input type="text" id="alarms" value="" size="50" disabled/>

	</form>

	<br />

	<input type="text" id="path" value="${username}" style="display: none;" />
	<button id="bot" style="display: none;">Carregar diretório</button>
	<input type="text" id="folderName" value="Nova Pasta" /> 
	<button id="folder">Criar pasta</button>
	<br />
	<br />
	
	<audio id="player" controls="controls" ></audio>
	
	<ul id="playlist" style="display: none;"></ul>

	<form id="diretorio_form" name="diretorio_form"
		action="diretorioAction_f.jsp" method="post"
		enctype="multipart/form-data">

		<input type="hidden" id="action" name="action" /> 
		<input type="submit" id="go" name="go" style="visibility: hidden;" />
		<table id="dir" border="1">
		</table>
		<script>
			function setAction(action, file) {
				document.forms["diretorio_form"].elements["action"].value = action;
				document.forms["diretorio_form"].elements["file"].value = file;
				document.forms["diretorio_form"].elements["go"].click();
			}
		</script>
	</form>

	<br />
</body>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="diretorio.js"></script>
</html>
