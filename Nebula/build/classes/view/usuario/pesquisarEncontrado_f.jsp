<%@ page import="br.com.nebula.model.Usuario" %>
<%@ page import="br.com.nebula.controller.Datas" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>Pesquisar</title>
	</head>
	
	<body>
		
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			
			Datas datas = new Datas();
		%>
		
		<form id="crud_form" action="UsuarioCRUD" method="post" >
			<div>
				<br/>
					
				<label>Nome: </label>
				<input type="text" id="crud_nome" name="crud_nome" style="width:300px" maxlength="100"
				 placeholder="Entre com o nome completo do usuário"
				 	value="<%=usuario.getUs_nome() %>" />
				
				<br/>
				
				<label>E-mail: </label>
				<input type="text" id="crud_email" name="crud_email" style="width:300px" maxlength="100"
				 placeholder="xxxxx@xxxxx.com"
				 	value="<%=usuario.getUs_email() %>"  />
				
				<br/>
				
				<label>CPF: </label>
				<input type="text" id="crud_cpf" name="crud_cpf" style="width:300px" maxlength="11"
				 placeholder="Somente números"
				 	value="<%=usuario.getUs_cpf() %>"  />
				
				<br/>
				
				<label>Data de Nascimento: </label>
				<input type="text" id="crud_nascimento" name="crud_nascimento" required="required"
				 	value="<%=datas.localDateParaString(usuario.getUs_nascimento()) %>"  />
				<!-- maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1901-01-01" -->
	
				
				<br/>
				
				<label>Nome de Usuário: </label>
				<input id="crud_username" name="crud_username" style="width:250px" maxlength="50"
					value="<%=usuario.getUs_username() %>"  />
				
				<br/>
				
				<input type="hidden" id="pass" name="pass" value="<%=usuario.getUs_id() %>"/>
				
				
				<label>Senha: </label>
				<input type="password" id="crud_senha" name="crud_senha" style="width:300px"
				 maxlength="14" placeholder="Senha entre 6 e 14 caracteres"
				 	 /> 
				 
				
				<br />
				<br />
				
				<br/>
				<input type="hidden" id="username" name="username" value="<%=usuario.getUs_username() %>" />
				<input type="submit" id="crud_salvar" name="crud_salvar" value="Salvar" />
			</div>
		</form>
	</body>
</html>