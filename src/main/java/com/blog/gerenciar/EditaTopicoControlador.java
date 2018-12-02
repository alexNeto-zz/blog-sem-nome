package com.blog.gerenciar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.topico.Topico;
import com.blog.topico.TopicoServico;
import com.blog.utilitario.RespostaPadrao;

@WebServlet("/restrito/gerenciar/topico/edicao")
public class EditaTopicoControlador extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8792656053291940932L;

	@Override
	protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {

		Topico topico = new Topico();
		topico.setIdentificador(Long.valueOf(requisicao.getParameter("identificador")));
		topico.setConteudo(requisicao.getParameter("conteudo"));
		topico.setTitulo(requisicao.getParameter("titulo"));
		new TopicoServico().atualizaTopico(topico);
		resposta.setContentType("application/json");
		resposta.setStatus(200);
		RespostaPadrao.json(resposta.getWriter());

	}
}
