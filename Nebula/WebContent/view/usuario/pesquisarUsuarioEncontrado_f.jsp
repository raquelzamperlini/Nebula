<%@ page import="br.com.nebula.model.Usuario" %>
<%@ page import="br.com.nebula.controller.Datas" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>Minha Conta</title>
	</head>
	
	<body>
		<jsp:include page="/view/administrador/cabecalhoADM_f.jsp"></jsp:include> <br />
		
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuarioPesquisado");
			
			Datas datas = new Datas();
		%>
		
		<div class="container w-50 p-3">
		
			<form id="crud_form" action="Pesquisar" method="post" >
				<div class="form-group row">
					<label for="inputId">ID: </label>
					<input type="number" id="inputId" name="inputId" class="form-control" placeholder="ID"
						value="<%=usuario.getUs_id() %>" readonly />
				</div>
				
				<br/>
				
				<div class="form-group row">	
					<label for="inputNome">Nome: </label>
					<input type="text" id="inputNome" name="inputNome" class="form-control" placeholder="Nome do Usuário"
					 	value="<%=usuario.getUs_nome() %>" readonly/>
				</div>
				
				<br/>
				
				<div class="form-group row">
					<label for="inputEmail">E-mail: </label>
					<input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email"
					 	value="<%=usuario.getUs_email() %>" readonly />
				</div>
					
				<br/>
				
				<div class="form-group row">
					<label for="inputCpf">CPF: </label>
					<input type="text" id="inputCpf" name="inputCpf" class="form-control" placeholder="XXX.XXX.XXX-XX"
					 maxlength="14" onclick="formatar('###.###.###-##, this)"
					 	value="<%=usuario.getUs_cpf() %>" readonly />
				</div>
				
				<br/>
				
				<div class="form-group row">
					<label for="inputNascimento">Data de Nascimento: </label>
					<input type="text" id="inputNascimento" name="inputNascimento" required="required" class="form-control"
					 onclick="formatar('##/##/####', this)" placeholder="01/01/1901" maxlength="10" 
					 	value="<%=datas.localDateParaString(usuario.getUs_nascimento()) %>" readonly />
					<!-- maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1901-01-01" -->
				</div>
					
				<br/>
				
				<div class="form-group row">
					<label for="inputUsername">Nome de Usuário: </label>
					<input id="inputUsername" name="inputUsername" class="form-control"
						value="<%=usuario.getUs_username() %>" readonly />
				</div>
				
				<br/>
					
					<!-- 
					<label>Senha: </label>
					<input type="password" id="crud_senha" name="crud_senha" style="width:300px"
					 maxlength="14" placeholder="Senha entre 6 e 14 caracteres"
					 	value="<%=usuario.getUs_senha() %>" readonly /> 
					  -->
					
				<br />
				<br />
				
				<div class="form-group row">
					<label for="inputPermissao" id="ativo">Tipo de Permissão: </label> <br />
					<input type="text" id="inputPermissao" name="inputPermissao" class="form-control"
						value="<%=usuario.getUs_permissao() %>" readonly />
				</div>
				
				<br/>
			</form>
		</div>
	</body>
	
	<script>
		function formatar(mascara, documento){
		  var i = documento.value.length;
		  var saida = mascara.substring(0,1);
		  var texto = mascara.substring(i)
		  
		  if (texto.substring(0,1) != saida){
		            documento.value += texto.substring(0,1);
		  }
		  
		}
	</script>
</html>