<!--
/*
 * @author Vin�cius Ernani
 * 
 */
 -->

<%@ page import="br.com.nebula.model.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head >
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastro</title>
	</head>
	<body>
		<jsp:include page="cabecalho.jsp"></jsp:include> <br />
		
		<form id="crud_form" action="CadastroSalvo.jsp" method="post" >
			<div id="corpo">
				<div id="cadastro">
					<div id="title">
						<h1>Cadastro de Usu�rios</h1> <br />
						<h3 class="description">Cadastre um novo usu�rio:</h3>
					</div>
					
					<div class="forms">
						<!--
						<label>ID: </label>
						<input type="text" id="crud_id" name="crud_id" style="width:300px" maxlength="38" />
						 
						<button id="crud_pesquisar" name="crud_pesquisar" Height="32px" OnClick="Pesquisar">Pesquisar</button>
						
						 
						<br/>
						 -->
							
						<label>Nome: </label>
						<input type="text" id="crud_nome" name="crud_nome" style="width:300px" maxlength="100" placeholder="Entre com o nome completo do usu�rio"/>
						
						<br/>
						
						<label>E-mail: </label>
						<input type="text" id="crud_email" name="crud_email" style="width:300px" maxlength="100" placeholder="xxxxx@xxxxx.com"/>
						
						<br/>
						
						<label>CPF: </label>
						<input type="text" id="crud_cpf" name="crud_cpf" style="width:300px" maxlength="11" placeholder="Somente n�meros" />
						
						<br/>
						
						<label>Data de Nascimento: </label>
						<input type="date" id="crud_nascimento" name="crud_nascimento" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1901-01-01" />

						
						<br/>
						
						<label>Nome de Usu�rio: </label>
						<input id="crud_username" name="crud_username" style="width:250px" maxlength="50" />
						
						<br/>
						
						<label>Senha: </label>
						<input type="password" id="crud_senha" name="crud_senha" style="width:300px" maxlength="14" placeholder="Senha entre 6 e 14 caracteres"/> 
						
						<br />
						<br />
						
						<label id="ativo">Tipo de Permiss�o: </label> <br />
						<input type="radio" id="crud_permissao" name="crud_permissao" value="administrador" />Administrador <br />
						<input type="radio" id="crud_permissao" name="crud_permissao" value="usuario" />Usu�rio
						
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
		
		<a href="home.jsp">Voltar</a>
		
	</body>
</html>

<script lang="javascript" src="jquery-3.2.1.min.js">
</script>
<script language="javascript">
    function validar() {

        //C�digo
        if (crud_id.value.length < 13) {
            alert("Informe o RA do aluno com 13 d�gitos.");
            nome.focus();
            return false;
        }
        
        if (isNaN(codigo.value)) {
            alert("Informe somente n�meros para o RA.");
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
            alert("Informe um telefone v�lido!");
            telefone.focus();
            return false;
        }

        //senha	
        if (senha.value.length < 6 || !isNaN(senha.value)) {
            alert("Digite uma senha com ao menos 6 caracteres alfanum�ricos!");
            senha.focus();
            return false;
        }
        if (confsenha.value != senha.value) {
            alert("Senhas s�o diferentes ou inv�lidas!");
            confsenha.focus();
            return false;
        }

        alert("Usu�rio cadastrado com sucesso!");
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