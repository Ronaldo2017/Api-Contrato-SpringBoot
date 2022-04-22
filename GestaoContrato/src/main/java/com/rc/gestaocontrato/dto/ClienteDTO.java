package com.rc.gestaocontrato.dto;

import java.io.Serializable;

import com.rc.gestaocontrato.domain.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private int numero;
	private String nome;

	public ClienteDTO() {
		super();

	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.numero = obj.getNumero();
		this.nome = obj.getNome();
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
