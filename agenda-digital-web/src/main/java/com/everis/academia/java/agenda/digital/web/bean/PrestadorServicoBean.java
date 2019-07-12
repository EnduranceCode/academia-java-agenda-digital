package com.everis.academia.java.agenda.digital.web.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.entity.PrestadorServico;
import com.everis.academia.java.agenda.digital.enumerator.TipoLogradouro;

@ManagedBean(name = "prestadorServicoBean")
@Component
@RequestScoped
public class PrestadorServicoBean {

	/* Instanciamos um novo objecto PrestadorServicoBusiness */
	@Autowired
	private IPrestadorServicoBusiness prestadorServicoBusiness;

	/*
	 * Instanciamos um novo objecto PrestadorServico para receber os dados do
	 * Frontend
	 */
	private PrestadorServico prestadorServico = new PrestadorServico();
	
	
	
	public PrestadorServico getPrestadorServico() {

		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;
	}
	
	public TipoLogradouro[] getTiposLogradouro() {
		
		return TipoLogradouro.values();
	}
	
	/**
	 * Cria e insere um novo Prestador de Serviço
	 * 
	 * @param prestadorServico
	 * @return
	 */
	public String submterPrestador() {
		
		try {
			
			prestadorServico = prestadorServicoBusiness.create(prestadorServico);
		} catch (BusinessException e) {
			
			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}
		
		prestadorServico = new PrestadorServico();

		return null;
	}
}
