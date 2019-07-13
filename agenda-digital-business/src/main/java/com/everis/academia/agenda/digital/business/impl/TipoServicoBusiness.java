package com.everis.academia.agenda.digital.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.dao.inter.ITipoServicoDAO;
import com.everis.academia.java.agenda.digital.entity.TipoServico;

@Service
public class TipoServicoBusiness implements ITipoServicoBusiness {
	
	/* Instanciamos um novo objecto TipoServicoDAO */
	@Autowired
	private ITipoServicoDAO tipoServicoDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoServico create(TipoServico tipoServico) throws BusinessException {
		
		/* Verificamos se os dados recebidos não estão vazios */
		if (dadosNulos(tipoServico)) {
			
			throw new BusinessException("Não foram recebidos dados");
		}
		
		/* Verificamos se o Tipo de Serviço já existe */
		if (tipoServicoDAO.jaExisteTipoServico(tipoServico)) {
			
			throw new BusinessException("O tipo de serviço já existe");
		}
		
		/* Feita a validação dos dados recebidos, criamos um novo Tipo de Serviço */
		return tipoServicoDAO.create(tipoServico);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoServico> read() {

		return tipoServicoDAO.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(TipoServico tipoServico) throws BusinessException {
		
		/* Verificamos se os dados recebidos não estão vazios */
		if (dadosNulos(tipoServico)) {
			
			throw new BusinessException("Não foram recebidos dados");
		}
		
		/* Verificamos se o Tipo de Serviço já existe */
		if (tipoServicoDAO.jaExisteTipoServico(tipoServico)) {
			
			throw new BusinessException("O tipo de serviço já existe");
		}

		/* Feita a validação dos dados recebidos, actualizamos o Tipo de Serviço */
		tipoServicoDAO.update(tipoServico);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Short codigo) throws BusinessException {
		
		 if(codigoInvalido(codigo)) {
			 
			 throw new BusinessException("O código recebido não é válido");
		 }
		
		tipoServicoDAO.delete(codigo);
	}
	
	/**
	 * Verifica se os dados recebidos são nulos ou vazios
	 * 
	 * @param tipoServico
	 * @return
	 */
	private boolean dadosNulos(TipoServico tipoServico) {
		
		if (tipoServico.getDescricao() == null ||  tipoServico.getDescricao().trim().isEmpty()) {
			
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
	private Boolean codigoInvalido(Short codigo) {
		if (codigo == null || codigo == 0) {

			return true;
		} else {

			return false;
		}
	}
}
