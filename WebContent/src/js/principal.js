function lerTopico(topico) {
    get(
        "topico", {
            topico: topico
        },
        mostrarConteudoTopico
    );
}

function mostrarConteudoTopico(dado) {
    $("#titulo").html(dado.titulo);
    $("#data").html(dado.dataCriacao);
    $("#conteudo").html(dado.conteudo);
    window.scrollTo(0, 0);
    mudarParaConteudo(true);
}

function voltarParaListagem() {
    mudarParaConteudo(false);
}

function mudarParaConteudo(estaVisivel) {
    document.getElementById("listagem-topico").hidden = estaVisivel;
    document.getElementById("conteudo-topico").hidden = !estaVisivel;
}