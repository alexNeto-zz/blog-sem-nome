"use strict";

function preencherAutenticacao() {
    mudarParaCadastro(false);
    $("#apelido").focus();
}

function preencherCadastro() {
    mudarParaCadastro(true);
    $("#novo-apelido").focus();
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
        $("input").addClass("erro");
}

function validaCampos() {
    const dados = pegaDadosCadastro();
    dados.confirmaSenha = confirmaSenha();
    let resultado = true;
    if (!validaApelido(dados.apelido))
        resultado = false;
    if (!validaEmail(dados.email))
        resultado = false;
    if (!validaSenha(dados.senha, dados.confirmaSenha))
        resultado = false;
    return resultado;
}

function validaApelido(apelido) {
    let resultado = true;
    let usuarioExiste;
    get("usuario", pegaApelido(), (dado) => usuarioExiste = dado.usuarioExiste);
    if (apelido === undefined)
        resultado = false;
    if (apelido.length < 3)
        resultado = false;
    if (usuarioExiste)
        resultado = false;
    return resultado;

    function pegaApelido() {
        return {
            apelido: apelido
        };
    }
}

function validaEmail(email) {
    let resultado = true;
    if (email === undefined)
        resultado = false;
    if (!encontra(email, "@"))
        resultado = false;
    return resultado;
}

function validaSenha(senha, confirmaSenha) {
    let resultado = true;
    if (senha != confirmaSenha)
        resultado = false;
    return resultado;
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
    post("autenticacao", pegaDadosAutenticacao(), sucesso, falha);

    function pegaDadosAutenticacao() {
        return {
            apelido: document.getElementById("apelido").value,
            senha: document.getElementById("senha").value
        };
    }

    function falha(xhr, status, error) {
        console.log(xhr, status, error);
        $("#apelido").addClass("erro");
        $("#senha").addClass("erro");
    }
}

function sair() {
    post("sair", undefined, sucesso);
}

function sucesso(dado) {
    location.reload();
}
/***********************************************/
/*************** EVENTOS ***********************/
/***********************************************/

function controlaModal() {
    var modal = document.getElementById('myModal');
    var botao = document.getElementById("autenticacao");
    var fechar = document.getElementsByClassName("fecha")[0];

    botao.onclick = function () {
        modal.style.display = "block";
    }

    fechar.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}


window.onload = () => {
    try {
        controlaModal()
    } catch (ignored) {}
};