<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${estaLogado != null}">
        <section class="borda margem-conteudo-principal comentario comentar">
            <div class="conteudo">
                <h2>Comentários</h2>
            </div>
            <div class="botao-ler">
                <button type="submit" class="botao borda botao-header" onclick="mostrarAreaDeComentar()">Comentar</button>
            </div>
        </section>

        <fieldset id="comentar" class="borda margem-conteudo-principal comentario" hidden>
            <script>
                $("#formulario-comentar").click(comentar);
            </script>
            <textarea name="texto-comentario" id="texto-comentario" rows="5" placeholder="Comente algo..."></textarea>
            <button id="formulario-comentar" class="botao borda botao-header" onclick="comentar()">Enviar</button>
        </fieldset>
    </c:when>
    <c:otherwise>
        <section class="borda margem-conteudo-principal comentario comentar">
            <div class="conteudo">
                <h2>Comentários</h2>
            </div>
        </section>
    </c:otherwise>
</c:choose>