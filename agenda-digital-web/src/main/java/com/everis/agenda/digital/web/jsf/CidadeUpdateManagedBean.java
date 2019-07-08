package com.everis.agenda.digital.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name = "cidadeUpdateManagedBean")
public class CidadeUpdateManagedBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();
	
	/* Instanciamos um novo objecto Cidade para receber os dados do Frontend */
	private Cidade cidadeActual = new Cidade();

	public Cidade getCidadeActual() {
		return cidadeActual;
	}

	public void setCidadeActual(Cidade cidadeActual) {
		this.cidadeActual = cidadeActual;
	}
	
	public String obterCidade(Cidade cidadeActual) {
		
		this.cidadeActual = cidadeActual;
		
		return "update";
	}
	
	/**
	 * Actualiza os dados da cidade
	 * 
	 * @return
	 */
	public String actualizarCidade() {
		
		try {
			
			cidadeBusiness.update(cidadeActual);
			return "read";
		} catch (BusinessException e) {
			
			String messageDetails = e.getLocalizedMessage();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}
		
		cidadeActual = new Cidade();
		
		return null;
	}
}
