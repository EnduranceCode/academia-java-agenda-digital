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

@ManagedBean(name = "telefoneCreateBean")
@Component
@RequestScoped
public class TelefoneCreateBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	@Autowired
	private ITelefoneBusiness telefoneBusiness;
	
	/* Instanciamos um novo objecto Telefone para receber os dados do Frontend */
	private Telefone telefoneNovo = new Telefone();

	public Telefone getTelefoneNovo() {
		return telefoneNovo;
	}

	public void setTelefoneNovo(Telefone telefoneNovo) {
		this.telefoneNovo = telefoneNovo;
	}
	
	/**
	 * Insere um novo telefone com os dados recebidos no frontend
	 * 
	 * @return
	 */
	public String submeterTelefone() {
		
		try {
			
			telefoneNovo = telefoneBusiness.create(telefoneNovo);
		} catch (BusinessException e) {
			
			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}
		
		telefoneNovo = new Telefone();
		
		return null;
	}
	
	/**
	 * Cancela o formulário limpando os valores submetidos
	 * 
	 * @return
	 */
	public String cancelarFormulario() {

		telefoneNovo = new Telefone();
		
		return null;
	}
	
	public String navegarReadTelefone() {
		
		return "read";
	}
}
