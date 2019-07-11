package com.everis.academia.java.agenda.digital.dao.inter;

import java.util.List;

import com.everis.academia.java.agenda.digital.entity.PrestadorServico;

public interface IPrestadorServicoDAO {
	
	/**
	 * Cria um novo objecto PrestadorServico e devolve-o à invocação
	 * 
	 * @param prestadorServico
	 * @return
	 */
	PrestadorServico create(PrestadorServico prestadorServico);
	
	/**
	 * Devolve uma lista com os objectos PrestadorServico existentes
	 * 
	 * @return
	 */
	List<PrestadorServico> read();
	
	/**
	 * Actualiza um objecto PrestadorServico existente
	 * 
	 * @param prestadorServico
	 */
	void update(PrestadorServico prestadorServico);
	
	/**
	 * Elimina um objecto PrestadorServico, referenciado pelo código, existente
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo);
	
	/**
	 * Verifica se já existe um objecto PrestadorServico com o mesmo nome
	 * 
	 * @param prestadorServico
	 * @return
	 */
	Boolean jaExistePrestadorComNome(PrestadorServico prestadorServico);
}
