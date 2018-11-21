"use strict";

const ajaxBody = (url, dado, type = "GET", sucesso, falha) => ({
    url: pegaUrl() + url,
    data: dado,
    type: type,
    contentType: "application/json",
    success: sucesso,
    error: falha !== undefined ? falha : erro
});

function get(url, dado, sucesso, falha) {
    $.ajax(ajaxBody(url, dado, "GET", sucesso, falha));
}

function post(url, dado, sucesso, falha) {
    $.ajax(ajaxBody(url, dado, "POST", sucesso, falha));
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