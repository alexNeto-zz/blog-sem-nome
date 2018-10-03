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
        apelido: document.getElementById("nome-usuario").value,
        senha: document.getElementById("senha").value
    }
    post("autenticacao", dados, (dado) => console.log(dado));   

}

function sair() {

}