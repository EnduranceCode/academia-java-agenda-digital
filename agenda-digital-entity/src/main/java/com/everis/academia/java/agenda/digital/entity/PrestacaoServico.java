package com.everis.academia.java.agenda.digital.entity;

import java.util.Date;
import java.util.Set;

public class PrestacaoServico {

	private int codigo;
	private Date date;
	private PrestadorServico prestador;
	private Set<ServicoPrestado> servicoPrestado;
	
	public PrestacaoServico(int codigo, Date date, PrestadorServico prestador, Set<ServicoPrestado> servicoPrestado) {
		super();
		this.codigo = codigo;
		this.date = date;
		this.prestador = prestador;
		this.servicoPrestado = servicoPrestado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PrestadorServico getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorServico prestador) {
		this.prestador = prestador;
	}

	public Set<ServicoPrestado> getServicoPrestado() {
		return servicoPrestado;
	}

	public void setServicoPrestado(Set<ServicoPrestado> servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}
}
