package com.blog.autenticacao.cadastro;

import javax.servlet.http.HttpServletRequest;

import com.blog.nucleo.TipoUsuario;
import com.blog.usuario.Usuario;
import com.blog.usuario.UsuarioDao;
import com.blog.usuario.UsuarioDaoJpa;
import com.blog.usuario.UsuarioServico;

public class CadastroServico {

	protected Boolean fazCadastro(HttpServletRequest request) {
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		UsuarioServico usuarioServico = new UsuarioServico();
		UsuarioDao usuarioRepositorio = UsuarioDaoJpa.pegaInstancia();
		Boolean resultado = false;
		if (usuarioServico.encontrar(apelido, senha) == null) {
			Usuario usuario = new Usuario();
			usuario.setApelido(apelido);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setTipoUsuario(TipoUsuario.NORMAL);
			usuarioRepositorio.inserir(usuario);
			request.getSession().setAttribute("apelido", apelido);
			resultado = true;
		}
		return resultado;
	}

}
