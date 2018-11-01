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
			// 				Integer id = autenticado.getUs_id();
			// 				String username = autenticado.getUs_username();

			// 				session.setAttribute("userid", String.valueOf(id));
			// 				session.setAttribute("username", username);
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

	<%
		DiretorioCTRL dir = new DiretorioCTRL();
		List<S3ObjectSummary> objects = dir.listarArquivos((String) session.getAttribute("username"));
	%>

	<form id="diretorio_form" name="diretorio_form" action="diretorioAction_f.jsp"
		method="post" enctype="multipart/form-data">
		<table border="1">
			<tr bgcolor="eaeaea">
				<th>Arquivos</th>
				<th>Link de Download</th>
			</tr>

			<%
				for (S3ObjectSummary os : objects) {
					if (os.getKey().substring(os.getKey().lastIndexOf("/") + 1).trim().isEmpty()) {
						continue;
					}
			%>

			<tr>
				<th><%=os.getKey()%></th>
				<th><a href="<%=dir.downloadLink(os.getKey()) %>" download="download.mp3">Download</a></th>
				<!--  <th><input type="button" id="copiar" name="copiar"
					value="Copiar" onclick="setAction('copiar', '<%=os.getKey()%>')"></th>
				<th><input type="button" id="mover" name="mover" 
					value="Mover" onclick="setAction('mover', '<%=os.getKey()%>')"></th>
				<th><input type="button" id="renomear" name="renomear"
					value="Renomear" onclick="setAction('renomear', '<%=os.getKey()%>')"></th>
				<th><input type="button" id="excluir" name="excluir"
					value="Excluir" onclick="setAction('excluir', '<%=os.getKey()%>')"></th>-->
			</tr>

			<%
				}
			%>

		</table>
		<input type="hidden" id="action" name="action" /> 
		<input type="hidden" id="file" name="file" />
		<input type="submit" id="go" name="go" style="visibility:hidden;" />
		<script>
			function setAction(action, file) {
				//formName is the name of your form, submitType is the name of the submit button.
				document.forms["diretorio_form"].elements["action"].value = action;
				document.forms["diretorio_form"].elements["file"].value = file;
				document.forms["diretorio_form"].elements["go"].click();
			}
		</script>
	</form>

	<br />
</body>
</html>