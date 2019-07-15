package com.everis.academia.agenda.digital.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.dao.inter.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.entity.PrestadorServico;

@Service
public class PrestadorServicoBusiness implements IPrestadorServicoBusiness{
	
	/* Instanciamos um novo objecto prestadorServicoDAO */
	@Autowired
	private IPrestadorServicoDAO prestadorServicoDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico create(PrestadorServico prestadorServico) throws BusinessException {
		
		/* Verificamos se os dados recebidos não estão vazios */
		/**
		 * TODO: Verificar se o Prestador de Serviço possui a Cidade definida
		 * 
		 * 		if (cidadeVazia(prestadorServico)) {
		 * 			throw new BusinessException("Não foi definida uma Cidade");
		 * 		}
		 */
		
		/**
		 * TODO: Verificar se o Prestador de Serviço tem pelo menos um Telefone definido
		 * 
		 * 		if (telefoneVazio(prestadorServico)) {
		 * 			throw new BusinessException("Não foi definida um Telefone");
		 * 		}
		 */
		
		/* Feita a validação dos dados recebidos, criamos um novo Prestador de Serviço */
		return prestadorServicoDAO.create(prestadorServico);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> read() {
		
		return prestadorServicoDAO.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(PrestadorServico prestadorServico) throws BusinessException {
		
		/* Verificamos se os dados recebidos não estão vazios */
		/**
		 * TODO: Verificar se o Prestador de Serviço possui a Cidade definida
		 * 
		 * 		if (cidadeVazia(prestadorServico)) {
		 * 			throw new BusinessException("Não foi definida uma Cidade");
		 * 		}
		 */
		
		/**
		 * TODO: Verificar se o Prestador de Serviço tem pelo menos um Telefone definido
		 * 
		 * 		if (telefoneVazio(prestadorServico)) {
		 * 			throw new BusinessException("Não foi definida um Telefone");
		 * 		}
		 */
		
		/* Feita a validação dos dados recebidos, actualizamos o Prestador de Serviço */
		prestadorServicoDAO.update(prestadorServico);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer codigo) throws BusinessException {
		
		/* Verificamos se o código recebido é invalido */ 
		if(codigoInvalido(codigo)) {
			 
			 throw new BusinessException("O código recebido não é válido");
		 }
		
		prestadorServicoDAO.delete(codigo);
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
