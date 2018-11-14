<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
                    <a type="submit" class="botao borda botao-header" href="${pageContext.request.contextPath}/topico?topico=${topico.getIdentificador()}">Ler</a>
                </div>
            </article>
        </c:forEach>
    </section>
</div>