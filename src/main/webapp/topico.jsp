<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <jsp:include page="./src/templates/head.jsp" />
    <title>Blog Sem Nome</title>
</head>

<body>
    <jsp:include page="./src/templates/header.jsp" />
    <div id="conteudo-topico">
        <div id="topico-estatico">
            <section class="borda margem-conteudo-principal">
                <h1 id="titulo">${topico.getTitulo()}</h1>
                <h2 id="data">${topico.getDataCriacao()}</h2>
                <p id="conteudo">${topico.getConteudo()}</p>
            </section>
        </div>
        <div id="topico-editavel" hidden>
            <section class="margem-conteudo-principal borda topicos">
                <article class="borda">
                    <div class="conteudo">
                        <input type="text" name="titulo" id="titulo-edicao" placeholder="Título">
                        <textarea name="texto-comentario" id="texto-topico" placeholder="Escreva algo..."></textarea>
                    </div>
                    <div class="botao-ler">
                        <button id="formulario-comentar" class="botao borda botao-header" onclick="cancelarEdicao()">Cancelar</button>
                        <button id="formulario-comentar" class="botao borda botao-header" onclick="enviarTopico()">Enviar</button>
                    </div>
                </article>
            </section>
        </div>
        <jsp:include page="./src/templates/comentario.jsp" />
        <section id="comentarios" class="margem-conteudo-principal borda topicos">
            <c:forEach items="${topico.getComentarios()}" var="comentario">
                <article class="borda">
                    <div class="conteudo">
                        <h2>${comentario.getApelido()}</h2>
                        <h3>${comentario.getDataCriacao()}</h3>
                        <p>${comentario.getConteudo()}</p>
                    </div>
                </article>
            </c:forEach>
        </section>

        <c:if test="${tipoUsuario == 'ADM'}">
            <a onclick="editarTopico()" class="botao-flutuante-editar borda botao botao-header"><i>Editar<i></a>
            <a onclick="apagarTopico()" class="botao-flutuante-apagar borda botao botao-header"><i>Apagar<i></a>
        </c:if>
        <a id="botao-voltar" onclick="voltarParaListagem()" class="botao-flutuante borda botao botao-header"><i>Voltar<i></a>
    </div>
</body>

</html>