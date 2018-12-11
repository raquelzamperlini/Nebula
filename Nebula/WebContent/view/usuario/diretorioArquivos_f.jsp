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
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="diretorio.js"></script>
<script type="text/javascript" src="tags.js"></script>
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
	
		<div class="modal hide" id="pleaseWaitDir" data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
				    <div class="modal-header">
				        <h3>Carregando diretório...</h3>
				    </div>
				    <div class="modal-body">
				        <div id="ajax_loader">
				            <img src="ajax-loader.gif" style="display: block; margin-left: auto; margin-right: auto;">
				        </div>
				    </div>
			    </div>
		    </div>
		</div>
		
		<div class="modal hide" id="pleaseWaitUp" data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
				    <div class="modal-header">
				        <h3>Carregando arquivos...</h3>
				    </div>
				    <div class="modal-body">
				        <div id="ajax_loader">
				            <img src="ajax-loader.gif" style="display: block; margin-left: auto; margin-right: auto;">
				        </div>
				    </div>
			    </div>
		    </div>
		</div>
		
		<div class="modal hide" id="pleaseWaitAlt" data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
				    <div class="modal-header">
				        <h3>Aplicando alterações...</h3>
				    </div>
				    <div class="modal-body">
				        <div id="ajax_loader">
				            <img src="ajax-loader.gif" style="display: block; margin-left: auto; margin-right: auto;">
				        </div>
				    </div>
			    </div>
		    </div>
		</div>
	
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
		<div style="text-align:center;width:100%;padding:auto;"><audio id="player" controls="controls" style="margin:auto;"></audio></div> <br/><br/>
		
		<ul id="playlist" style="display: none;"></ul>
		
		<div style="text-align:center;">
			<button id="refresh" class="btn" style="margin:auto;">Recarregar</button>
		</div>
		
		<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog modal-lg">
		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <h4 class="modal-title">Alterar música</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		      <div class="modal-body">
		        <label>Informações da música:</label>
				<br/>
				<label id="lbltrack" class="alt_tag" style="width:7%; float:left; padding:5px; text-align:center;" >Faixa:</label>
				<input type="text" id="track" class="alt_tag" style="width:5%; float:left;" />
				<label id="lbltitle" class="alt_tag" style="width:7%; float:left; padding:5px; text-align:center;" >Título:</label>
				<input type="text" id="title" class="alt_tag" style="width:43%; float:left;" />
				<label id="lblartist" class="alt_tag" style="width:8%; float:left; padding:5px; text-align:center;" >Artista:</label>
				<input type="text" id="artist" class="alt_tag" style="width:29%; float:left;" />
				<br/>
				<br/>
				<label id="lblalbum" class="alt_tag" style="width:8%; float:left; padding:5px; text-align:center;" >Álbum:</label>
				<input type="text" id="album" class="alt_tag" style="width:75%; float:left;" />
				<label id="lblyear" class="alt_tag" style="width:6%; float:left; padding:5px; text-align:center;" >Ano:</label>
				<input type="text" id="year" class="alt_tag" style="width:10%; float:left;" />
				<input type="hidden" id="key" />
				<input type="hidden" id="link" />
				<br/>
				<div style="margin-left:33%;width:50%;justify-content:space-between;">
					<div style="width:50%;float:left"><input type="button" id="btnalterar" class="btn" value="Alterar" /></div>
					
					<div style="width:50%;float:right"><input type="button" id="btnlimpar" class="btn" value="Limpar" /></div>								
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" id="btncancelar" class="btn btn-default" data-dismiss="modal">Cancelar</button>
		      </div>
		    </div>
		
		  </div>
		</div>
	
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
</body>


</html>
