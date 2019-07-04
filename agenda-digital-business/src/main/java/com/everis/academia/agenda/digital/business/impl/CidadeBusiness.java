package com.everis.academia.agenda.digital.business.impl;

import java.util.Collection;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO;
import com.everis.academia.java.agenda.digital.entity.Cidade;

public class CidadeBusiness implements ICidadeBusiness {
	
	/* Instanciamos um novo objecto CidadeDAO */
	private ICidadeDAO cidadeDAO = new CidadeDAO();

	@Override
	public Cidade create(Cidade cidade) throws BusinessException {
		
		/* Verificamos se os dados recebidos não estão vazios */
		if (cidade.getNome() == null ||  cidade.getNome().trim().isEmpty()) {
			
			throw new BusinessException("Não foram recebidos dados");
		}
		
		/* Verificamos se a cidade já existe */
		if (cidadeDAO.jaExisteCidadeComNome(cidade.getNome())) {
			
			throw new BusinessException("A cidade já existe");
		}
		
		/* Feita a validação dos dados recebidos, criamos uma nova cidade */
		return cidadeDAO.create(cidade);
	}

	@Override
	public Collection<Cidade> read() {
		
		return cidadeDAO.read();
	}

	@Override
	public void update(Cidade cidade) throws BusinessException {
		
		/* Verificamos se os dados recebidos não estão vazios */
		if (cidade.getNome() == null ||  cidade.getNome().trim().isEmpty()) {
			
			throw new BusinessException("Não foram recebidos dados");
		}
		
		/* Verificamos se a cidade já existe */
		for (Cidade cidadeActual : cidadeDAO.read()) {
			
			if (cidadeActual.getCodigo() == cidade.getCodigo() && cidadeActual.getNome().equals(cidade.getNome())) {
				
				/* Não foram introduzidas alterações aos dados pré-existentes e assim retornamos à origem */
				return;
			}
		}
		
		/* Verificamos se a cidade já existe */
		if (cidadeDAO.jaExisteCidadeComNome(cidade.getNome())) {
			
			throw new BusinessException("A cidade já existe");
		}

		/* Feita a validação dos dados recebidos, actualizamos a cidade */
		cidadeDAO.update(cidade);
	}

	@Override
	public void delete(Integer codigo) {
		
		cidadeDAO.delete(codigo);
	}
}
