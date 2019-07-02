package com.everis.agenda.digital.web.storage;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;

import com.everis.academia.java.agenda.digital.entity.Cidade;

/*
 * TODO: Implementar o m�todo apagarCidade() usando o c�digo da cidade
 *
 */

public class Storage {
	
	private static Set<Cidade> cidades = new HashSet<>();
	
	/* Inicializar um contador para o c�digo da cidade */
	private static Integer contadorCodigo = 0;
	
	/* Adicionamos algumas cidades � lista para para ter dados para usar como exemplo */
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
	
	public static void validarCidade(String cidade) throws ServletException {
		
		/* Verifica se os dados recebidos n�o est�o vazios */
		if (cidade.isEmpty()) {
			
			throw new ServletException("N�o foram recebidos dados");
		}
		
		for (Cidade cidadeActual : cidades) {
			
			if (cidadeActual.getNome().equals(cidade)) {
				
				throw new ServletException("A cidade j� existe");
			}
		}
	}

	/**
	 * Insere uma nova cidade na lista de cidades
	 * 
	 * @param codigo
	 * @param cidade
	 */
	public static Cidade inserirCidade(String cidade) {
		
		Cidade cidadeNova = new Cidade(contadorCodigo, cidade);
		cidades.add(cidadeNova);
		
		/* Incrementa o contador do c�digo para ser usado na inser��o seguinte */
		contadorCodigo++;
		
		return cidadeNova;
	}
	
	/**
	 * Actualiza os dados de uma cidade existente
	 * 
	 * @param codigo
	 * @param cidade
	 */
	public static void actualizarCidade(Integer codigo, String cidade) {
		
		for (Cidade cidadeActual : cidades) {
			
			if (cidadeActual.getCodigo() == codigo) {
				
				cidadeActual.setNome(cidade);
			}
		}
	}
	
	/**
	 * Elimina uma cidade existente
	 * 
	 * @param cidade
	 */
	public static void apagarCidade(String cidade) {
		
		for (Cidade cidadeActual : cidades) {
			
			if (cidadeActual.getNome().equals(cidade)) {
				
				cidades.remove(cidadeActual);
				break;
			}
		}
	}
}
