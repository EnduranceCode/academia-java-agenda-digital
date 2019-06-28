package com.everis.academia.java.agenda.digital.entity;

public class Telefone {
	
	private Integer codigo;
	private Integer numero;
	
	public Telefone() {

		super();
	}
	
	public Telefone(Integer codigo) {
		
		super();
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Integer getNumero() {
		return numero;
	}
}
