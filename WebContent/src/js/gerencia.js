"use strict";

function apagarUsuario(identificador) {
    const dado = {
        identificador: identificador
    };
    post("", dado, dado => dado);
}

function notoTopico() {
    post("topico", pegaDadosTopico(), sucesso);

    function sucesso(dado) {
        document.getElementById("titulo").value = ""
        document.getElementById("texto-topico").value = ""
    }

    function pegaDadosTopico() {
        return {
            titulo: document.getElementById("titulo").value,
            conteudo: document.getElementById("texto-topico").value
        };
    }
}
