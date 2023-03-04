package br.com.fiap.smartcities.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class ClienteGov extends ClienteBase {

	private String partidoPolitico;
	
	private String nomeMinistro;

	
	
	
	
	public ClienteGov() {
		super();
	}

	public ClienteGov(UUID idCliente, String nome) {
		super(idCliente, nome);
	}

	public ClienteGov(UUID idCliente, String nome, String partidoPolitico, String nomeMinistro) {
		super(idCliente, nome);
		this.partidoPolitico = partidoPolitico;
		this.nomeMinistro = nomeMinistro;
	}

	public String getPartidoPolitico() {
		return partidoPolitico;
	}

	public void setPartidoPolitico(String partidoPolitico) {
		this.partidoPolitico = partidoPolitico;
	}

	public String getNomeMinistro() {
		return nomeMinistro;
	}

	public void setNomeMinistro(String nomeMinistro) {
		this.nomeMinistro = nomeMinistro;
	}

	
	@Override
	public String toString() {
		return "ClienteGov [partidoPolitico=" + partidoPolitico + ", nomeMinistro=" + nomeMinistro + ", getIdCliente()="
				+ getIdCliente() + ", getNome()=" + getNome() + "]";
	}
	
	
	
	
}
