<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-BR">

<head>
	<jsp:include page="./src/templates/head.html" />
	<title>Locadora Sem Nome</title>
</head>

<body>
	<jsp:include page="./src/templates/header.html" />


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