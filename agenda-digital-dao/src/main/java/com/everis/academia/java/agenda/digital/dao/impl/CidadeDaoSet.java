package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.everis.academia.java.agenda.digital.dao.inter.ICidadeDAO;
import com.everis.academia.java.agenda.digital.entity.Cidade;

public class CidadeDaoSet implements ICidadeDAO {
	
	private static Set<Cidade> cidades = new HashSet<>();
	
	/* Inicializamos um contador para o código da Cidade */
	private static Integer contadorCodigo = 0;
	
	/* Adicionamos algumas Cidades à lista para para ter dados para usar como exemplo */
	static {
		cidades.add(new Cidade(1,"Lisboa"));
		cidades.add(new Cidade(2, "Porto"));
		
		contadorCodigo = 3;
	}
	
	
	/**
	 * Devolve a lista de Cidades
	 * 
	 * @return
	 */
	public static Set<Cidade> getCidades() {
		return cidades;
	}

	@Override
	public Cidade create(Cidade cidade) {
		
		/* Incrementamos o contador do código da Cidade */
		contadorCodigo++;
		
		/* Adicionamos o código da Cidade ao objecto Cidade */
		cidade.setCodigo(contadorCodigo);
		
		/* Adicionamos a nova Cidade à lista de Cidades */
		cidades.add(cidade);
		
		return cidade;
	}

	@Override
	public Collection<Cidade> read() {
		
		return cidades;
	}

	@Override
	public void update(Cidade cidade) {
		
		for (Cidade cidadeActual : cidades) {
			
			if (cidadeActual.getCodigo() == cidade.getCodigo()) {
				
				cidadeActual.setNome(cidade.getNome());
			}
		}
	}

	@Override
	public void delete(Integer codigo) {
		
		for (Cidade cidadeActual : cidades) {
			
			if (cidadeActual.getCodigo() == codigo) {
				
				cidades.remove(cidadeActual);
				break;
			}
		}
	}
	
	@Override
	public Boolean jaExisteCidadeComNome(Cidade cidade) {
		
		for (Cidade cidadeActual : cidades) {
			
			if (cidadeActual.getNome().equalsIgnoreCase(cidade.getNome())) {
				
				return true;
			}
		}
		
		return false;
	}
}
