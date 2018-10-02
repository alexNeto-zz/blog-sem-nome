<!DOCTYPE html>
<%@page import="com.blog.topico.TopicoServico"%>
<%@page import="com.blog.topico.Topico"%>
<%@page import="java.util.List"%>
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

	<%
		TopicoServico topicoServico = new TopicoServico();
		List<Topico> topicos = topicoServico.pegaTodos();
	%>
	<section class="margem-conteudo-principal borda topicos">
		<c:forEach items="${topicos}" var="topico">
			<article class="borda">
				<div class="conteudo">
					<h2>${topico.getTitulo()}</h2>
					<h3>${topico.getDataCriacao()}</h3>
					<p>${topico.getConteudo()}</p>
				</div>
				<div class="botao-ler">
					<button class="botao borda botao-header" onclick="verTopico(${topico.getIdentificador})">Ler</button>
				</div>
			</article>
		</c:forEach>

	</section>
</body>

</html>