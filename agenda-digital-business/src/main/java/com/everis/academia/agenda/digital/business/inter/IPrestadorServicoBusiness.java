package com.everis.academia.agenda.digital.business.inter;

import java.util.List;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.entity.PrestadorServico;

public interface IPrestadorServicoBusiness {

	/**
	 * Cria e adiciona um novo Prestador de Serviços
	 *  
	 * @param prestadorServico
	 * @return
	 * @throws BusinessException
	 */
	PrestadorServico create(PrestadorServico prestadorServico) throws BusinessException;
	
	/**
	 * Lê e devolve a lista de Prestadores de Serviço existentes
	 * 
	 * @return
	 */
	List<PrestadorServico> read();
	
	/**
	 * Actualiza um Prestador de Serviço pré-existente
	 * 
	 * @param prestadorServico
	 * @throws BusinessException
	 */
	void update(PrestadorServico prestadorServico) throws BusinessException;
	
	/**
	 * Elimina um Prestador de Serviços referenciado pelo código
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo) throws BusinessException;
}
