package com.everis.academia.java.agenda.digital.web.bean;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name = "cidadeBean")
@Component
@RequestScoped
public class CidadeBean {

	/* Instanciamos um novo objecto CidadeBusiness */
	@Autowired
	private ICidadeBusiness cidadeBusiness;

	/* Instanciamos um novo objecto Cidade para receber os dados do Frontend */
	private Cidade cidade = new Cidade();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/**
	 * Insere um nova cidades na lista de cidades existentes
	 * 
	 * @return
	 */
	public String submeterCidade() {

		try {

			cidade = cidadeBusiness.create(cidade);

			/* Re-instanciamos a variavel para limpar o formulário no Frontend */
			cidade = new Cidade();

			return "create-read?faces-redirect=true";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return null;
	}
	
	/**
	 * Lê e devolve a lista de cidades existentes
	 * 
	 * @return
	 */
	public Collection<Cidade> getListaCidades() {

		return cidadeBusiness.read();
	}
	
	/**
	 * Carrega a página para actualizar a cidade com os dados recebidos no Frontend
	 * 
	 * @param cidade
	 * @return
	 */
	public String navegarUpdateCidade(Cidade cidade) {
		
		this.cidade = cidade;
		
		return "update?faces-redirect=true";
	}
	
	public String cancelarActualizarCidade() {

		/* Re-instanciamos a variavel para limpar o formulário no Frontend */
		cidade = new Cidade();
		
		return "create-read?faces-redirect=true";
	}
	
	/**
	 * Actualiza os dados da cidade
	 * 
	 * @return
	 */
	public String actualizarCidade() {
		
		try {
			
			cidadeBusiness.update(cidade);

			/* Re-instanciamos a variavel para limpar o formulário no Frontend */
			cidade = new Cidade();

			return "create-read?faces-redirect=true";
		} catch (BusinessException e) {
			
			String messageDetails = e.getLocalizedMessage();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}
		
		return null;
	}
	
	/**
	 * Apaga a cidade referenciada no Frontend
	 * 
	 * @param cidade
	 * @return
	 */
	public String apagarCidade(Cidade cidade) {
		
		try {
			
			cidadeBusiness.delete(cidade.getCodigo());
		} catch (BusinessException e) {
			
			String messageDetails = e.getLocalizedMessage();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}
		
		return "create-read?faces-redirect=true";
	}
}
