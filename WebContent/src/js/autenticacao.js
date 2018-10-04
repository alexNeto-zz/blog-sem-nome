"use strict";

function preencherAutenticacao() {
    mudarParaCadastro(false);
}

function preencherCadastro() {
    mudarParaCadastro(true);
}

function voltarMenuInicial() {
    mudaVisibilidadeMenu(false);
    document.getElementById("autenticacao").hover();
}

function mudarParaCadastro(estaVisivel) {
    document.getElementById("menu-autenticacao").hidden = true;
    document.getElementById("menu-entrar").hidden = estaVisivel;
    document.getElementById("menu-cadastrar").hidden = !estaVisivel;
}

function fazCadastro() {
    if (validaCampos())
        post("cadastro", pegaDadosCadastro(), sucesso);
    else
        console.log("TODO - implementar erro ao cadastrar");
}

function validaCampos() {
    const dados = pegaDadosCadastro();
    dados.confirmaSenha = confirmaSenha();
    let result = true;
    if (validaApelido(dados.apelido))
        result = false;
    if (validaEmail(dados.email))
        result = false;
    if (validaSenha(dados.senha, dados.confirmaSenha))
        result = false;

    return result;
}

function validaApelido(apelido) {
    let result = true;
    let usuarioExiste;
    get("usuario", apelido(), (dado) => usuarioExiste = dado.usuarioExiste);
    if (apelido === undefined)
        result = false;
    if (apelido.length < 3)
        result = false;
    if (usuarioExiste)
        result = false;
    return result;

    function apelido() {
        return {
            apelido: apelido
        };
    }
}

function validaEmail(email) {
    let result = true;
    if (email === undefined)
        result = false;
    if (!encontra(separa(email), "@"))
        result = false;
    return result;
}

function validaSenha(senha, confirmaSenha) {
    let result = true;
    if (senha.length < 8)
        result = false;
    if (senha != confirmaSenha)
        result = false;
    return result;
}

function pegaDadosCadastro() {
    return {
        apelido: document.getElementById("novo-apelido").value,
        senha: document.getElementById("nova-senha").value,
        email: document.getElementById("email").value,
    };
}

function confirmaSenha() {
    return document.getElementById("confirma-senha").value;
}

function fazAutenticacao() {
    post("autenticacao", pegaDadosCadastro(), sucesso);

    function pegaDadosCadastro() {
        return {
            apelido: document.getElementById("apelido").value,
            senha: document.getElementById("senha").value
        };
    }

    function sucesso(dado) {
        location.reload();
    }

    function falha(xhr, status, error) {
        $("#apelido").addClass("erro");
        $("#senha").addClass("erro");
    }
}

function sair() {
    post("sair", undefined, sucesso);

    function sucesso(dado) {
        location.reload();
    }
}