package com.everis.academia.agenda.digital.business.inter;

import java.util.List;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.entity.Telefone;

public interface ITelefoneBusiness {

	/**
	 * Cria e adiciona um novo telefone à lista de cidades
	 *  
	 * @param telefone
	 * @return
	 * @throws BusinessException
	 */
	Telefone create(Telefone telefone) throws BusinessException;
	
	/**
	 * Lê a lista de telefones
	 * 
	 * @return
	 */
	List<Telefone> read();
	
	/**
	 * Actualiza telefone pré-existente na lista de telefones
	 * 
	 * @param telefone
	 * @throws BusinessException
	 */
	void update(Telefone telefone) throws BusinessException;
	
	/**
	 * Elimina um telefone na lista de telefones
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo);
}
