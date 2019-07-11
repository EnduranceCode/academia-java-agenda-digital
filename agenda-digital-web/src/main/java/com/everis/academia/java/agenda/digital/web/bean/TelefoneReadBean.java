package com.everis.academia.java.agenda.digital.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.inter.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.entity.Telefone;

@ManagedBean(name = "telefoneReadBean")
@Component
@RequestScoped
public class TelefoneReadBean {

	/* Instanciamos um novo objecto CidadeBusiness */
	@Autowired
	private ITelefoneBusiness telefoneBusiness;

	/* Declaramos uma variavel para guardar a lista de telefones existentes */
	private List<Telefone> listaTelefones = null;

	@PostConstruct
	public void init() {

		this.listaTelefones = telefoneBusiness.read();

	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}
	
	/**
	 * Navega para a página de inserção de novo telefone
	 * 
	 * @return
	 */
	public String navegarCreateTelefone() {
		
		return "create";
	}
}
