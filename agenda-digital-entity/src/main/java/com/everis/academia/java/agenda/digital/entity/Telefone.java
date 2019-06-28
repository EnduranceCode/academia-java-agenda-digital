package com.everis.academia.java.agenda.digital.entity;

public class Telefone {
	
	private int codigo;
	private int numero;
	
	public Telefone(int codigo, int numero) {
		this.codigo = codigo;
		this.numero = numero;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
}
