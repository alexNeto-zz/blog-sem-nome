"use strict";

function fazerAutenticacao() {
    mudaVisibilidadeMenu(true);
    console.log("aaaaaaaaaaaaaaaaaaa");
}


function voltarMenuInicial() {
    mudaVisibilidadeMenu(false);
    document.getElementById("autenticacao").hover();
}

function mudaVisibilidadeMenu(estaVisivel) {
    const menuEntrar = document.getElementById("menu-autenticacao");
    menuEntrar.hidden = estaVisivel;
    const menuAutenticacao = document.getElementById("menu-entrar");
    menuAutenticacao.hidden = !estaVisivel;
}

function estaAutenticado() {

}

function fazCadastro() {

}

function fazAutenticacao() {

}

function sair() {

}