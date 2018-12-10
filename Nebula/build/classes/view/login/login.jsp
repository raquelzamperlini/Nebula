<%@ page import="br.com.nebula.model.Usuario" %>
<%@ page import="br.com.nebula.controller.UsuarioCTRL" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="Raquel Zamperlini">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">

<title>Nebula</title>
</head>

<body>
	<form action="Login" method="post">
		<h1>Login</h1>
		<label>E-mail: </label> <input id="login_email" name="login_email">

		<label>Senha: </label> <input type="password" id="login_senha"
			name="login_senha"> <input type="submit" value="Entrar"
			id="login_entrar">

		<button name="login_cadastrar" id="login_cadastrar"
		onclick="location.href = 'cadastre-se.jsp';">Cadastre-se</button>
	</form>

	<!-- Bootstrap core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
		
		<title>Nebula</title>
	</head>
	
	<body>
		<%
			/*
				* @author Raquel Zamperlini
				* Codigo implementado para verificar necessidade de usuário realizar login
				* Se houver usuário autenticado na sessao, a ideia é redireciona-lo para o
				* sistema
			*/
			
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String url = httpServletRequest.getRequestURI();
			HttpSession sessao = httpServletRequest.getSession();
			
			if (sessao.getAttribute("autenticado") != null &&
				url.lastIndexOf("login.jsp") > -1 ||
				url.lastIndexOf("Login") > -1 )
			{
				Usuario usuario = (Usuario) sessao.getAttribute("autenticado");
				
				if (usuario.getUs_email() != null &&
					usuario.getUs_senha() != null)
				{
					UsuarioCTRL usuarioCTRL = new UsuarioCTRL();
					Usuario verificador = usuarioCTRL.autenticarUsuario(usuario);
					
					if (verificador.getUs_nome() != "Deu ruim aqui..." &&
							verificador.isUs_status() /*&&
							autenticado.getUs_licencas() > 0*/ )
					{
						if (verificador.getUs_permissao().equals("administrador") )
						{
							response.sendRedirect("../administrador/home_f.jsp");
						}
	
						if (verificador.getUs_permissao().equals("usuario") )
							response.sendRedirect("../usuario/home_f.jsp");
					}
				}
			}
		%>
		
		<jsp:include page="cabecalhoLOGIN_f.jsp"></jsp:include>
		
		<br/>
		<br/>
		<br/>
		
		<div class="container w-25 p-3">
			<form action="Login" method="post" >
				<div class="form-group">
					<label for="exampleInputEmail1" >Email address</label>
					<input type="email" class="form-control" id="login_email" name="login_email"
					 aria-describedby="emailHelp" placeholder="Enter email">
					<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				</div>
				
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label>
					<input type="password" class="form-control" id="login_senha" name="login_senha" placeholder="Senha">
				</div>
				
				<div class="form-group align-self-center mr-3">
					<button type="button" name="login_cadastrar" id="login_cadastrar"
					 class="btn btn-secondary align-self-center mr-3"
					 onclick="location.href = 'cadastre-se.jsp';"> Cadastre-se </button>
						
					<button type="submit" class="btn btn-primary align-self-center mr-3">Entrar</button>
				</div>
			</form>
		</div>

		<!-- 
		<%
			/*
			String usuario = request.getParameter("login_email");
			String senha = request.getParameter("login_senha");
			
			if (usuario != null && senha != null
					&& !usuario.isEmpty() && !senha.isEmpty())
			{
				session.setAttribute("usuario", usuario);
				session.setAttribute("senha", senha);
				
			}
			*/
		%>
		-->
		
		<!-- Bootstrap core JavaScript -->
	    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	    
	    <script type="text/javascript">
		    document.getElementById("login_cadastrar").onclick = cadastre-se() {
		        location.href = "cadastre-se.jsp";
		    };
		</script>
	</body>
>>>>>>> refs/remotes/origin/raquel
</html>