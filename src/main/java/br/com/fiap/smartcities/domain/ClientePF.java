package br.com.fiap.smartcities.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class ClientePF extends ClienteBase {

	
	private String cpf;
	
	
	private String estadoCivil;
	

	public ClientePF() {
		super();
	}

	public ClientePF(UUID idCliente, String nome) {
		super(idCliente, nome);
	}
	
	
	public ClientePF(UUID idCliente, String nome, String cpf, String estadoCivil) {
		super(idCliente, nome);
		this.cpf = cpf;
		this.estadoCivil = estadoCivil;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	
	@Override
	public String toString() {
		return "ClientePF [cpf=" + cpf + ", estadoCivil=" + estadoCivil + ", getIdCliente()=" + getIdCliente()
				+ ", getNome()=" + getNome() + "]";
	}
	
	
	
	
	
	
}
