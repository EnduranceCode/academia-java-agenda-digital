package com.everis.agenda.digital.web.jsf;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@ManagedBean(name = "cidadeManagedBean")
public class CidadeManagedBean {
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();

	private String nomeCidade;

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String submeterCidade() throws ServletException {

		/* Criamos um objecto cidade com o nome de cidade recebido */
		Cidade cidadeNova = new Cidade();
		cidadeNova.setNome(nomeCidade);
		
		/* Executamos o método create() e actualizamos a variável com os dados retornados pelo método */
		try {
			cidadeNova = cidadeBusiness.create(cidadeNova);
		} catch (Exception e) {
			
			throw new ServletException(e);
		}
		
		nomeCidade = null;
		
		return null;
	}
}
