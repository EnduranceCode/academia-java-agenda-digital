package com.everis.academia.java.agenda.digital.entity;

public class Cidade {
	
	private Integer codigo;
	private String nome;
	
	public Cidade() {
		
		super();
	}
	
	public Cidade(Integer codigo) {
		
		this();
		this.codigo = codigo;
	}
	
	public Cidade(Integer codigo, String nome) {
		
		this(codigo);
		this.nome = nome;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
