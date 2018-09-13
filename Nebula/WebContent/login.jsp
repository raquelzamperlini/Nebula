<!--
/*
 * @author Raquel Zamperlini
 * 
 */
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form action="Login" method="post" >
			<h1>Login</h1>
			<label>E-mail: </label>
			<input id="login_email" name="login_email" >
			
			<label>Senha: </label>
			<input type="password" id="login_senha" name="login_senha" >
			
			<input type="submit" value="Entrar" id="login_entrar">
			<!-- <input type="submit" value="Cadastrar" id="login_cadastrar"> -->
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