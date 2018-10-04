function lerTopico(topico) {
    get("topico", {
        topico: topico
    }, mostrarConteudoTopico);
}

function mostrarConteudoTopico(dado) {
    $("#titulo").html(dado.titulo);
    $("#data").html(dado.dataCriacao);
    $("#conteudo").html(dado.conteudo);
    mostrarComentarios(dado.comentarios)
    paraTopo();
    mudarParaConteudo(true);
}

function mostrarComentarios(comentarios) {
    _.forEach(comentarios, criaComentario);

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

function separa(paraSeparar) {
    return _.words(paraSeparar);
}

function encontra(texto, chave) {
    return !_.isEmpty(_.filter(texto, palavra => palavra === chave));
}