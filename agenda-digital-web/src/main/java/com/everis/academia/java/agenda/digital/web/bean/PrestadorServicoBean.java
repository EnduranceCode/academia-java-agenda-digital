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
import com.everis.academia.agenda.digital.business.inter.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;
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
	 * Instanciamos um novo objecto CidadeBusiness para poder acerder à lista de
	 * Cidades existentes
	 */
	@Autowired
	private ICidadeBusiness cidadeBusiness;

	/*
	 * Instanciamos um novo objecto PrestadorServico para receber os dados do
	 * Frontend
	 */
	private PrestadorServico prestadorServico = new PrestadorServico();

	/* Instanciamos um novo objecto Cidade para receber os dados do Frontend */
	private Cidade cidadeAdicional = new Cidade();

	public PrestadorServico getPrestadorServico() {

		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;
	}

	public TipoLogradouro[] getTiposLogradouro() {

		return TipoLogradouro.values();
	}
	
	public Cidade getCidadeAdicional() {
		return cidadeAdicional;
	}

	public void setCidadeAdicional(Cidade cidade) {
		this.cidadeAdicional = cidade;
	}

	public Collection<Cidade> getListaCidades() {

		return cidadeBusiness.read();
	}
	
	public String getNomeCidade() {
		
		try {
			
			return cidadeBusiness.getNomeCidade(prestadorServico.getCidade().getCodigo());
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}
		
		return null;
	}

	/**
	 * Insere uma nova Cidade na lista de cidades existentes
	 * 
	 * @return
	 */
	public String submeterCidade() {

		try {

			cidadeAdicional = cidadeBusiness.create(cidadeAdicional);

			/* Re-instanciamos a variavel para limpar o formulário no Frontend */
			cidadeAdicional = new Cidade();

			return "create";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return null;
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
			
			return "read?faces-redirect=true";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage("formPrestador:submeterCidade",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		prestadorServico = new PrestadorServico();

		return null;
	}
}
