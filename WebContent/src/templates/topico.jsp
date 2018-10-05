<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div id="conteudo-topico" hidden>
    <section class="borda margem-conteudo-principal">
        <h1 id="titulo"></h1>
        <h2 id="data"></h2>
        <p id="conteudo"></p>
    </section>
    <jsp:include page="./comentario.jsp" />
    <section id="comentarios" class="margem-conteudo-principal borda topicos"></section>

    <a onclick="voltarParaListagem()" class="botao-flutuante borda botao botao-header"><i>Voltar<i></a>
</div>