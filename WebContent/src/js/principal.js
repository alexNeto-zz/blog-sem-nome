function pegaTopicos(identificador) {
    get("topico", {
        qual: todos
    }, (dados) => console.log(dados));
}