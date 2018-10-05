<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <jsp:include page="./src/templates/head.jsp" />
    <script src="${pageContext.request.contextPath}/src/js/gerencia.js"></script>
    <title>Gerenciar Blog Sem Nome</title>
</head>

<body>
    <header>
        <h1 id="logo">Blog Sem Nome</h1>
    </header>

    <section class="margem-conteudo-principal borda topicos">
        <c:forEach items="${usuarios}" var="usuario">
            <article class="borda">
                <div class="conteudo">
                    <h2>Apelido: ${usuario.getApelido()}</h2>
                    <h3>email: ${usuario.getEmail()}</h3>
                    <p>tipo: ${usuario.getTipoUsuario()}</p>
                </div>
                <div class="botao-ler">
                    <button type="submit" class="botao borda botao-header" onclick="apagarUsuario(${usuario.getIdentificador()})">Apagar</button>
                </div>
            </article>
        </c:forEach>
    </section>

    <section id="topicos">
        <div></div>
        <div></div>
    </section>

</body>

</html>