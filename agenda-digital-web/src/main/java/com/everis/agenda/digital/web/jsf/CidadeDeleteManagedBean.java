package com.everis.agenda.digital.web.jsf;

import javax.faces.bean.ManagedBean;

import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name = "cidadeDeleteManagedBean")
public class CidadeDeleteManagedBean {

	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();
	
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
