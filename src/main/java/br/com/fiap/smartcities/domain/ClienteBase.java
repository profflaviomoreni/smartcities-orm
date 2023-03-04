package br.com.fiap.smartcities.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class ClienteBase {

	@Id
	private UUID idCliente;
	
	private String nome;
	
	private ClienteBaseEnum tipoCliente;
	
	private String partidoPolitico;
	
	private String nomeMinistro;
	
	private String cpf;
	
	private String estadoCivil;

	private String cnpj;
	
	private String inscricaoEstatual;

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

	public ClienteBaseEnum getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(ClienteBaseEnum tipoCliente) {
		this.tipoCliente = tipoCliente;
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
		return "ClienteBase [idCliente=" + idCliente + ", nome=" + nome + ", tipoCliente=" + tipoCliente
				+ ", partidoPolitico=" + partidoPolitico + ", nomeMinistro=" + nomeMinistro + ", cpf=" + cpf
				+ ", estadoCivil=" + estadoCivil + ", cnpj=" + cnpj + ", inscricaoEstatual=" + inscricaoEstatual + "]";
	}
	
	
	
}
