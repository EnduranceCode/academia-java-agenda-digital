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
	private Cidade cidadeNova = new Cidade();

	public Cidade getCidadeNova() {
		return cidadeNova;
	}

	public void setCidadeNova(Cidade cidadeNova) {
		this.cidadeNova = cidadeNova;
	}

	/**
	 * Insere um nova cidades na lista de cidades existentes
	 * 
	 * @return
	 */
	public String submeterCidade() {

		try {

			cidadeNova = cidadeBusiness.create(cidadeNova);

			/* Re-instanciamos a variavel para limpar o formulário no Frontend */
			cidadeNova = new Cidade();

			return "create";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return null;
	}
	
	/**
	 * Limpa o formulário de submissão de uma nova cidade 
	 * @return
	 */
	public String cancelarCidadeNova() {

		/* Re-instanciamos a variavel para limpar o formulário no Frontend */
		cidadeNova = new Cidade();

		return "create";
	}

	/**
	 * Lê e devolve a lista de cidades existentes
	 * 
	 * @return
	 */
	public Collection<Cidade> getListaCidades() {

		return cidadeBusiness.read();
	}
}
