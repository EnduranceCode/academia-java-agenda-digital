package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.inter.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.entity.PrestadorServico;

@Repository
public class PrestadorServicoDAO implements IPrestadorServicoDAO {

	private static List<PrestadorServico> prestadoresServico = new ArrayList<PrestadorServico>();
	
	/* Inicializamos um contador para o código do PrestadorServico */
	/* TODO: Implementar o código do PrestadorServico com a Base de Dados */
	private static Integer contadorCodigo = 0;

	/*
	 * Adicionamos alguns objectos PrestadorServico à lista para para ter dados para
	 * usar como exemplo
	 */
	/* TODO: Eliminar depois de adicionada a Base de Dados */
	static {

		contadorCodigo = 3;
	}

	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrestadorServico> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PrestadorServico prestadorServico) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean jaExistePrestadorComNome(PrestadorServico prestadorServico) {
		// TODO Auto-generated method stub
		return null;
	}

}
