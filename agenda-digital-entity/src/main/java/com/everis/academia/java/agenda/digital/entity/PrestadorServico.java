package com.everis.academia.java.agenda.digital.entity;

import java.util.Set;

import com.everis.academia.java.agenda.digital.enumerator.TipoLogradouro;

public class PrestadorServico {
	
	private int codigo;
	private String nome;
	private Cidade cidade;
	private String bairro;
	private String cep;
	private TipoLogradouro tipoLogradouro;
	private String logradouro;
	private String complemento;
	private String numero;
	private String email;
	private Set<Telefone> telefone;
	private Set<PrestacaoServico> prestacaoServico;
	private Set<TipoServico> servicosCredenciados;
	
	public PrestadorServico(int codigo, String nome, Cidade cidade, String bairro, String cep,
			TipoLogradouro tipoLogradouro, String logradouro, String complemento, String numero, String email,
			Set<Telefone> telefone, Set<PrestacaoServico> prestacaoServico, Set<TipoServico> servicosCredenciados) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.email = email;
		this.telefone = telefone;
		this.prestacaoServico = prestacaoServico;
		this.servicosCredenciados = servicosCredenciados;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Set<PrestacaoServico> getPrestacaoServico() {
		return prestacaoServico;
	}

	public void setPrestacaoServico(Set<PrestacaoServico> prestacaoServico) {
		this.prestacaoServico = prestacaoServico;
	}

	public Set<TipoServico> getServicosCredenciados() {
		return servicosCredenciados;
	}

	public void setServicosCredenciados(Set<TipoServico> servicosCredenciados) {
		this.servicosCredenciados = servicosCredenciados;
	}
}
