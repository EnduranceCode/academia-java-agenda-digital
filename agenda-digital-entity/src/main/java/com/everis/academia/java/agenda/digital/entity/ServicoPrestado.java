package com.everis.academia.java.agenda.digital.entity;

public class ServicoPrestado {

	private PrestacaoServico prestacaoServico;
	private TipoServico tipoServico;
	private double valor;
	
	public ServicoPrestado(PrestacaoServico prestacaoServico, TipoServico tipoServico, double valor) {
		super();
		this.prestacaoServico = prestacaoServico;
		this.tipoServico = tipoServico;
		this.valor = valor;
	}

	public PrestacaoServico getPrestacaoServico() {
		return prestacaoServico;
	}

	public void setPrestacaoServico(PrestacaoServico prestacaoServico) {
		this.prestacaoServico = prestacaoServico;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
