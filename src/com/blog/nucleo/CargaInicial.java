package com.blog.nucleo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.blog.comentario.Comentario;
import com.blog.comentario.ComentarioDao;
import com.blog.comentario.ComentarioDaoJpa;
import com.blog.topico.Topico;
import com.blog.topico.TopicoDao;
import com.blog.topico.TopicoDaoJpa;
import com.blog.usuario.Usuario;
import com.blog.usuario.UsuarioDao;
import com.blog.usuario.UsuarioDaoJpa;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

@WebFilter("/*")
public class CargaInicial implements Filter {

	private boolean rodouCargaInicial = false;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		if (!rodouCargaInicial)
			rodarCargaInicial();

		arg2.doFilter(arg0, arg1);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	private void rodarCargaInicial() {
		try {
			criaUsuariosDeTeste();
			criaTopicosDeTeste();
			rodouCargaInicial = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void criaTopicosDeTeste() throws InterruptedException {
		Lorem lorem = LoremIpsum.getInstance();
		TopicoDao topicoRepositorio = TopicoDaoJpa.pegaInstancia();
		ComentarioDao comentarioRepositorio = ComentarioDaoJpa.pegaInstancia();
		if (topicoRepositorio.encontrarTodos().size() > 10)
			return;
		for (int i = 0; i < 12; i++) {
			Topico topico = new Topico();
			topico.setConteudo(lorem.getWords(100, 1000));
			topico.setTitulo(lorem.getWords(4, 7));
			topico.setDataCriacao(new Date().toString());
			topicoRepositorio.inserir(topico);
			Thread.sleep(500);
			for (int j = 0; j < 3; j++) {
				Comentario comentario = new Comentario();
				comentario.setIdentificadorTopico(topico.getIdentificador());
				comentario.setApelido("nome");
				comentario.setDataCriacao(new Date());
				comentario.setConteudo(lorem.getWords(2, 100));
				comentarioRepositorio.inserir(comentario);
				Thread.sleep(500);
			}
		}
	}

	private void criaUsuariosDeTeste() throws InterruptedException {
		UsuarioDao usuarioRepositorio = UsuarioDaoJpa.pegaInstancia();
		Usuario usuario = new Usuario();
		usuario.setApelido("nome");
		usuario.setEmail("email@teste.com");
		usuario.setSenha("hunter2");
		usuario.setTipoUsuario(TipoUsuario.NORMAL);
		usuarioRepositorio.inserir(usuario);
		Thread.sleep(500);
		usuario = new Usuario();
		usuario.setApelido("algo");
		usuario.setEmail("algo@email.com");
		usuario.setSenha("hunter2");
		usuario.setTipoUsuario(TipoUsuario.ADM);
		usuarioRepositorio.inserir(usuario);
	}

}
