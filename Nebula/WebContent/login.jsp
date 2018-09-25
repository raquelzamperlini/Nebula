<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<title>Login</title>
	</head>
	
	<body>
		<form action="LoginServlet" method="post" >
			<h1>Login</h1>
			<label>E-mail: </label>
			<input id="login_email" name="login_email" >
			
			<label>Senha: </label>
			<input type="password" id="login_senha" name="login_senha" >
			
			<input type="submit" value="Entrar" id="login_entrar">
			<button name="login_cadastrar" id="login_cadastrar">
				<a href="cadastroUsuario.jsp">Cadastre-se</a>
			</button>
		</form>
		
		<%
			String usuario = request.getParameter("login_email");
			String senha = request.getParameter("login_senha");
			
			if (usuario != null && senha != null
					&& !usuario.isEmpty() && !senha.isEmpty())
			{
				session.setAttribute("usuario", usuario);
				session.setAttribute("senha", senha);
				
			}
		%>
	</body>
</html>