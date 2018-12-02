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
    const resultado = () => {
        if (!validaApelido(dados.apelido))
            return false;
        if (!validaEmail(dados.email))
            return false;
        if (!validaSenha(dados.senha, dados.confirmaSenha))
            return false;
        return true;
    };

    return resultado();
}

function validaApelido(apelido) {
    let usuarioExiste;
    get("usuario", pegaApelido(), (dado) => usuarioExiste = dado.usuarioExiste);
    let resultado = () => {
        if (apelido === undefined)
            return false;
        if (apelido.length < 3)
            return false;
        if (usuarioExiste)
            return false;
        return true;
    };

    return resultado();

    function pegaApelido() {
        return {
            apelido: apelido
        };
    }
}

function validaEmail(email) {
    const resultado = () => {
        if (email === undefined)
            return false;
        if (!encontra(email, "@"))
            return false;
        return true;
    };
    return resultado();
}

function validaSenha(senha, confirmaSenha) {
    let resultado = () => {
        if (senha != confirmaSenha)
            return false;
        return true;
    };

    return resultado();
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