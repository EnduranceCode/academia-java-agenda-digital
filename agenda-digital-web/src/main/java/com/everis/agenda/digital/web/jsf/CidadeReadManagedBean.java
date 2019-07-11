package com.everis.agenda.digital.web.jsf;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.inter.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name = "cidadeReadManagedBean")
@Component
@RequestScoped
public class CidadeReadManagedBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	@Autowired
	private ICidadeBusiness cidadeBusiness;

	public Collection<Cidade> getListaCidades() {
		return cidadeBusiness.read();
	}
}
