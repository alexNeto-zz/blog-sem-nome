<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PT" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8">

	<link href="https://fonts.googleapis.com/css?family=Gilda+Display" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet">

	<script src="https://cdn.jsdelivr.net/lodash/4/lodash.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.0.js"></script>

	<link rel="stylesheet" href="./src/css/reset.css">
	<link rel="stylesheet" href="./src/css/master.css">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/x-icon" href="favicon.ico">
    <title>Autenticacao | Locadora Sem Nome</title>
</head>

<body>
    <section id="form-autenticacao">
        <form action="/locadora/cadastrar" method="post">
            <div>
                <label for="nome-usuario">Nome de Usuário</label>
                <input type="text" name="nomeUsuario" id="nome-usuario" placeholder="Nome de Usuário">
            </div>
            <div>
                <label for="senha">Senha</label>
                <input type="password" name="senha" id="senha" placeholder="Senha">
            </div>
            <div>
                <button onclick="location.href='/locadora/cadastrar'">Voltar</button>
                <button type="submit">Cadastrar</button>
            </div>
        </form>
    </section>
</body>

</html>