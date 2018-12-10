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
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
	
	<title>Nebula</title>
</head>

<body>
	<jsp:include page="cabecalhoUSUARIO_f.jsp"></jsp:include>
		
	<br/>
	<br/>

	<div class="container w-75">
		<%
			if ((session.getAttribute("autenticado")) != null) {
				Usuario autenticado = (Usuario) session.getAttribute("autenticado");
				out.println("Seu diretório, " + autenticado.getUs_nome() + ".");
			} else {
				response.sendRedirect(request.getContextPath() + "/view/login/loginErro.jsp");
			}
		%>
	</div>

	<div class="container w-75">
		<br />
		<form id="upload_form" action="DiretorioCRUD" method="post"
			enctype="multipart/form-data">

			<label for="profile_pic">Escolha um arquivo para upload: </label> <br/>
			<input type="file" id="file" name="file" accept=".mp3" multiple class="btn">
			<input type="hidden" id="pathUp" name="pathUp" /> 
			<input type="hidden" id="usuario" name="usuario" value="${username}" /> 
			<input type="button" id="upload" name="action" value="upload" class="btn btn-primary" /> 
			<input type="text" id="alarms" value="" size="50" disabled/>

		</form>
	
		<br />
	
		<input type="text" id="path" value="${username}" style="display: none;" />
		<button id="bot" style="display: none;">Carregar diretório</button> <br/>
		<input type="text" id="folderName" value="Nome da Nova Pasta" /> 
		<button id="folder" class="btn">Criar pasta</button>
		
		<br/>
		<br/>
		<audio id="player" controls="controls" ></audio> <br/><br/>
		<button id="refresh" class="btn" style="margin-top:25px; margin-left:80%;" >Recarregar</button>
		<ul id="playlist" style="display: none;"></ul>
	
		<form id="diretorio_form" name="diretorio_form"
			action="diretorioAction_f.jsp" method="post"
			enctype="multipart/form-data">
	
			<input type="hidden" id="action" name="action" /> 
			<input type="submit" id="go" name="go" style="visibility: hidden;" />
			<table id="dir" class="table"></table>
	  
			<script>
				function setAction(action, file) {
					document.forms["diretorio_form"].elements["action"].value = action;
					document.forms["diretorio_form"].elements["file"].value = file;
					document.forms["diretorio_form"].elements["go"].click();
				}
			</script>
		</form>
	</div>

	<br />
	<!-- Bootstrap core JavaScript -->
	<script src="/resources/js/bootstrap.min.js"></script>
</body>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="diretorio.js"></script>
</html>
