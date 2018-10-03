package com.blog.nucleo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/usuario/*")
public class FiltroAplicacao implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String loginURI = request.getContextPath() + "/autenticacao";

		boolean loggedIn = session != null && session.getAttribute("nomeUsuario") != null;
		boolean loginRequest = request.getRequestURI().equals(loginURI);

		if (loggedIn || loginRequest) {
			// request.setCharacterEncoding("UTF-8");
			chain.doFilter(request, response);
		} else {
			// response.sendRedirect(loginURI);
			System.out.println("iiiiiiiiii parece vc n ta logado");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	// ...
}