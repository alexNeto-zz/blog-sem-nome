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
    paraTopo();
    mudarParaConteudo(true);
}

function voltarParaListagem() {
    mudarParaConteudo(false);
    paraTopo();
}

function mudarParaConteudo(estaVisivel) {
    document.getElementById("listagem-topico").hidden = estaVisivel;
    document.getElementById("conteudo-topico").hidden = !estaVisivel;
}

function paraTopo(){
    window.scrollTo(0, 0);
}