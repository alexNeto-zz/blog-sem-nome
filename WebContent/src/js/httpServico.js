"use strict";

function get(url, sucesso, falha) {
    console.log(pegaUrl());
    $.ajax({
        url: pegaUrl() + url,
        type: "GET",
        success: sucesso,
        error: falha !== undefined ? falha : erro
    });
}

function post(url, dado, sucesso, falha) {
    console.log(pegaUrl());
    $.ajax({
        url: pegaUrl() + url,
        data: dado,
        type: "POST",
        success: sucesso,
        error: falha !== undefined ? falha : erro
    });
}

function erro(xhr, status, error) {
    console.log("TODO - implements");
    console.log(xhr, status, error);
}

function pegaUrl() {
    return window.location.protocol +
        "//" +
        window.location.host +
        window.location.pathname;
}