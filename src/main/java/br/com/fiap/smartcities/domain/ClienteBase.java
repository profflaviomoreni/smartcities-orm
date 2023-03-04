package br.com.fiap.smartcities.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ClienteBase {

	@Id
	private UUID idCliente;
	
	private String nome;

	
	public ClienteBase(UUID idCliente, String nome) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
	}


	public ClienteBase() {
		super();
	}
	
	
	

	public UUID getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(UUID idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "ClienteBase [idCliente=" + idCliente + ", nome=" + nome + "]";
	}
	
	
	
	
	
}
