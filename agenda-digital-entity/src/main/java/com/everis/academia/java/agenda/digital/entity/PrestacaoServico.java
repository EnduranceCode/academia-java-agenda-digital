package com.everis.academia.java.agenda.digital.entity;

import java.util.Date;
import java.util.Set;

public class PrestacaoServico {

	private Integer codigo;
	private Date date;
	private PrestadorServico prestadores;
	private Set<ServicoPrestado> servicosPrestados;
	
	public PrestacaoServico() {
		
		super();
	}
	
	public PrestacaoServico(Integer codigo) {
		
		super();
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PrestadorServico getPrestador() {
		return prestadores;
	}

	public void setPrestador(PrestadorServico prestador) {
		this.prestadores = prestador;
	}

	public Set<ServicoPrestado> getServicoPrestado() {
		return servicosPrestados;
	}

	public void setServicoPrestado(Set<ServicoPrestado> servicoPrestado) {
		this.servicosPrestados = servicoPrestado;
	}
}
