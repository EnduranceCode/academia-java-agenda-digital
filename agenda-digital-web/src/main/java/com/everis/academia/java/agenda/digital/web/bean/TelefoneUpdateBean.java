package com.everis.academia.java.agenda.digital.web.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.entity.Telefone;

@ManagedBean(name = "telefoneUpdateBean")
@Component
@RequestScoped
public class TelefoneUpdateBean {

	/* Instanciamos um novo objecto CidadeBusiness */
	@Autowired
	private ITelefoneBusiness telefoneBusiness;

	/* Instanciamos um novo objecto Telefone para receber os dados do Frontend */
	private Telefone telefoneActual = new Telefone();

	public Telefone getTelefoneActual() {
		return telefoneActual;
	}

	public void setTelefoneActual(Telefone telefoneActual) {
		this.telefoneActual = telefoneActual;
	}

	/**
	 * Regista os dados enviados do frontend e navega para a pagina de actualização
	 * de registo de telefone
	 * 
	 * @param telefone
	 */
	public String obterTelefone(Telefone telefone) {

		this.telefoneActual = telefone;

		return "update";
	}
	
	public String actualizarTelefone() {
		
		try {
			telefoneBusiness.update(telefoneActual);
			return "read";
		} catch (BusinessException e) {
			
			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}
		
		return null;
	}
	
	/**
	 * Retorna à lista de telefones
	 * 
	 * @return
	 */
	public String cancelarFormulario() {
		
		return "read";
	}
}
