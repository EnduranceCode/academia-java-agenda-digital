package com.everis.academia.java.agenda.digital.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.everis.academia.java.agenda.digital.enumerator.TipoLogradouro;

@Entity
@Table(name = "TB_PRESTADOR_SERVICO", schema = "public")
@SequenceGenerator(name = "SQ_PRESTADOR", sequenceName = "SQ_PRESTADOR", schema = "public", initialValue = 1, allocationSize = 1)
public class PrestadorServico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "SQ_PRESTADOR", strategy = GenerationType.SEQUENCE)
	@Column(name = "COD_PRESTADOR_SERVICO")
	private Integer codigo;
	
	@Column(name = "NOME_PRESTADOR_SERVICO")
	private String nome;
	
	@Column(name = "TIPO_LOGRADOURO")
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "NUMERO_PORTA")
	private String numero;
	
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@Transient
	private String cep;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Cidade.class)
	@JoinColumn(name = "COD_CIDADE", nullable = false)
	private Cidade cidade;
	
	@Transient
	private String email;
	
	@Transient
	private Set<Telefone> telefones;
	
	@Transient
	private Set<TipoServico> servicosCredenciados;
	
	@Transient
	private Set<PrestacaoServico> prestacoesServicos;
	
	public PrestadorServico() {
		
		super();
	}
	
	public PrestadorServico(Integer codigo) {
		
		super();
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Telefone> getTelefone() {
		return telefones;
	}

	public void setTelefone(Set<Telefone> telefone) {
		this.telefones = telefone;
	}

	public Set<TipoServico> getServicosCredenciados() {
		return servicosCredenciados;
	}

	public void setServicosCredenciados(Set<TipoServico> servicosCredenciados) {
		this.servicosCredenciados = servicosCredenciados;
	}

	public Set<PrestacaoServico> getPrestacaoServico() {
		return prestacoesServicos;
	}

	public void setPrestacaoServico(Set<PrestacaoServico> prestacaoServico) {
		this.prestacoesServicos = prestacaoServico;
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
		PrestadorServico other = (PrestadorServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
