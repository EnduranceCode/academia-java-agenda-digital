package com.everis.academia.java.agenda.digital.dao.inter;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entity.Cidade;

public interface ICidadeDAO {

	/**
	 * Cria e adiciona uma nova Cidade à lista de Cidades
	 *  
	 * @param cidade
	 * @return
	 */
	Cidade create(Cidade cidade);
	
	/**
	 * Lê a lista de Cidades
	 * 
	 * @return
	 */
	Collection<Cidade> read();
	
	/**
	 * Actualiza uma Cidade pré-existente na lista de Cidades
	 * 
	 * @param cidade
	 */
	void update(Cidade cidade);
	
	/**
	 * Elimina uma cidade na lista de Cidades
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo);
	
	/**
	 * Verifica se já existe na lista de Cidades uma Cidade com o nome fornecido
	 * 
	 * @param nome
	 * @return
	 */
	Boolean jaExisteCidadeComNome(Cidade cidade);
	
	/**
	 * Devolve o nome da cidade com o código fornecido
	 * 
	 * @param codigo
	 * @return
	 */
	String getNomeCidade(Integer codigo);
}
