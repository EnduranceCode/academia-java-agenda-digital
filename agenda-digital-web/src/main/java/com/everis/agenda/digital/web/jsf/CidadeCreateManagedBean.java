package com.everis.agenda.digital.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name="cidadeCreateManagedBean")
@Component
@RequestScoped
public class CidadeCreateManagedBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	@Autowired
	private ICidadeBusiness cidadeBusiness;
	
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
