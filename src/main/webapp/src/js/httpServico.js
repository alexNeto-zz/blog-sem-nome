"use strict";

function get(url, dado, sucesso, falha) {
    consola(url);
    $.ajax({
        url: pegaUrl() + url,
        data: dado,
        type: "GET",
        success: sucesso,
        error: falha !== undefined ? falha : erro
    });
}

function post(url, dado, sucesso, falha) {
    consola(url);
    $.ajax({
        url: pegaUrl() + url,
        data: dado,
        type: "POST",
        success: sucesso,
        error: falha !== undefined ? falha : erro
    });
}

function consola(url) {
    console.log(pegaUrl() + url)
}

function erro(xhr, status, error) {
    console.log("TODO - implements");
    console.log(xhr, status, error);
}

function pegaUrl() {
    return window.location.protocol + "//" + window.location.host + "/blog/";
}