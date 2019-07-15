package com.everis.academia.agenda.digital.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.dao.inter.ITelefoneDAO;
import com.everis.academia.java.agenda.digital.entity.Telefone;

@Service
public class TelefoneBusiness implements ITelefoneBusiness {

	/* Instanciamos um novo objecto TelefoneDAO */
	@Autowired
	private ITelefoneDAO telefoneDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Telefone create(Telefone telefone) throws BusinessException {

		/* Verificamos se os dados recebidos não estão vazios */
		if (dadosNulos(telefone)) {

			throw new BusinessException("Não foram recebidos dados");
		}

		/* Verificamos se o telefone já existe */
		if (telefoneDAO.jaExisteEsteTelefone(telefone)) {

			throw new BusinessException("O telefone já existe");
		}

		/* Feita a validação dos dados recebidos, criamos um nove telefone */
		return telefoneDAO.create(telefone);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Telefone> read() {

		return telefoneDAO.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Telefone telefone) throws BusinessException {

		/* Verificamos se os dados recebidos não estão vazios */
		if (dadosNulos(telefone)) {

			throw new BusinessException("Não foram recebidos dados");
		}

		/* Verificamos se foram introduzidas alterações */
		for (Telefone telefoneActual : telefoneDAO.read()) {

			if (telefoneActual.getCodigo() == telefone.getCodigo()
					&& telefoneActual.getNumero() == telefone.getNumero()) {

				/*
				 * Não foram introduzidas alterações aos dados pré-existentes e assim retornamos
				 * à origem
				 */
				return;
			}
		}

		/* Verificamos se o telefone já existe */
		if (telefoneDAO.jaExisteEsteTelefone(telefone)) {

			throw new BusinessException("O telefone já existe");
		}

		/* Feita a validação dos dados recebidos, actualizamos o telefonee */
		telefoneDAO.update(telefone);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer codigo) {

		telefoneDAO.delete(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean jaExisteEsteTelefone(Telefone telefone) {
		
		return telefoneDAO.jaExisteEsteTelefone(telefone);
	}

	/**
	 * Verifica se os dados recebidos são nulos ou zero
	 * 
	 * @param telefone
	 * @return
	 */
	private boolean dadosNulos(Telefone telefone) {

		if (telefone.getNumero() == null || telefone.getNumero() == 0) {

			return true;
		} else {

			return false;
		}
	}
}
