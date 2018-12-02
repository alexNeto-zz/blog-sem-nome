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
  return $("comentarios").html() == undefined;
}

function editarTopico() {
  painelEdicao();
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

function enviarTopico() {
  const dado = {
    identificador: pegaIdentificadorTopico(),
    titulo: censura(document.getElementById("titulo-edicao").value),
    conteudo: censura(document.getElementById("texto-topico").value)
  };
  if (podeEditar()) post("restrito/gerenciar/topico/edicao", dado, sucesso);
}

function sucesso(dado) {
  location.reload();
}

function painelEdicao() {
  const topicoEditavel = document.getElementById("topico-editavel");

  topicoEditavel.innerHTML = `
    <section class="margem-conteudo-principal borda topicos">
    <article class="borda">
        <div class="conteudo">
            <input type="text" name="titulo" id="titulo-edicao" placeholder="Título">
            <textarea name="texto-comentario" id="texto-topico" placeholder="Escreva algo..."></textarea>
        </div>
        <div class="botao-ler">
            <button id="formulario-comentar" class="botao borda botao-header" onclick="cancelarEdicao()">Cancelar</button>
            <button id="formulario-comentar" class="botao borda botao-header" onclick="enviarTopico()">Enviar</button>
        </div>
    </article>
    </section>
    `;
}

function apagarComentario(identificador) {
  post("restrito/gerenciar/comentario/apagar", pegaDados(), sucesso)

  function pegaDados() {
    return {
      identificador: identificador
    };
  }
}