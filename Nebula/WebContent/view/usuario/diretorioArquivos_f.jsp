<%@ page import="br.com.nebula.model.Usuario"%>
<%@ page import="br.com.nebula.controller.DiretorioCTRL"%>
<%@ page import="com.amazonaws.services.s3.model.S3ObjectSummary"%>
<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

<script>
$( document ).ready(function() {
	document.getElementById("alarms").value = "Aguarde...";
	document.getElementById("bot").click();
	$(document.getElementById("alarms")).hide();
});
$(document).on("click", "#bot", function() {
		var params = {
				"action": "listar", 
	    		"caminho": document.getElementById("path").value,
	    		"usuario": document.getElementById("usuario").value
	    		};
		$(document.getElementById("alarms")).show();
		$.post("/Nebula/view/usuario/DiretorioCRUD", 
	    		$.param(params), 
	    		function(responseJson) {
	    			//alert(JSON.stringify(responseJson));
			        var table = document.getElementById("dir");
			        var id = 1;
			        table.innerHTML = '';
			        var header = $("<tr bgcolor='eaeaea'>").appendTo(table);
			        
			        //cria linhas e campos da visualização para cada objeto retornado do servidor
			        $.each(JSON.parse(JSON.stringify(responseJson)), function(index, item) { 
			        	//cria linha 
			        	var row = $("<tr>").appendTo(table);
			        	row.id = "row" + id.toString();
			        	
			        	//cria campo com nome do arquivo/diretório
			        	row.append($("<td>").text(item.key))
			        	
			        	if(item.isDirectory){
			        		//se for diretório, cria um botão "Abrir"
			        		var button = document.createElement("input");
			        		button.id = "but" + id.toString();
			        		button.className = "dirs";
			        		button.type = "button";
			        		button.value = "Abrir";
			        		button.dataset.dir = item.downloadLink.slice(0,-1);
			        		row.append($("<td>").append(button));
			        	}else{
			        		//se for arquivo, cria link de download
			        		row.append($("<td>").html('<a href="'+ item.downloadLink + '">Download</a>'));
			        		
			        		//cria player simples de reprodução
			        		var audio = document.createElement("audio");
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
			    }).fail(function(){
			        console.log("error");
			        $(document.getElementById("alarms")).hide();
			        });
		
	});
$(document).on("click", "#upload", function() {  
	
	
	var fdata = new FormData();
	document.getElementById("alarms").value = "Aguarde...";
	$(document.getElementById("alarms")).show();
	fdata.append("action","upload");
	fdata.append("usuario",document.getElementById("usuario").value);
	fdata.append("caminho",document.getElementById("path").value);
	
	if($("#file")[0].files.length>0){
		fdata.append("file",$("#file")[0].files[0])
		$.ajax({
	        type: 'POST',
	        url: '/Nebula/view/usuario/DiretorioCRUD',
	        data:fdata,
	        contentType: false,
	        processData: false, 
	        success: function(response)
	        {
	            alert("Sucesso!");
	            document.getElementById("bot").click();
	            $(document.getElementById("alarms")).hide();
	        }
	    })
	}else{
		alert("Não há arquivos a enviar!");
	}	
	$(document.getElementById("alarms")).hide();
});
$(document).on("click", ".dirs", function() {
	document.getElementById("path").value = this.dataset.dir;
	document.getElementById("bot").click();
});
$(document).on("click", ".dels", function() {
	var params = {
			"action": "excluir",
    		"caminho": document.getElementById("path").value,
    		"chave": this.dataset.key
    		};
	$(document.getElementById("alarms")).show();
	$.post("/Nebula/view/usuario/DiretorioCRUD", 
    		$.param(params), 
    		function(responseJson) {
			document.getElementById("alarms").value = "Aguarde...";
			$(document.getElementById("alarms")).hide();
			document.getElementById("bot").click();
		    }).fail(function(){
		        console.log("error");
		        $(document.getElementById("alarms")).hide();
		        });
});
</script>

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

	<br/>
	<br/>

	<form id="upload_form" action="DiretorioCRUD" method="post"
		enctype="multipart/form-data">
		
		<label for="profile_pic">Escolha um arquivo para upload: </label> 
		<input type="file" id="file" name="file" accept=".mp3"> <br /> <br />
		<input type="hidden" id="pathUp" name="pathUp" />
		<input type="hidden" id="usuario" name="usuario" value="${username}" /> 
		<input type="button" id="upload" name="action" value="upload" />
		<input type="text" id="alarms" value="" />
		
	</form>

	<br />
	<br />

	<input type="text" id="path" value="${username}" style="display: none;"/>
	<button id="bot" style="display: none;">Carregar diretório</button>

	<form id="diretorio_form" name="diretorio_form" action="diretorioAction_f.jsp"
		method="post" enctype="multipart/form-data">
		
		<input type="hidden" id="action" name="action" />		
		<input type="submit" id="go" name="go" style="visibility:hidden;" />
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
</html>