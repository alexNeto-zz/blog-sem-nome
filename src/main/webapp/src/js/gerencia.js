"use strict";


function apagarUsuario(identificador) {
    const dado = {
        identificador: identificador
    };
    post("restrito/gerenciar", dado, recarrega, recarrega);

    function recarrega() {
        location.reload();
    }
}

function apagarTopico() {
    const dado = {
        identificador: identificadorTopico
    };
    get("restrito/gerenciar/topico", dado, sucesso);

    function sucesso(dado) {
        location.reload();
        mudarParaConteudo(false);
        paraTopo();
    }
}

function novoTopico() {
    post("restrito/gerenciar/topico", pegaDadosTopico(), sucesso);

    function sucesso(dado) {
        document.getElementById("titulo").value = ""
        document.getElementById("texto-topico").value = ""
        location.reload();
    }

    function pegaDadosTopico() {
        return {
            titulo: document.getElementById("titulo").value,
            conteudo: document.getElementById("texto-topico").value
        };
    }
}

function apagarComentario(identificador) {
    const dado = {
        identificador: identificador
    };
    get("comentario", dado, sucesso);

    function sucesso(dado) {
        location.reload();
    }
}

function enviarTopico() {
    const dado = {
        identificador: identificadorTopico,
        titulo: document.getElementById("titulo-edicao").value,
        conteudo: document.getElementById("texto-topico").value
    }
    if (podeEditar())
        post("restrito/gerenciar/topico/edicao", dado, sucesso);

    function sucesso(dado) {
        location.reload();
    }
}