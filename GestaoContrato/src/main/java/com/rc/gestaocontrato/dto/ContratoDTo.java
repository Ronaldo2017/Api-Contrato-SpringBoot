package com.rc.gestaocontrato.dto;

import java.io.Serializable;

import com.rc.gestaocontrato.domain.Contrato;

public class ContratoDTo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private int numero;
	private int quantidade;
	private Double valor;

	public ContratoDTo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContratoDTo(Contrato obj) {
		super();
		this.id = obj.getId();
		this.numero = obj.getNumero();
		this.quantidade = obj.getQuantidade();
		this.valor = obj.getValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
