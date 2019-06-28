package com.everis.academia.java.agenda.digital.entity;

public class Cidade {
	
	private int codigo;
	private String nome;
	
	public Cidade(Integer codigo, String nome) {
		
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
