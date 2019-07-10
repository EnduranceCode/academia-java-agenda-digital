package com.everis.academia.java.agenda.digital.dao.inter;

import java.util.List;

import com.everis.academia.java.agenda.digital.entity.Telefone;

public interface ITelefoneDAO {

	/**
	 * Cria um novo objecto Telefone e devolve-o numa lista
	 * 
	 * @param telefone
	 * @return
	 */
	Telefone create(Telefone telefone);

	/**
	 * Lê a lista de telefones e devolve-a
	 * 
	 * @return
	 */
	List<Telefone> read();

	/**
	 * Actualiza o telefone recebido na lista de telefones existentes
	 * 
	 * @param telefone
	 */
	void update(Telefone telefone);

	/**
	 * Elimina na lista de telefones existentes o telefone recebido
	 * 
	 * @param codigo
	 */
	void delete(Integer codigo);

	/**
	 * Verifica se existe na lista de telefones um telefone com o mesmo número
	 * 
	 * @param telefone
	 * @return
	 */
	Boolean jaExisteEsteTelefone(Telefone telefone);
}
