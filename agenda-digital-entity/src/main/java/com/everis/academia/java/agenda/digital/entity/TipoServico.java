package com.everis.academia.java.agenda.digital.entity;

public class TipoServico {

	private Short codigo;
	private String descricao;
	
	public TipoServico() {
		
		super();
	}
	
	public TipoServico(Short codigo) {
		
		this();
		this.codigo = codigo;
	}
	
	public TipoServico( Short codigo, String descricao) {
		
		this(codigo);
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
