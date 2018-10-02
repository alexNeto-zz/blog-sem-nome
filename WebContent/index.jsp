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

	<section class="margem-conteudo-principal borda topicos">
	<%
            TopicoServico topicoServico = new TopicoServico();
		List<Topico> topicos = topicoServico.pegaTodos();
            for (Topico topico : topicos) {
                out.print("<article class=\"borda\">");
                out.print("<div class=\"conteudo\">");
				out.print("<h2>" + topico.getTitulo() + "</h2>");
				out.print("<h3>" + topico.getDataCriacao() + "</h3>");
				out.print("<p>" + topico.getConteudo() + "</p>");
				out.print("</div><div class=\"botao-ler\">");
				out.print("<button class=\"botao borda botao-header\" onclick=\"lerTopico(" + topico.getIdentificador() + ")\">Ler</button>");
				out.print("</div></article>");
            }
        %>
	</section>
</body>

</html>