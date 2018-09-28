<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<link href="https://fonts.googleapis.com/css?family=Gilda+Display" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet">

	<script src="https://cdn.jsdelivr.net/lodash/4/lodash.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.0.js"></script>

	<link rel="stylesheet" href="./src/css/reset.css">
	<link rel="stylesheet" href="./src/css/master.css">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/x-icon" href="favicon.ico">
	<title>Locadora Sem Nome</title>
</head>

<body>
	<jsp:include page="./src/templates/header.jsp" />


	<main class="container margem-container">
		<nav>
			<div class="container column">
				<div class="container row">
					<button class="filtro borda botao">filtro</button>
					<button class="filtro borda botao">filtro</button>
				</div>
				<div id="filtro-pesquisa" class="borda"></div>
			</div>
		</nav>
		<section class="margem-conteudo-principal borda"></section>
	</main>
	<jsp:include page="./src/templates/footer.html" />
</body>

</html>