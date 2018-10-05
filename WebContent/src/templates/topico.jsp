<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div id="conteudo-topico" hidden>
    <div id="topico-estatico" hidden>
        <section class="borda margem-conteudo-principal">
            <h1 id="titulo"></h1>
            <h2 id="data"></h2>
            <p id="conteudo"></p>
        </section>
    </div>
    <div id="topico-editavel">
        <section class="margem-conteudo-principal borda topicos">
            <article class="borda">
                <div class="conteudo">
                    <input type="text" name="titulo" id="titulo" placeholder="Título">
                    <textarea name="texto-comentario" id="texto-topico" placeholder="Escreva algo..."></textarea>
                </div>
                <div class="botao-ler">
                    <button id="formulario-comentar" class="botao borda botao-header" onclick="editarTopico()">Enviar</button>
                </div>
            </article>
        </section>
    </div>
    <jsp:include page="./comentario.jsp" />
    <section id="comentarios" class="margem-conteudo-principal borda topicos"></section>

    <c:if test="${tipoUsuario == 'ADM'}">
        <a onclick="editarTopico()" class="botao-flutuante-editar borda botao botao-header"><i>Editar<i></a>
        <a onclick="apagarTopico()" class="botao-flutuante-apagar borda botao botao-header"><i>Apagar<i></a>
    </c:if>
    <a id="botao-voltar" onclick="voltarParaListagem()" class="botao-flutuante borda botao botao-header"><i>Voltar<i></a>
</div>