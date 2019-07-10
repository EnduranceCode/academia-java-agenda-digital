package com.everis.academia.java.agenda.digital.web.bean;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name = "prestadorServicoBean")
public class PrestadorServicoBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();

	private Collection<Cidade> listaCidades = null;
	
	@PostConstruct
	public void init() {
		
		this.listaCidades = cidadeBusiness.read();
	}

	public Collection<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(Collection<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}
	
	/* TODO: Implementar o método para ter como parametro um PrestadorServiço */
	/**
	 * Recebe um objecto Prestador de Servico e redirecciona para a página
	 * respectiva
	 * 
	 * @return
	 */
	public String verPrestadorServico() {

		return "prestador/read";
	}
}
