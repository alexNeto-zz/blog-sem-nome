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
    mostrarTopico();
}

function mostrarTopico() {
    mudarParaConteudo(true);
    paraTopo();
}

function mostrarComentarios(comentarios) {
    _.forEachRight(comentarios, criaComentario);

    function criaComentario(comentario) {
        $("#comentarios").append(pegaComentario(comentario));
    }

    function pegaComentario(comentario) {
        return `<article class="borda">
			        <div class="conteudo">
                        <h2 id="apelido-comentario">${comentario.apelido}</h2>
                        <h3>${comentario.dataCriacao}</h3>
                        <p>${comentario.conteudo}</p>
					</div>
					${botaoComentario(comentario.identificador, comentario.apelido)}
				</article>`;
    }

    function botaoComentario(identificador, apelidoComentario) {
        let botaoApagarComentario = "";
        const apelido = document.getElementById("apelido").innerHTML;
        if (apelido === apelidoComentario || document.getElementById("administrador") !== undefined)
            return `<div class="botao-ler">
                        <button type="submit" class="botao borda botao-header" onclick="apagarComentario(${identificador})">Apagar</button>
                    </div>`;
        return botaoApagarComentario;
    }
}

function apagarComentario(identificador) {
    get("comentario", {
        identificador: identificador
    }, sucesso);

    function sucesso(dado) {
        location.reload();
        mostrarTopico();
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
        document.getElementById("texto-comentario").value = "";
        location.reload();
        mostrarTopico();
    }
}

function pegaComentario() {
    console.log({
        conteudo: document.getElementById("texto-comentario").value,
        identificadorTopico: identificadorTopico
    });
    return {
        conteudo: document.getElementById("texto-comentario").value,
        identificadorTopico: identificadorTopico
    };
}