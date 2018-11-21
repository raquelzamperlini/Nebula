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
		
		<title>Acesso inválido</title>
	</head>
	
	<body>
		<jsp:include page="cabecalhoLOGIN_f.jsp"></jsp:include>
	
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-4">Dados de acesso inválidos</h1>
				<p class="lead">Houve uma tentativa de acesso ao sistema com
						dados inválidos.</p>
				<a href="login.jsp">Tente novamente</a>
			</div>
		</div>
	
		<!-- Bootstrap core JavaScript -->
		<script
			src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	
		<script type="text/javascript">
			document.getElementById("login_cadastrar").onclick = cadastre - se()
			{
				location.href = "cadastre-se.jsp";
			};
		</script>
	</body>
</html>