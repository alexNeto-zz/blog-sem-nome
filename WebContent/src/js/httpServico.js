"use strict";

function get(url, dado, sucesso, falha) {
    $.ajax({
        url: url,
        data: dado,
        success: sucesso,
        error: falha !== undefined ? falha : erro
    });
}

function erro(xhr, status, error) {
    console.log("TODO - implements");
}