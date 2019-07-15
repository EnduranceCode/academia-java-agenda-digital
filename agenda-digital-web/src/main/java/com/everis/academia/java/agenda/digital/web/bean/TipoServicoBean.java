package com.everis.academia.java.agenda.digital.web.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.entity.TipoServico;

@ManagedBean(name = "tipoServicoBean")
@Component
@RequestScoped
public class TipoServicoBean {

	/* Instanciamos um novo objecto TipoServicoBusiness */
	@Autowired
	private ITipoServicoBusiness tipoServicoBusiness;

	/* Instanciamos um novo objecto TipoServico para receber os dados do Frontend */
	private TipoServico tipoServico = new TipoServico();

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	/**
	 * Insere um novo Tipo de Serviçp na lista de Tipos de Serviço existentes
	 * 
	 * @return
	 */
	public String submeterTipoServico() {

		try {

			tipoServico = tipoServicoBusiness.create(tipoServico);

			/* Re-instanciamos a variavel para limpar o formulário no Frontend */
			tipoServico = new TipoServico();

			return "create?faces-redirect=true";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return null;
	}

	/**
	 * Lê e devolve a lista de Tipos de Serviço existentes
	 * 
	 * @return
	 */
	public List<TipoServico> getListaTiposServico() {

		return tipoServicoBusiness.read();
	}

	/**
	 * Carrega a página para actualizar o Tipo de Serviço escolhido no Frontend
	 * 
	 * @param tipoServico
	 * @return
	 */
	public String navegarUpdateTipoServico(TipoServico tipoServico) {

		this.tipoServico = tipoServico;

		return "update?faces-redirect=true";
	}

	/**
	 * Cancela a actualização do Tipo de Servico e retorna à página de criação e
	 * leitura de Tipos de Servico
	 * 
	 * @return
	 */
	public String cancelarActualizarTipoServico() {

		/* Re-instanciamos a variavel para limpar o formulário no Frontend */
		tipoServico = new TipoServico();

		return "create-read?faces-redirect=true";
	}

	/**
	 * Actualiza os dados do Tipo de Serviço
	 * 
	 * @return
	 */
	public String actualizarTipoServico() {

		try {

			tipoServicoBusiness.update(tipoServico);

			/* Re-instanciamos a variavel para limpar o formulário no Frontend */
			tipoServico = new TipoServico();

			return "create-read?faces-redirect=true";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return null;
	}

	/**
	 * Apaga o Tipo de Serviço referenciada no Frontend
	 * 
	 * @param tipoServico
	 * @return
	 */
	public String apagarTipoServico(TipoServico tipoServico) {

		try {

			tipoServicoBusiness.delete(tipoServico.getCodigo());
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return "create-read?faces-redirect=true";
	}
}
