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

@ManagedBean(name = "cidadeUpdateManagedBean")
@Component
@RequestScoped
public class CidadeUpdateManagedBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	@Autowired
	private ICidadeBusiness cidadeBusiness;
	
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
