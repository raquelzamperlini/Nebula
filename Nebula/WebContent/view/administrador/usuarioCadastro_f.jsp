<%@ page import="br.com.nebula.model.Usuario" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head >
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Vinícius Ernani">
		
		<title>Cadastro</title>
	</head>
	
	<body>
		<jsp:include page="cabecalhoADM_f.jsp"></jsp:include> <br />
		
		<div class="container w-50 p-3">
			<br />
			<h1 class="text-center" >Cadastrar Usuário</h1>
			<br />
			
			<form action="CadastrarUsuario" method="post" >
				<div class="form-group row">
					<label for="inputCpf">CPF</label>
					<input type="number" class="form-control" id ="inputCpf" name="inputCpf"
					 maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" placeholder="XXX.XXX.XXX-XX">
				</div>
				
				<div class="form-group row">
					<label for="inputNome">Nome</label>
					<input type="text" class="form-control" id ="inputNome" name="inputNome" placeholder="Nome">
				</div>
				
				<div class="form-group row">
					<label for="inputNascimento">Data de Nascimento</label>
					<input type="date" class="form-control" id ="inputNascimento" name="inputNascimento"
					 maxlength="10" OnKeyPress="formatar('##/##/####', this)" placeholder="01/01/1901">
				</div>
				
				<div class="form-group row">
					<label for="inputUsername">Nome de Usuário</label>
					<input type="text" class="form-control" id ="inputUsername" name="inputUsername"
					 placeholder="Nome de Usuário">
				</div>
				
				<div class="form-group row">
					<label for="inputEmail">Email</label>
					<input type="email" class="form-control" id ="inputEmail" name="inputEmail" placeholder="Email">
				</div>
				
				<div class="form-group row">
					<label for="inputSenha">Senha</label>
					<input type="password" class="form-control" id ="inputSenha" name="inputSenha"
					 placeholder="Senha" aria-describedby="inputSenhaHelp" disabled>
					<small id="inputSenhaHelp" class="form-text text-muted">A senha será gerada automaticamente
						e enviada para o e-mail cadastrado. Regras de segurança, viu?! =)</small>
				</div>
				
				<fieldset class="form-group">
					<div class="row">
						<legend>Permissão</legend>
						
						<div class="col-sm-10">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="permissao" id="permissao" value="administrador" checked>
								<label class="form-check-label" for="administrador"> Administrador </label>
							</div>
							
							<div class="form-check">
								<input class="form-check-input" type="radio" name="permissao" id="permissao" value="usuario">
								<label class="form-check-label" for="usuario"> Usuário </label>
							</div>
							
							<div class="form-check disabled">
								<input class="form-check-input" type="radio" name="permissao" id="permissao"
								 value="administradorusuario" disabled>
								<label class="form-check-label" for="administradorusuario"> Administrador e Usuário </label>
							</div>
						</div>
					</div>
				</fieldset>
				
				<div class="form-group row align-self-center mr-3">
					<button type="button" name="voltar" id="voltar" class="btn btn-secondary align-self-center mr-3" 
					 OnClick="location.href = 'home_f.jsp';"> Cancelar </button>
					<button type="submit" class="btn btn-primary align-self-center mr-3">Cadastrar</button>
				</div>
			</form>
		</div>
		
		<br />
		<br />
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
