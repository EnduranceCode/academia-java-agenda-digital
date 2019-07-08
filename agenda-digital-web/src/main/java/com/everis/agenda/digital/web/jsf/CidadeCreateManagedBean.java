package com.everis.agenda.digital.web.jsf;

import javax.faces.bean.ManagedBean;

import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name="cidadeCreateManagedBean")
public class CidadeCreateManagedBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();
	
	/* Instanciamos um novo objecto Cidade */
	private Cidade cidadeNova = new Cidade();

	public Cidade getCidadeNova() {
		return cidadeNova;
	}

	public void setCidadeNova(Cidade cidadeNova) {
		this.cidadeNova = cidadeNova;
	}
	
	public String submeterCidade() throws Exception {

		cidadeNova = cidadeBusiness.create(cidadeNova);
		
		cidadeNova = new Cidade();
		
		return null;
	}
}
