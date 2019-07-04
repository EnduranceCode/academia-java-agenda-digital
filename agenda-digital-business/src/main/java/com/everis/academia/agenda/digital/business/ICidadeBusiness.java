package com.everis.academia.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entity.Cidade;

public interface ICidadeBusiness {

	/**
	 * Cria e adiciona uma nova cidade à lista de cidades
	 *  
	 * @param cidade
	 * @return
	 * @throws BusinessException
	 */
	Cidade create(Cidade cidade) throws BusinessException;
	
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
	 * @throws BusinessException
	 */
	void update(Cidade cidade) throws BusinessException;
	
	/**
	 * Elimina uma cidade na lista de cidades
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo);
}
