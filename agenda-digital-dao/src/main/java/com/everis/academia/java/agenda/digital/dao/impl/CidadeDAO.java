package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.entity.Cidade;

public class CidadeDAO implements ICidadeDAO {
	
	private static Set<Cidade> cidades = new HashSet<>();
	
	/* Inicializar um contador para o código da cidade */
	private static Integer contadorCodigo = 0;
	
	/* Adicionamos algumas cidades à lista para para ter dados para usar como exemplo */
	static {
		cidades.add(new Cidade(1,"Lisboa"));
		cidades.add(new Cidade(2, "Porto"));
		
		contadorCodigo = 3;
	}
	
	
	/**
	 * Devolve a lista de cidades
	 * 
	 * @return
	 */
	public static Set<Cidade> getCidades() {
		return cidades;
	}

	@Override
	public Cidade create(Cidade cidade) {
		
		/* Incrementamos o contador do código da cidade */
		contadorCodigo++;
		
		/* Adicionamos o código da cidade ao objecto cidade */
		cidade.setCodigo(contadorCodigo);
		
		/* Adicionamos a nova cidade à lista de cidades */
		cidades.add(cidade);
		
		return cidade;
	}

	@Override
	public Collection<Cidade> read() {
		
		return cidades;
	}

	@Override
	public Boolean delete(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Boolean jaExisteCidadeComNome(String nome) {
		
		for (Cidade cidadeActual : cidades) {
			
			if (cidadeActual.getNome().equalsIgnoreCase(nome)) {
				
				return true;
			}
		}
		
		return false;
	}
}
