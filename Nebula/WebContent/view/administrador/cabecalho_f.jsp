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
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo03"
				aria-controls="navbarTogglerDemo03" aria-expanded="false"
				aria-label="Toggle navigation">
				
				<span class="navbar-toggler-icon"></span>
			</button>
			
			<a class="navbar-brand" href="#"><h1>Nebula</h1></a>
			
			<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active">
						<a class="nav-link" href="home_f.jsp">Home
							<span class="sr-only">(current)</span>
						</a>
					</li>
					
					<li class="nav-item"><a class="nav-link" href="usuarioCadastro_f.jsp">Cadastrar Usuários</a>
					</li>
					
					<li class="nav-item"><a class="nav-link" href="UsuarioCRUD?acao=listar">Usuários</a>
					</li>
					
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				
				<form class="form-inline my-2 my-lg-0" action="Pesquisar" method="post">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
						
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
				</form>
			</div>
		</nav>
	
		<!-- Bootstrap core JavaScript -->
	    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	</body>
</html>