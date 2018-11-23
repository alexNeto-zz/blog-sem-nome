package com.blog.utilitario;

import java.io.PrintWriter;

public class RespostaPadrao {

	public static void json(PrintWriter resposta) {
		PrintWriter returno = resposta;
		returno.print("{\"status\": 200}");
		returno.flush();
	}
}
