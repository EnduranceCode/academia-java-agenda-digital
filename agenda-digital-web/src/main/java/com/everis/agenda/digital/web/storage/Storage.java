package com.everis.agenda.digital.web.storage;

import java.util.HashSet;
import java.util.Set;

import com.everis.academia.java.agenda.digital.entity.Cidade;

public class Storage {
	
	private static Set<Cidade> cidades = new HashSet<>();
	
	/*
	 * Adicionamos algumas cidades à lista para para ter dados para usar como exemplo
	 */
	static {
		cidades.add(new Cidade(1,"Lisboa"));
		cidades.add(new Cidade(2, "Porto"));
	}
	
	/**
	 * Devolve a lista de cidades
	 * 
	 * @return
	 */
	public static Set<Cidade> getCidades() {
		return cidades;
	}

	/**
	 * Insere uma nova cidade na lista de cidades
	 * 
	 * @param codigo
	 * @param cidade
	 */
	public static Cidade inserirCidade(String cidade) {
		Integer codigo = cidades.size() + 1;
		cidades.add(new Cidade(codigo, cidade));
		
		Cidade cidadeNova = new Cidade(codigo, cidade);
		
		return cidadeNova;
	}
	
	public static void actualizarCidade(Integer codigo, String cidade) {
		
		for (Cidade cidadeActual : cidades) {
			
			if (cidadeActual.getCodigo() == codigo) {
				
				cidadeActual.setNome(cidade);
			}
		}
	}
	
	public static void apagarCidade(String cidade) {
		
		for (Cidade cidadeActual : cidades) {
			
			if (cidadeActual.getNome().equals(cidade)) {
				
				cidades.remove(cidadeActual);
			}
		}
	}
}
