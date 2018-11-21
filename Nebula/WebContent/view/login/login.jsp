<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
		
		<title>Nebula</title>
	</head>
	
	<body>
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
</html>