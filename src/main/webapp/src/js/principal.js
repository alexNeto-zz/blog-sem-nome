"use strict";

function paraTopo() {
  window.scrollTo(0, 0);
}

function encontra(texto, chave) {
  return texto.indexOf(chave) !== -1 ? true : false;
}

function mostrarAreaDeComentar() {
  document.getElementById("comentar").hidden = !document.getElementById(
    "comentar"
  ).hidden;
}

function comentar() {
  post("comentario", pegaComentario(), sucesso);

  function sucesso(dado) {
    limpaComentario();
    location.reload();
  }

  function falha() {
    limpaComentario();
  }

  function limpaComentario() {
    document.getElementById("texto-comentario").value = "";
  }

}

function pegaComentario() {
  return {
    conteudo: censura(document.getElementById("texto-comentario").value),
    identificadorTopico: pegaIdentificadorTopico()
  };
}

function pegaIdentificadorTopico() {
  let url = new URL(window.location.href);
  return url.searchParams.get("topico");
}


function podeEditar() {
  return $("#comentarios").html() === "";
}

function editarTopico() {
  document.getElementById("titulo-edicao").value = document.getElementById(
    "titulo"
  ).innerHTML;
  document.getElementById("texto-topico").value = document.getElementById(
    "conteudo"
  ).innerHTML;
  mostrarCamposEdicaoTopico(true);
}

function mostrarCamposEdicaoTopico(mostrar) {
  document.getElementById("topico-estatico").hidden = mostrar;
  document.getElementById("topico-editavel").hidden = !mostrar;
}

function cancelarEdicao() {
  mostrarCamposEdicaoTopico(false);
}

/***********************************************/
/*************** EVENTOS ***********************/
/***********************************************/

function voltar() {
  const botalVoltar = document.getElementById("botao-voltar");
  if (botalVoltar != undefined) // só 1 igual para pegar null também
    botalVoltar.onclick = () => (window.history.back());
}

// definição dos eventos devem ir a cima 
window.onload = () => (
  voltar()
);