<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
	<jsp:include page="./src/templates/head.jsp" />
	<title>Locadora Sem Nome</title>
</head>

<body>
	<jsp:include page="./src/templates/header.jsp" />

	<div id="listagem-topico">
		<section class="margem-conteudo-principal borda topicos">
			<c:forEach items="${topicos}" var="topico">
				<article class="borda">
					<div class="conteudo">
						<h2>${topico.getTitulo()}</h2>
						<h3>${topico.getDataCriacao()}</h3>
						<p>${topico.getConteudoTamanho200()}</p>
					</div>
					<div class="botao-ler">
						<button type="submit" class="botao borda botao-header" onclick="lerTopico(${topico.getIdentificador()})">Ler</button>
					</div>
				</article>
			</c:forEach>
		</section>
	</div>

	<div id="conteudo-topico" hidden>
		<section class="borda margem-conteudo-principal">
			<h1 id="titulo"></h1>
			<h2 id="data"></h2>
			<p id="conteudo"></p>
		</section>

		<section class="borda margem-conteudo-principal comentario">
			<h1>Comentários</h1>
		</section>
		<div id="comentarios"></div>
		<a onclick="voltarParaListagem()" class="botao-flutuante borda botao botao-header"><i>Voltar<i></a>
	</div>

</body>

</html>