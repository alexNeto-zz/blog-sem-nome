package com.blog.gerenciar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.topico.Topico;
import com.blog.topico.TopicoDaoJpa;
import com.blog.utilitario.RespostaPadrao;

@WebServlet("/restrito/gerenciar/topico")
public class GerenciadorTopicoControlador extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8792656053291940932L;

	@Override
	protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		TopicoDaoJpa.pegaInstancia().apagaPeloIdentificador(Long.valueOf(requisicao.getParameter("identificador")));
		resposta.setStatus(200);
	}

	@Override
	protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		Topico topico = new Topico();
		topico.setConteudo(requisicao.getParameter("conteudo"));
		topico.setTitulo(requisicao.getParameter("titulo"));
		resposta.setContentType("application/json");
		RespostaPadrao.json(resposta.getWriter());
		TopicoDaoJpa.pegaInstancia().inserir(topico);

	}
}
