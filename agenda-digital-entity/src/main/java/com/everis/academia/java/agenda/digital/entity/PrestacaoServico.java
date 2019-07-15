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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrestacaoServico other = (PrestacaoServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrestacaoServico [codigo=" + codigo + ", date=" + date + ", prestadores=" + prestadores
				+ ", servicosPrestados=" + servicosPrestados + "]";
	}
}
