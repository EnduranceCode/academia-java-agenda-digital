package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entity.Cidade;

public interface ICidadeDAO {

	/**
	 * Cria e adiciona uma nova cidade à lista de cidades
	 *  
	 * @param cidade
	 * @return
	 */
	Cidade create(Cidade cidade);
	
	/**
	 * Lê a lista de cidades
	 * 
	 * @return
	 */
	Collection<Cidade> read();
	
	/**
	 * Actualiza uma cidade pré-existente na lista de cidades
	 * 
	 * @param cidade
	 */
	void update(Cidade cidade);
	
	/**
	 * Elimina uma cidade na lista de cidades
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo);
	
	/**
	 * Verifica se já existe na lista de cidades uma cidade com o nome fornecido
	 * 
	 * @param nome
	 * @return
	 */
	Boolean jaExisteCidadeComNome(Cidade cidade);
}
