package com.everis.academia.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entity.Cidade;

public interface ICidadeBusiness {

	Cidade create(Cidade cidade) throws BusinessException;
	
	Collection<Cidade> read();
	
	Boolean update(Cidade cidade);
	
	Boolean delete(Cidade cidade);
}
