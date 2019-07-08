package com.everis.agenda.digital.web.jsf;

import javax.faces.bean.ManagedBean;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name = "cidadeUpdateManagedBean")
public class CidadeUpdateManagedBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();
	
	/* Instanciamos um novo objecto Cidade */
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
	
	public String actualizarCidade() throws BusinessException {
		
		cidadeBusiness.update(cidadeActual);
		
		cidadeActual = new Cidade();
		
		return "read";
	}
}
