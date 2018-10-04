"use strict";

function preencherAutenticacao() {
    mudarParaCadastro(false);
}

function preencherCadastro(){
    mudarParaCadastro(true);
}

function voltarMenuInicial() {
    mudaVisibilidadeMenu(false);
    document.getElementById("autenticacao").hover();
}

function mudarParaCadastro(estaVisivel) {
    const menuEntrar = document.getElementById("menu-autenticacao");
    menuEntrar.hidden = true;
    const menuAutenticacao = document.getElementById("menu-entrar");
    menuAutenticacao.hidden = estaVisivel;
    const menuCadastro = document.getElementById("menu-cadastrar");
    menuCadastro.hidden = !estaVisivel;
}

function estaAutenticado() {

}

function fazCadastro() {

}

function fazAutenticacao() {
    const dados = {
        apelido: document.getElementById("apelido").value,
        senha: document.getElementById("senha").value
    }
    post("autenticacao", dados, sucesso);   

    function sucesso(dado){
        location.reload();
    }

    function falha(xhr, status, error){
        $("#apelido").addClass("erro");
        $("#senha").addClass("erro");
    }

}

function sair() {
    post("sair", undefined, sucesso);

    function sucesso(dado){
        location.reload();
    }
}