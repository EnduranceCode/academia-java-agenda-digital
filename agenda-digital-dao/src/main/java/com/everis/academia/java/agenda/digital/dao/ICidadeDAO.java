package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entity.Cidade;

public interface ICidadeDAO {

	Cidade create(Cidade cidade);
	
	Collection<Cidade> read();
	
	Boolean delete(Cidade cidade);
	
	Boolean update(Cidade cidade);
	
	Boolean jaExisteCidadeComNome(String nome);
}
