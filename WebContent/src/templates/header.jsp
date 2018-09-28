<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
    Boolean estaLogado = session != null && session.getAttribute("nomeUsuario") != null;
    estaLogado = true;
%>
<header>
    <div class="drop-container">
        <button class="botao borda botao-header margem-inferior">Navegação</button>
        <div class="drop-conteudo borda">
            <a href="#">Link 1</a> <a href="#">Link 2</a> <a href="#">Link 3</a>
        </div>
    </div>

    <h1 id="logo">Locadora Sem Nome</h1>

    <div class="drop-container">
        <c:choose>
            <c:when test="${estaLogado == true}">
                <button id="autenticacao" class="botao borda botao-header margem-inferior">
                    <p>TODO</p>
                </button>
                <div class="drop-conteudo borda">
                    <div><a href="#">Link 1</a> <a href="#">Link 2</a> <a href="#">Link 3</a></div>
            </c:when>
            <c:otherwise>
                <button id="autenticacao" class="botao borda botao-header margem-inferior">Autenticação</button>
                <div class="drop-conteudo borda">
                    <div><a href="#">Entrar</a><a href="#">Cadastrar</a></div>
            </c:otherwise>
        </c:choose>
    </div>
    </div>
</header>