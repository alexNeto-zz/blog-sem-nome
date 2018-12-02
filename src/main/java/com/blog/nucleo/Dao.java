package com.blog.nucleo;

import java.util.List;

public interface Dao<T> {

	public T inserir(T t);

	public T encontrarPeloIdentificador(Long identificador);

	public List<T> encontrarTodos();

	public T atualizar(T t);

	public boolean apaga(T t);

	public boolean apagaPeloIdentificador(Long identificador);

}
