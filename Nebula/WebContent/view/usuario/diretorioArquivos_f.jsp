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
$(document).on("click", "#bot", function() {  
		var params = {
				"action": "listar", 
	    		"caminho": document.getElementById("path").value,
	    		"usuario": document.getElementById("usuario").value
	    		};
		$.post("/Nebula/view/usuario/DiretorioCRUD", 
	    		$.param(params), 
	    		function(responseJson) {
	    			alert(JSON.stringify(responseJson));
			        var table = document.getElementById("dir");
			        var id = 1;
			        table.innerHTML = '';
			        var header = $("<tr bgcolor='eaeaea'>").appendTo(table);
			        $("<th>").text("Arquivos").appendTo(header);
			        $("<th>").text("Link de Download").appendTo(header);
			        $.each(JSON.parse(JSON.stringify(responseJson)), function(index, item) { 
			        	var row = $("<tr>").appendTo(table);
			        	row.id = "row" + id.toString();
			        	row.append($("<td>").text(item.key))
			        	if(item.isDirectory){
			        		var button = document.createElement("input");
			        		button.id = "but" + id.toString();
			        		button.className = "dirs";
			        		button.type = "button";
			        		button.value = "Abrir";
			        		button.dataset.dir = item.downloadLink.slice(0,-1);
			        		row.append($("<td>").append(button));
			        	}else{
			        		row.append($("<td>").html('<a href="'+ item.downloadLink + '">Download</a>'));
			        	}
			        	id = id + 1;
			        });
			        alert("OK response");
			    }).fail(function(){
			        console.log("error");});
	});

$(document).on("click", ".dirs", function() {
	document.getElementById("path").value = this.dataset.dir;
	document.getElementById("bot").click();
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
		<input type="file" id="file" name="file" accept=".mp3"> <br /> 
		<input type="hidden" id="usuario" name="usuario" value="${username}" /> 
		<input type="submit" id="action" name="action" value="Upload" />
		
	</form>

	<br />
	<br />

	<input type="text" id="path" value="${username}" />
	<button id="bot" >Carregar diretório</button>

	<form id="diretorio_form" name="diretorio_form" action="diretorioAction_f.jsp"
		method="post" enctype="multipart/form-data">
		
		<input type="hidden" id="action" name="action" /> 
		<input type="hidden" id="file" name="file" />
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