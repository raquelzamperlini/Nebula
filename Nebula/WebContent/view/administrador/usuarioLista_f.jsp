<%@ page import="br.com.nebula.model.Usuario" %>
<%@ page import="br.com.nebula.controller.UsuarioCTRL" %>
<%@ page import="br.com.nebula.controller.Datas" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>Lista de Usuários</title>
	</head>
	
	<body>
		<jsp:include page="cabecalhoADM_f.jsp"></jsp:include> <br />
		
		<%
			UsuarioCTRL usuarioCTRL = new UsuarioCTRL();
			Datas datas = new Datas();
			
			//List<Usuario> usuarios = usuarioCTRL.retornarTodosUsuarios();
			List<Usuario> buscaUsuarios = (List<Usuario>) request.getAttribute("usuarios");
			
			/*
			for (Usuario u:buscaUsuarios) {
				out.println("ID: " 				+ u.getUs_id()				+
							"Diretório Raiz: "	+ u.getUs_diretorio_raiz()	+
							"Nome: "			+ u.getUs_nome()			+
							"E-mail: "			+ u.getUs_email()			+
							"CPF: "				+ u.getUs_cpf()				+
							"Nascimento: "		+ u.getUs_nascimento()		+
							"Username: "		+ u.getUs_nascimento()		+
							"Senha: "			+ u.getUs_senha()			+
							"Permissão: "		+ u.getUs_permissao());
			}
			*/
		%>
		
		<table border="1" >
			<tr bgcolor="eaeaea">
				<th>ID</th>
				<th>Diretório Raiz</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>CPF</th>
				<th>Nascimento</th>
				<th>Username</th>
				<th>Senha</th>
				<th>Permissão</th>
				<th>Status</th>
				<th>Licenças</th>
				<th>Excluir</th>
				<th>Alterar</th>
			</tr>
			
			<%
				for (Usuario u:buscaUsuarios)
				{
					
			%>
				
			<tr>
				<th><%= u.getUs_id() %></th>
				<th><%= u.getUs_diretorio_raiz() %></th>
				<th><%= u.getUs_nome() %></th>
				<th><%= u.getUs_email() %></th>
				<th><%= u.getUs_cpf() %></th>
				<th><%= datas.localDateParaString(u.getUs_nascimento()) %></th>
				<th><%= u.getUs_username() %></th>
				<th><%= u.getUs_senha() %></th>
				<th><%= u.getUs_permissao() %></th>
				<th><%= u.isUs_status() %></th>
				<th><%= u.getUs_licencas() %></th>
				<th>
					<button id="excluir" name="excluir">
						<a href="UsuarioCRUD?acao=excluir&us_id=<%= u.getUs_id() %>">Excluir</a>
					</button>
				</th>
				<th>
					<button id="alterar" name="alterar">
						<a href="UsuarioCRUD?acao=alterar&us_id=<%= u.getUs_id() %>">Alterar</a>
					</button>
				</th>	
			</tr>
			
			<%
				}
			%>
			
		</table>
		
	</body>
</html>