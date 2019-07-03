package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entity.Cidade;

public interface ICidadeDAO {

	Cidade create(Cidade cidade);
	
	Collection<Cidade> read();
	
	void update(Cidade cidade);
	
	void delete(Integer codigo);
	
	Boolean jaExisteCidadeComNome(String nome);
}
