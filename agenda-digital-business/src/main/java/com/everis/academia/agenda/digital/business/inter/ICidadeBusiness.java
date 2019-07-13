package com.everis.academia.agenda.digital.business.inter;

import java.util.Collection;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.entity.Cidade;

public interface ICidadeBusiness {

	/**
	 * Cria e adiciona uma nova Cidade
	 *  
	 * @param cidade
	 * @return
	 * @throws BusinessException
	 */
	Cidade create(Cidade cidade) throws BusinessException;
	
	/**
	 * Lê a lista de Cidades
	 * 
	 * @return
	 */
	Collection<Cidade> read();
	
	/**
	 * Actualiza uma Cidade pré-existente
	 * 
	 * @param cidade
	 * @throws BusinessException
	 */
	void update(Cidade cidade) throws BusinessException;
	
	/**
	 * Elimina uma Cidade referenciada pelo código
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo) throws BusinessException;
}
