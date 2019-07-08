package com.everis.agenda.digital.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name="cidadeCreateManagedBean")
public class CidadeCreateManagedBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();
	
	/* Instanciamos um novo objecto Cidade para receber os dados do Frontend */
	private Cidade cidadeNova = new Cidade();

	public Cidade getCidadeNova() {
		return cidadeNova;
	}

	public void setCidadeNova(Cidade cidadeNova) {
		this.cidadeNova = cidadeNova;
	}
	
	/**
	 * Insere uma nova cidades na lista de cidades existenetes
	 * 
	 * @return
	 */
	public String submeterCidade() {

		try {
			cidadeNova = cidadeBusiness.create(cidadeNova);
		} catch (BusinessException e) {
			
			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}
		
		cidadeNova = new Cidade();
		
		return null;
	}
}
