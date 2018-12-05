<%@ page import="br.com.nebula.model.Usuario" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head >
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>Cadastro</title>
	</head>
	
	<body>
		<jsp:include page="/view/usuario/cabecalhoUSUARIO_f.jsp"></jsp:include> <br />
		
		<%
			
			Usuario usuario = (Usuario)request.getAttribute("usuario");
			
		%>
		
		<form id="crud_form" action="UsuarioCRUD" method="post" >
			<div id="corpo">
				<div id="cadastro">
					<div id="title">
						<h1>Cadastro de Usuários</h1> <br />
						<!-- <h3 class="description">Cadastre um novo usuário:</h3> -->
					</div>
					
					<div class="forms">
						<label>ID: </label>
						<input type="text" id="crud_id" name="crud_id" style="width:300px" maxlength="38"
							value="<%=usuario.getUs_id() %>" readonly />
						
						<!-- <button id="crud_pesquisar" name="crud_pesquisar" Height="32px" OnClick="Pesquisar">Pesquisar</button> -->
						
						<br/>
							
						<label>Nome: </label>
						<input type="text" id="crud_nome" name="crud_nome" style="width:300px" maxlength="100"
						 placeholder="Entre com o nome completo do usuário"
							value="<%=usuario.getUs_nome() %>" />
						 <!-- pattern="[a-z,A-Z, ]" -->
						
						<br/>
						
						<label>E-mail: </label>
						<input type="text" id="crud_email" name="crud_email" style="width:300px" maxlength="100"
						 placeholder="xxxxx@xxxxx.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
							value="<%=usuario.getUs_email() %>"/>
						
						<br/>
						
						<label>CPF: </label>
						<input type="text" id="crud_cpf" name="crud_cpf" style="width:300px" maxlength="11"
						 placeholder="Somente números" pattern="[0-9]+$"
							value="<%=usuario.getUs_cpf() %>" />
						
						<br/>
						
						<label>Data de Nascimento: </label>
						<input type="date" id="crud_nascimento" name="crud_nascimento" required="required"
						 maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1901-01-01"
						 	value="<%=usuario.getUs_nascimento() %>" />

						
						<br/>
						
						<label>Nome de Usuário: </label>
						<input id="crud_username" name="crud_username" style="width:250px" maxlength="50"
						 pattern="[a-z\s]+$"
						 	value="<%=usuario.getUs_username() %>" />
						
						<br/>
						
						<label>Senha: </label>
						<input type="password" id="crud_senha" name="crud_senha" style="width:300px"
						 maxlength="14" placeholder="Senha entre 6 e 14 caracteres"
						 	 />
						
						<br />
						<br />
						
						 
						<br/>
					</div>
					
					<br />
					
					<input type="submit" id="crud_salvar" name="crud_salvar" value="Salvar" />
					<!--
					<input type="submit" id="crud_excluir" name="crud_excluir" value="Excluir" />
					<input type="submit" id="crud_alterar" name="crud_alterar" value="Alterar" />
					<input type="submit" id="crud_limpar" name="crud_limpar" value="Limpar" />
					 -->
				</div>
			</div>
		</form>
		
		<br />
		<br />
		
		<a href="<%=request.getContextPath()%>/view/usuario/home_f.jsp">Voltar</a>
	</body>
</html>