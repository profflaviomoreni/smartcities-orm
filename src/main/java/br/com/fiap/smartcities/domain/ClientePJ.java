package br.com.fiap.smartcities.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class ClientePJ extends ClienteBase {

	private String cnpj;
	
	private String inscricaoEstatual;

	
	public ClientePJ() {
		super();
	}

	public ClientePJ(UUID idCliente, String nome) {
		super(idCliente, nome);
	}
	

	public ClientePJ(UUID idCliente, String nome, String cnpj, String inscricaoEstatual) {
		super(idCliente, nome);
		this.cnpj = cnpj;
		this.inscricaoEstatual = inscricaoEstatual;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstatual() {
		return inscricaoEstatual;
	}

	public void setInscricaoEstatual(String inscricaoEstatual) {
		this.inscricaoEstatual = inscricaoEstatual;
	}

	
	@Override
	public String toString() {
		return "ClientePJ [cnpj=" + cnpj + ", inscricaoEstatual=" + inscricaoEstatual + ", getIdCliente()="
				+ getIdCliente() + ", getNome()=" + getNome() + "]";
	}

	
	
	
	
	
	
	
}
