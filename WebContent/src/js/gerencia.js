"use strict";

function apagarUsuario(identificador) {
    const dado = {
        identificador: identificador
    };
    post("", dado, dado => dado);
}