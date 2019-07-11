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
@Table(name = "TB_TIPO_SERVICO", schema = "public")
@SequenceGenerator(name = "SQ_TIPO_SERVICO", sequenceName = "SQ_TIPO_SERVICO", schema = "public", initialValue = 1, allocationSize = 1)
public class TipoServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SQ_TIPO_SERVICO", strategy = GenerationType.SEQUENCE)
	@Column(name = "COD_TIPO_SERVICO")
	private Short codigo;
	
	@Column(name = "DESCRICAO_TIPO_SERVICO", unique = true)
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

	public Short getCodigo() {
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
