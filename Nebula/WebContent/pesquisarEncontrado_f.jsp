
<%@ page import="br.com.nebula.model.Usuario" %>
<%@ page import="br.com.nebula.controller.Datas" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="cabecalho_f.jsp"></jsp:include> <br />
		
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			
			Datas datas = new Datas();
		%>
		
		<form id="crud_form" action="PesquisarServlet" method="post" >
			<input type="text" id="crud_id" name="crud_id" style="width:300px" maxlength="38"> 
			
			<input type="submit" id="crud_pesquisar" name="crud_pesquisar" value="Pesquisar"> <br/>
			
			<div>
				<label>ID: </label>
				<input type="text" id="crud_id" name="crud_id" style="width:300px" maxlength="38"
					value="<%=usuario.getUs_id() %>" readonly />
				
				<br/>
					
				<label>Nome: </label>
				<input type="text" id="crud_nome" name="crud_nome" style="width:300px" maxlength="100"
				 placeholder="Entre com o nome completo do usuário"
				 	value="<%=usuario.getUs_nome() %>" readonly/>
				
				<br/>
				
				<label>E-mail: </label>
				<input type="text" id="crud_email" name="crud_email" style="width:300px" maxlength="100"
				 placeholder="xxxxx@xxxxx.com"
				 	value="<%=usuario.getUs_email() %>" readonly />
				
				<br/>
				
				<label>CPF: </label>
				<input type="text" id="crud_cpf" name="crud_cpf" style="width:300px" maxlength="11"
				 placeholder="Somente números"
				 	value="<%=usuario.getUs_cpf() %>" readonly />
				
				<br/>
				
				<label>Data de Nascimento: </label>
				<input type="text" id="crud_nascimento" name="crud_nascimento" required="required"
				 	value="<%=datas.localDateParaString(usuario.getUs_nascimento()) %>" readonly />
				<!-- maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1901-01-01" -->
	
				
				<br/>
				
				<label>Nome de Usuário: </label>
				<input id="crud_username" name="crud_username" style="width:250px" maxlength="50"
					value="<%=usuario.getUs_username() %>" readonly />
				
				<br/>
				
				<!-- 
				<label>Senha: </label>
				<input type="password" id="crud_senha" name="crud_senha" style="width:300px"
				 maxlength="14" placeholder="Senha entre 6 e 14 caracteres"
				 	value="<%=usuario.getUs_senha() %>" readonly /> 
				  -->
				
				<br />
				<br />
				
				<label id="ativo">Tipo de Permissão: </label> <br />
				<input type="text" id="crud_permissao" name="crud_permissao"
					value="<%=usuario.getUs_permissao() %>" readonly />
				
				<br/>
			</div>
		</form>
	</body>
</html>