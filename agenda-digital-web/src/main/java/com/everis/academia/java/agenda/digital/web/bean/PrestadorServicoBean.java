package com.everis.academia.java.agenda.digital.web.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "prestadorServicoBean")
public class PrestadorServicoBean {

	/* TODO: Implementar o método para ter como parametro um PrestadorServiço */
	/**
	 * Recebe um objecto Prestador de Servico e redirecciona para a página
	 * respectiva
	 * 
	 * @return
	 */
	public String verPrestadorServico() {

		return "prestadores/ver-prestador";
	}
}
