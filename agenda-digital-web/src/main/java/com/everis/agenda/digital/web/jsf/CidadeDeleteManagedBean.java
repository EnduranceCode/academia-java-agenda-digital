package com.everis.agenda.digital.web.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.inter.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name = "cidadeDeleteManagedBean")
@Component
@RequestScoped
public class CidadeDeleteManagedBean {

	/* Instanciamos um novo objecto CidadeBusiness */
	@Autowired
	private ICidadeBusiness cidadeBusiness;
	
	/* Instanciamos um novo objecto Cidade para receber os dados do Frontend */
	private Cidade cidadeActual = new Cidade();

	public Cidade getCidadeActual() {
		return cidadeActual;
	}

	/**
	 * Apaga a cidade seleccionada no Frontend
	 * 
	 * @param cidadeActual
	 */
	public void setCidadeActual(Cidade cidadeActual) {
		this.cidadeActual = cidadeActual;
	}
	
	public String apagarCidade(Cidade cidadeActual) {
		
		cidadeBusiness.delete(cidadeActual.getCodigo());
		
		return "read";
	}
}
