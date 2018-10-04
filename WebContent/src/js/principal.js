let identificadorTopico = undefined;

function lerTopico(topico) {
    get("topico", {
        topico: topico
    }, mostrarConteudoTopico);
}

function mostrarConteudoTopico(dado) {
    $("#titulo").html(dado.titulo);
    $("#data").html(dado.dataCriacao);
    $("#conteudo").html(dado.conteudo);
    identificadorTopico = dado.identificador;
    mostrarComentarios(dado.comentarios)
    paraTopo();
    mudarParaConteudo(true);
}

function mostrarComentarios(comentarios) {
    _.forEachRight(comentarios, criaComentario);

    function criaComentario(comentario) {
        $("#comentarios").append(pegaComentario(comentario));
    }

    function pegaComentario(comentario) {
        return `<section class="borda margem-conteudo-principal comentario">
	        <h1>${comentario.apelido}</h1>
	        <h2>${comentario.dataCriacao}</h2>
	        <p>${comentario.conteudo}</p>
	    </section>`;
    }
}


function voltarParaListagem() {
    mudarParaConteudo(false);
    $("#comentarios").empty();
    paraTopo();
}

function mudarParaConteudo(estaVisivel) {
    document.getElementById("listagem-topico").hidden = estaVisivel;
    document.getElementById("conteudo-topico").hidden = !estaVisivel;
}

function paraTopo() {
    window.scrollTo(0, 0);
}

function encontra(texto, chave) {
    return texto.indexOf(chave) !== -1 ? true : false;
}

function mostrarAreaDeComentar() {
    document.getElementById("comentar").hidden = !document.getElementById("comentar").hidden;
}


function comentar() {

    post("comentario", pegaComentario(), sucesso);

    function sucesso(dado) {
        document.getElementById("texto-comentario").value = undefined;
        location.reload();
        mudarParaConteudo(true);
        paraTopo();
    }
}

function pegaComentario(){
    console.log({
        conteudo: document.getElementById("texto-comentario").value,
        identificadorTopico: identificadorTopico
    });
    return {
        conteudo: document.getElementById("texto-comentario").value,
        identificadorTopico: identificadorTopico
    };
}