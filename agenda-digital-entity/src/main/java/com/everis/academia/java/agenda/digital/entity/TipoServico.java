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
		TipoServico other = (TipoServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoServico [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
}
