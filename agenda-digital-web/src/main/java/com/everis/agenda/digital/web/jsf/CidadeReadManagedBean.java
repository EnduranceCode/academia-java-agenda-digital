package com.everis.agenda.digital.web.jsf;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name = "cidadeReadManagedBean")
@Component
@RequestScoped
public class CidadeReadManagedBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	@Autowired
	private ICidadeBusiness cidadeBusiness;

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
}
