package com.everis.academia.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entity.Cidade;

public interface ICidadeBusiness {

	Boolean create(Cidade cidade);
	
	Collection<Cidade> read();
	
	Boolean update(Cidade cidade);
	
	Boolean delete(Cidade cidade);
}
