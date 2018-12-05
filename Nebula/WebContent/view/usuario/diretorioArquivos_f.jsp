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

	<form id="diretorio_form" name="diretorio_form"
		action="diretorioAction_f.jsp" method="post"
		enctype="multipart/form-data">

		<input type="hidden" id="action" name="action" /> 
		<input type="submit" id="go" name="go" style="visibility: hidden;" />
		<table id="dir" border="1"> </table>
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

<script>
	$(document).ready(function() {
		$(document.getElementById("alarms")).hide();
		document.getElementById("bot").click();
	});
	
	$(document).on("click", "#folder", function(){
		var params = {
				"action" : "criar",
				"caminho" : document.getElementById("path").value,
				"chave" : document.getElementById("folderName").value
			};
			$(document.getElementById("alarms")).value = "Criando pasta...";
			if (document.getElementById("folderName").value.length == 0){
				alert("Insira um nome!");
				return;
			}
			$(document.getElementById("alarms")).value = "Criando pasta...";
			$(document.getElementById("alarms")).hide();
			$(document.getElementById("alarms")).value = "Criando pasta...";
			$(document.getElementById("alarms")).show();
			$(document.getElementById("alarms")).value = "Criando pasta...";
			$.post(
					"/Nebula/view/usuario/DiretorioCRUD",
					$.param(params),
					function(responseJson) {
						$(document.getElementById("alarms")).value = "Criando pasta...";
						$(document.getElementById("alarms")).hide();
						document.getElementById("bot").click();
					})
			.fail(
					function() {
						console.log("error");
						$(document.getElementById("alarms")).hide();
					});
	});
	
	$(document).on("click","#bot",function() {
		var params = {
			"action" : "listar",
			"caminho" : document.getElementById("path").value,
			"usuario" : document.getElementById("usuario").value
		};
		document.getElementById("alarms").value = "Aguarde, carregando diretório...";
		$(document.getElementById("alarms")).show();
		$.post("/Nebula/view/usuario/DiretorioCRUD",$.param(params),
			function(responseJson) {
				//alert(JSON.stringify(responseJson));
				var table = document.getElementById("dir");
				var id = 1;
				table.innerHTML = '';
				var header = $("<tr bgcolor='eaeaea'>").appendTo(table);
				
				//cria linhas e campos da visualização para cada objeto retornado do servidor
				$.each(JSON.parse(JSON.stringify(responseJson)),
						function(index,
						item) {
						//cria linha 
						var row = $("<tr>").appendTo(table);
						row.id = "row" + id.toString();

						//cria campo com nome do arquivo/diretório
						row.append($("<td>").text(item.key))

						if (item.isDirectory) {
							//se for diretório, cria um botão "Abrir"
							var button = document.createElement("input");
							button.id = "but" + id.toString();
							button.className = "dirs";
							button.type = "button";
							button.value = "Abrir";
							button.dataset.dir = item.downloadLink.slice(0,-1);
							row.append($("<td>").append(button));
						} else {
							//se for arquivo, cria link de download
							row.append($("<td>").html('<a href="'+ item.downloadLink + '">Download</a>'));

							//cria player simples de reprodução
							var audio = document
									.createElement("audio");
							audio.id = "audio" + id.toString();
							audio.src = item.downloadLink;
							audio.controls = 'controls';
							audio.preload = 'metadata';
							row.append($("<td>").append(audio));
						}

						//cria botão de excluir
						var del = document.createElement("input");
						del.id = "del" + id.toString();
						del.className = "dels";
						del.type = "button";
						del.value = "Excluir";
						del.dataset.key = item.key;
						row.append($("<td>").append(del));
						id = id + 1;
					});
				$(document.getElementById("alarms")).hide();
				//alert("OK response");
			})
		.fail(function() {
			console.log("error");
			$(document.getElementById("alarms")).hide();
		});
	});
	$(document).on("click", "#upload", function() {
		
		document.getElementById("alarms").value = "Enviando arquivos";
		$(document.getElementById("alarms")).show();
		var ind = 0;
		var res = 0;
		var musicas = document.getElementById("file");
		var total = musicas.files.length;

		if (total == 0){
			alert("Não há arquivos a enviar!");
			$(document.getElementById("alarms")).hide();
			return;
		}
		$(document.getElementById("alarms")).show();
		document.getElementById("alarms").value = "Enviando arquivos";
		for (ind = 0; ind < total; ind++) {
			document.getElementById("alarms").value = "Enviando arquivo " + ind + " de " + total + "...";
			$(document.getElementById("alarms")).show();
			var fdata = new FormData();
			fdata.append("action", "upload");
			fdata.append("usuario", document.getElementById("usuario").value);
			fdata.append("caminho", document.getElementById("path").value);	
			//fdata.append("file", $("#file")[ind].files[ind])
			//alert(ind);
			fdata.append("file", musicas.files[ind]);
			document.getElementById("alarms").value = "Enviando arquivo " + ind + " de " + total + "...";
			$(document.getElementById("alarms")).show();
			$.ajax({
				type : 'POST',
				url : '/Nebula/view/usuario/DiretorioCRUD',
				data : fdata,
				contentType : false,
				processData : false,
				success : function(response) {
					res = res + 1;
					alert("Arquivo " + res + " enviado!");
					document.getElementById("bot").click();
					if (res == ind){
						$(document.getElementById("alarms")).hide();
					}
				},
				async: false
			});
			document.getElementById("alarms").value = "Enviando arquivos...";
			$(document.getElementById("alarms")).show();
		}
		$(document.getElementById("alarms")).hide();
	});
	$(document).on("click", ".dirs", function() {
		document.getElementById("path").value = this.dataset.dir;
		document.getElementById("bot").click();
	});
	$(document).on("click",".dels",function() {
		var params = {
			"action" : "excluir",
			"caminho" : document.getElementById("path").value,
			"chave" : this.dataset.key
		};
		$(document.getElementById("alarms")).show();
		$.post(
				"/Nebula/view/usuario/DiretorioCRUD",
				$.param(params),
				function(responseJson) {
					document.getElementById("alarms").value = "Aguarde...";
					$(document.getElementById("alarms")).hide();
					document.getElementById("bot").click();
				})
		.fail(
				function() {
					console.log("error");
					$(document.getElementById("alarms")).hide();
				});
	});
</script>
</html>