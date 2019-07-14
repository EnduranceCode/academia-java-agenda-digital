package com.everis.academia.agenda.digital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.dao.inter.ICidadeDAO;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@Service
public class CidadeBusiness implements ICidadeBusiness {

	/* Instanciamos um novo objecto CidadeDAO */
	@Autowired
	private ICidadeDAO cidadeDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Cidade create(Cidade cidade) throws BusinessException {

		/* Verificamos se os dados recebidos não estão vazios */
		if (dadosNulos(cidade)) {

			throw new BusinessException("Não foram recebidos dados");
		}

		/* Verificamos se a Cidade já existe */
		if (cidadeDAO.jaExisteCidadeComNome(cidade)) {

			throw new BusinessException("A cidade já existe");
		}

		/* Feita a validação dos dados recebidos, criamos uma nova Cidade */
		return cidadeDAO.create(cidade);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cidade> read() {

		return cidadeDAO.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Cidade cidade) throws BusinessException {

		/* Verificamos se os dados recebidos não estão vazios */
		if (dadosNulos(cidade)) {

			throw new BusinessException("Não foram recebidos dados");
		}

		/* Verificamos se a Cidade já existe */
		if (cidadeDAO.jaExisteCidadeComNome(cidade)) {

			throw new BusinessException("A cidade já existe");
		}

		/* Feita a validação dos dados recebidos, actualizamos a Cidade */
		cidadeDAO.update(cidade);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer codigo) throws BusinessException {
		
		/* Verificamos se o código recebido é invalido */ 
		if(codigoInvalido(codigo)) {
			 
			 throw new BusinessException("O código recebido não é válido");
		 }
		
		cidadeDAO.delete(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public String getNomeCidade(Integer codigo) throws BusinessException {
		
		/* Verificamos se o código recebido é invalido */ 
		if(codigoInvalido(codigo)) {
			 
			 throw new BusinessException("O código recebido não é válido");
		 }
		
		return cidadeDAO.getNomeCidade(codigo);
	}

	/**
	 * Verifica se os dados recebidos são nulos ou vazios
	 * 
	 * @param cidade
	 * @return
	 */
	private boolean dadosNulos(Cidade cidade) {

		if (cidade.getNome() == null || cidade.getNome().trim().isEmpty()) {

			return true;
		} else {

			return false;
		}
	}

	/**
	 * Verifica se o código é invalido
	 * 
	 * @param codigo
	 * @return
	 */
	private Boolean codigoInvalido(Integer codigo) {
		if (codigo == null || codigo == 0) {

			return true;
		} else {

			return false;
		}
	}
}
