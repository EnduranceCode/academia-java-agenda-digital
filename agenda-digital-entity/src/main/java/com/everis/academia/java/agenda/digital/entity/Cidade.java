package com.everis.academia.java.agenda.digital.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CIDADE", schema = "public")
@SequenceGenerator(name = "SQ_CIDADE", sequenceName = "SQ_CIDADE", schema = "public", initialValue = 1, allocationSize = 1)
public class Cidade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "SQ_CIDADE", strategy = GenerationType.SEQUENCE)
	@Column(name = "COD_CIDADE")
	private Integer codigo;
	
	@Column(name = "NOME_CIDADE", unique = true)
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
