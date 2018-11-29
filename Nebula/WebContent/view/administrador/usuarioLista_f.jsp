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
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
		
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
		
		<table class="table" >
			<tr bgcolor="eaeaea">
				<th scope="col">ID</th>
				<th scope="col">Diretório Raiz</th>
				<th scope="col">Nome</th>
				<th scope="col">E-mail</th>
				<th scope="col">CPF</th>
				<th scope="col">Nascimento</th>
				<th scope="col">Username</th>
				<!-- <th scope="col">Senha</th>  -->
				<th scope="col">Permissão</th>
				<th scope="col">Status</th>
				<!-- <th scope="col">Licenças</th>  -->
				<th scope="col">Excluir</th>
				<th scope="col">Alterar</th>
			</tr>
			
			<%
				for (Usuario u:buscaUsuarios)
				{
					
			%>
				
			<tr scope="row">
				<th scope="col"><%= u.getUs_id() %></th>
				<th scope="col"><%= u.getUs_diretorio_raiz() %></th>
				<th scope="col"><%= u.getUs_nome() %></th>
				<th scope="col"><%= u.getUs_email() %></th>
				<th scope="col" OnLoad="formatar('###.###.###-##', this)"><%= u.getUs_cpf() %></th>
				<th scope="col"><%= datas.localDateParaString(u.getUs_nascimento()) %></th>
				<th scope="col"><%= u.getUs_username() %></th>
				<!-- <th scope="col"><%//= u.getUs_senha() %></th>  -->
				<th scope="col"><%= u.getUs_permissao() %></th>
				<th scope="col"><%= u.isUs_status() %></th>
				<!-- <th scope="col"><%= u.getUs_licencas() %></th>  -->
				<th scope="col">
					<button id="excluir" name="excluir">
						<a href="UsuarioCRUD?acao=excluir&us_id=<%= u.getUs_id() %>">Excluir</a>
					</button>
				</th>
				<th scope="col">
					<button id="alterar" name="alterar">
						<a href="UsuarioCRUD?acao=alterar&us_id=<%= u.getUs_id() %>">Alterar</a>
					</button>
				</th>	
			</tr>
			
			<%
				}
			%>
			
		</table>
		
		<!-- Bootstrap core JavaScript -->
		<script src="/resources/css/bootstrap.min.js"></script>
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