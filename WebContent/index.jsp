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

	<div id="listagem-topico">
		<section class="margem-conteudo-principal borda topicos">
			<%
            TopicoServico topicoServico = new TopicoServico();
			List<Topico> topicos = topicoServico.pegaTodos();
				for (Topico topico : topicos) {
					out.print("<article class=\"borda\">");
					out.print("<div class=\"conteudo\">");
					out.print("<h2>" + topico.getTitulo() + "</h2>");
					out.print("<h3>" + topico.getDataCriacao() + "</h3>");
					out.print("<p>" + topico.getConteudoTamanho200() + "</p>");
					out.print("</div><div class=\"botao-ler\">");
					out.print("<button type=\"submit\" class=\"botao borda botao-header\" onclick=\"lerTopico(" + topico.getIdentificador() + ")\">Ler</button>");
					out.print("</div></article>");
				}
			%>
		</section>
	</div>

	<div id="conteudo-topico" hidden>
		<section class="borda margem-conteudo-principal">
			<h1 id="titulo"></h1>
			<h2 id="data"></h2>
			<p id="conteudo"></p>
		</section>

		<section class="borda margem-conteudo-principal comentario">
			<h1>Lorem ipsum dolor sit amet consectetur </h1>
			<h2>21/21/2112</h2>
			<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolores blanditiis impedit, quidem, dolorem
				corrupti
			</p>
		</section>
		<section class="borda margem-conteudo-principal comentario">
			<h1>Lorem ipsum dolor sit amet consectetur </h1>
			<h2>21/21/2112</h2>
			<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolores blanditiis impedit, quidem, dolorem
				corrupti
			</p>
		</section>
		<section class="borda margem-conteudo-principal comentario">
			<h1>Lorem ipsum dolor sit amet consectetur </h1>
			<h2>21/21/2112</h2>
			<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolores blanditiis impedit, quidem, dolorem
				corrupti
			</p>
		</section>
	<a onclick="voltarParaListagem()" class="botao-flutuante borda botao botao-header"><i>Voltar<i></a>
	</div>
	
</body>

</html>