package com.everis.academia.java.agenda.digital.dao.inter;

import java.util.List;

import com.everis.academia.java.agenda.digital.entity.TipoServico;

public interface ITipoServicoDAO {

	/**
	 * Cria e adiciona um novo Tipo de Serviço
	 *  
	 * @param tipoServiço
	 * @return
	 */
	TipoServico create(TipoServico tipoServico);
	
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
	void update(TipoServico tipoServico);
	
	/**
	 * Elimina um Tipo de Serviço existente
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo);
	
	/**
	 * Verifica se já existe um Tipo de Serviço
	 * 
	 * @param tipoServico
	 * @return
	 */
	Boolean jaExisteTipoServico(TipoServico tipoServico);
}
