<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
    Boolean estaLogado = session != null && session.getAttribute("apelido") != null;
    estaLogado = true;
%>
<header>
    <h1 id="logo">Blog Sem Nome</h1>
    
    <div class="espaco"></div>
    
    <div class="drop-container">
        <c:choose>
            <c:when test="${estaLogado == true}">
                <button id="autenticacao" class="botao borda botao-header margem-inferior">
                    <p>TODO</p>
                </button>
                <div class="drop-conteudo borda">
                    <div>
                        <a href="#">Link 1</a>
                        <a href="#">Link 2</a>
                        <a href="#">Link 3</a>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <button id="autenticacao" class="botao borda botao-header margem-inferior">Autenticação</button>
                <div class="drop-conteudo borda">
                    <div id="menu-autenticacao">
                        <div>
                            <a onclick="preencherAutenticacao()">Entrar</a>
                        </div>
                        <div>
                            <a onclick="preencherCadastro()">Cadastrar</a>
                        </div>
                    </div>
                    <div id="menu-entrar" hidden>
                        <div>
                            <input type="text" name="nomeUsuario" id="nome-usuario" placeholder="Nome de Usuário">
                        </div>
                        <div>
                            <input type="password" name="senha" id="senha" placeholder="Senha">
                        </div>
                        <div class="botoes-autenticacao">
                            <button class="botao borda botao-header" onclick="preencherCadastro()" tabindex="-1">Cadastrar</button>
                            <button class="botao borda botao-header" onclick="fazAutenticacao()">Entrar</button>
                        </div>
                    </div>
                    <div id="menu-cadastrar" hidden>
                        <div>
                            <input type="text" name="nomeUsuario" id="nome-usuario" placeholder="Nome de Usuário">
                        </div>
                        <div>
                            <input type="text" name="email" id="email" placeholder="E-mail">
                        </div>
                        <div>
                            <input type="password" name="senha" id="senha" placeholder="Senha">
                        </div>
                        <div>
                            <input type="password" name="comfirmaSenha" id="comfirma-senha" placeholder="Comfirmação da Senha">
                        </div>
                        <div class="botoes-autenticacao">
                            <button class="botao borda botao-header" onclick="preencherAutenticacao()" tabindex="-1">Entrar</button>
                            <button class="botao borda botao-header" type="submit">Cadastrar</button>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</header>
<script src="src/js/autenticacao.js"></script>