<%@ page import="br.com.nebula.model.Usuario"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>Cadastro</title>
	</head>
	
	<body>
		<jsp:include page="cabecalhoLOGIN_f.jsp"></jsp:include>
		
		<div class="container w-50 p-3">
			<br />
			<h1 class="text-center" >Cadastre-se</h1>
			<br />
			
			<form action="Cadastrese" method="post" >
				<div class="form-group row">
					<label for="inputCpf">CPF</label>
					<input type="text" class="form-control" id ="inputCpf" name="inputCpf"
					 maxlength="14" OnKeyPress="Formatar('###.###.###-##', this)" placeholder="XXX.XXX.XXX-XX"
					 OnBlur="ValidarCpf(this)">
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
					<input type="text" class="form-control" id ="inputUsername" name="inputUsername" placeholder="Nome de Usuário">
				</div>
				
				<div class="form-group row">
					<label for="inputEmail">Email</label>
					<input type="email" class="form-control" id ="inputEmail" name="inputEmail" placeholder="Email">
				</div>
				
				<div class="form-group row">
					<label for="inputSenha">Senha</label>
					<input type="password" class="form-control" id ="inputSenha" name="inputSenha"
					 placeholder="Senha" aria-describedby="inputSenhaHelp" >
					<small id="inputSenhaHelp" class="form-text text-muted">Deixe sua senha segura; utilize letras maiúsculas,
					 minúsculas, números e caracteres especiais. Apenas uma dica =)</small>
				</div>
				
				<div class="form-group row align-self-center mr-3">
					<button type="button" name="voltar" id="voltar" class="btn btn-secondary align-self-center mr-3" 
					 onclick="location.href = 'login.jsp';"> Cancelar </button>
					<button type="submit" name="cadastrar" id="cadastrar" 
					 class="btn btn-primary align-self-center mr-3" >Cadastrar</button>
				</div>
			</form>
		</div>
	</body>
	
	<script>
		function Formatar(mascara, objeto)
		{
			var i = objeto.value.length;
			var saida = mascara.substring(0,1);
			var texto = mascara.substring(i)
			
			if (texto.substring(0,1) != saida){
				objeto.value += texto.substring(0,1);
			}
		}
		
		function Validar()
		{
			//CPF
			if (inputCpf.value.length < 14 ||
					inputCpf.value.indexOf(".") > 2 ||
					inputCpf.value.indexOf("-") > 1 )
			{
				alert("Informe um CPF válido.");
				inputCpf.focus();
				return false;
			}
		
			//Nome
			if (inputNome.value.indexOf(" ") < 0) {
				alert("Informe o nome e sobrenome.");
				inputNome.focus();
				return false;
			}
			
			//Data de Nascimento
			//Sem validação
			
			//Nome de Usuário
			//Validação de caracteres especiais, com exceção de ponto final, underlinie e hífen
		
			//E-mail
			if (inputEmail.value.length < 6 || inputEmail.value.indexOf("@") < 1 ||
					inputEmail.value.lastIndexOf(".") < inputEmail.value.indexOf("@")) {
				alert("Email invalido!");
				inputEmail.focus();
				return false;
			}
		
			//Senha	
			//Sem validações específicas
		
			alert("Um sucesso!! =)");
		}
		
		function limpar() {
			crud_id.value = "";
			crud_nome.value = "";
			crud_email.value = "";
			crud_cpf.value = "";
			crud_nascimento.value = "";
			crud_username.value = "";
			crud_senha.value = "";
			crud_permissao.checked = false;
		}
	</script>
</html>