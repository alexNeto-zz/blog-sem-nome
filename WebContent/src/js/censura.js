const palavroes = [
    "alienado", "animaldeteta", "anormal", "argentino", "arregassado", "arrombado",
    "babaca", "baitola", "baleia", "barril", "benfiquista", "biba", "bicha", "bios",
    "biroska", "bobo", "bocal", "bolagato", "boqueteiro", "bosta", "buceta", "bundao",
    "burro", "cabaco", "cacete", "cadelona", "cafona", "cambista", "capiroto", "caralho",
    "catraia", "cepo", "cocodrilo", "cocozento", "cu", "debilmental", "demente", "desciclope",
    "desgracado", "drogado", "eguenorante", "endemoniado", "energumeno", "enfianocu",
    "engolerola", "escroto", "esdruxulo", "esporrado", "estigalhado", "estrume", "estrunxado",
    "estupido", "fdp", "fidumaegua", "filhodaputa", "fiofo", "foda", "fuder", "fudido",
    "fulera", "galinha", "gambiarra", "geisyarruda", "gnu", "gonorreia", "gordoescroto",
    "gozado", "herege", "idiota", "ignorante", "imbecil", "imundo", "inascivel", "inseto",
    "invertebrado", "jacu", "jegue", "jumento", "kct", "komodo", "ku", "lazarento", "lazaro",
    "leproso", "lerdo", "lesma", "lezado", "lico", "limpezaanal", "lixo", "lombriga", "macaco",
    "marimoon", "merda", "meretriz", "miolodecu", "mocorongo", "montedemerda", "morfetico",
    "mulambo", "n00b", "nazista", "nerd", "newbie", "nhaca", "nonsense", "ogro", "olhodocu",
    "olhogordo", "otario", "palhaco", "panaca", "paraguaio", "passaralho", "paunocu", "periquita",
    "pimenteira", "pipoca", "piranha", "piroca", "pistoleira", "porra", "prostituta", "punheta",
    "puta", "putaquepariu", "quasimodo", "quenga", "quirguistao", "rampero", "rapariga", "raspadinha",
    "retardado", "rusguento", "sanguesuga", "sujo", "tapado", "tarado", "tesao", "tetuda", "tetudo",
    "tosco", "tragado", "travesti", "trepadeira", "troglodita", "urubu", "vaca", "vadia", "vagabundo",
    "vagaranha", "vaiamerda", "vaisefuder", "vaitomarnocu", "vascaino", "verme", "viado", "xavasca",
    "xereca", "xixizento", "xoxota", "xupetinha", "xupisco", "xurupita", "xuxexo", "xxt", "xxx",
    "zebuceta", "ziguizira", "zina", "zoado", "zoiudo", "zoneira", "zuado", "zuera", "zulu", "zureta"
];

function censura(texto) {
    return _.join(_.map(_.words(texto), achaPalavrao), " ");

    function achaPalavrao(palavra) {
        return ePalavrao(palavra) ? _.pad('', palavra.length, "*") : palavra;
    }

    function ePalavrao(palavra) {
        return _.filter(palavroes, (palavrao) => _.toLower(palavrao) === palavra).length > 0;
    }
}