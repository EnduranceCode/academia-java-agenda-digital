package com.everis.academia.agenda.digital.business.inter;

import java.util.List;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.entity.TipoServico;

public interface ITipoServicoBusiness {

	/**
	 * Cria e adiciona um novo Tipo de Serviço
	 *  
	 * @param tipoServiço
	 * @return
	 */
	TipoServico create(TipoServico tipoServico) throws BusinessException;
	
	/**
	 * Obtêm a lista de Tipo de Serviços
	 * 
	 * @return
	 */
	List<TipoServico> read();
	
	/**
	 * Actualiza um Tipo de Serviço já existente
	 * 
	 * @param tipoServico
	 */
	void update(TipoServico tipoServico) throws BusinessException;
	
	/**
	 * Elimina um Tipo de Serviço existente
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo);
}
