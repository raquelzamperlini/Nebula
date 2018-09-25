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
		<form id="crud_form" action="cadastre-seSalvar.jsp" method="post" >
			<div id="corpo">
				<div id="cadastro">
					<div id="title">
						<h1>Cadastre-se</h1> <br />
						<h3 class="description">Informe seus dados:</h3>
					</div>
					
					<div class="forms">
						<!--
						<label>ID: </label>
						<input type="text" id="crud_id" name="crud_id" style="width:300px" maxlength="38" />
						 
						<button id="crud_pesquisar" name="crud_pesquisar" Height="32px" OnClick="Pesquisar">Pesquisar</button>
						
						 
						<br/>
						 -->
							
						<label>Nome: </label>
						<input type="text" id="crud_nome" name="crud_nome" style="width:300px" maxlength="100" placeholder="Entre com o nome completo do usuário"/>
						
						<br/>
						
						<label>E-mail: </label>
						<input type="text" id="crud_email" name="crud_email" style="width:300px" maxlength="100" placeholder="xxxxx@xxxxx.com"/>
						
						<br/>
						
						<label>CPF: </label>
						<input type="text" id="crud_cpf" name="crud_cpf" style="width:300px" maxlength="11" placeholder="Somente números" />
						
						<br/>
						
						<label>Data de Nascimento: </label>
						<input type="date" id="crud_nascimento" name="crud_nascimento" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1901-01-01" />

						
						<br/>
						
						<label>Nome de Usuário: </label>
						<input id="crud_username" name="crud_username" style="width:250px" maxlength="50" />
						
						<br/>
						
						<label>Senha: </label>
						<input type="password" id="crud_senha" name="crud_senha" style="width:300px" maxlength="14" placeholder="Digite sua senha" /> 
						
						<br/>
						
						<!-- 
						<label>Número de licenças: </label>
						<input id="crud_licencas" name="crud_licencas" style="width:40px" maxlength="1" />
						-->
						
						<br />
						<br />
						
						<!-- 
						<label id="ativo">Tipo de Permissão: </label> <br />
						<input type="radio" id="crud_permissao" name="crud_permissao" value="administrador" />Administrador <br />
						<input type="radio" id="crud_permissao" name="crud_permissao" value="usuario" />Usuário
						
						<br/>
						 -->
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
		
		<a href="login.jsp">Voltar</a>
	</body>
</html>

<script lang="javascript" src="jquery-3.2.1.min.js">
</script>
<script language="javascript">
    function validar() {

        //Código
        if (crud_id.value.length < 13) {
            alert("Informe o RA do aluno com 13 dígitos.");
            nome.focus();
            return false;
        }
        
        if (isNaN(codigo.value)) {
            alert("Informe somente números para o RA.");
            nome.focus();
            return false;
        }

        //Nome
        if (nome.value.indexOf(" ") < 0) {
            alert("Informe o nome e sobrenome do aluno.");
            nome.focus();
            return false;
        }

        //e-mail
        if (email.value.length < 6 || email.value.indexOf("@") < 1 ||
            email.value.lastIndexOf(".") < email.value.indexOf("@")) {
            alert("Email invalido!");
            email.focus();
            return false;
        }

        //telefone
        if (telefone.value.length < 8) {
            alert("Informe um telefone válido!");
            telefone.focus();
            return false;
        }

        //senha	
        if (senha.value.length < 6 || !isNaN(senha.value)) {
            alert("Digite uma senha com ao menos 6 caracteres alfanuméricos!");
            senha.focus();
            return false;
        }
        if (confsenha.value != senha.value) {
            alert("Senhas são diferentes ou inválidas!");
            confsenha.focus();
            return false;
        }

        alert("Usuário cadastrado com sucesso!");
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