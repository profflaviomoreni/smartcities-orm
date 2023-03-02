package br.com.fiap.smartcities.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_leadsvendas" , 
	indexes = {@Index(columnList = "ddi,ddd,telefone", unique = true) })
public class LeadsVenda {

    @Id
    @Column(name = "id_lead")
	private UUID idLead;
	
    @Column(name = "nome")
	private String nome;
	
    @Column(name = "email", nullable = false)
	private String email;
	
    
    @Column(name = "ddi")
	private String ddi;
	
    
    @Column(name = "ddd")
	private String ddd;
	
    
    @Column(name = "telefone")
	private String telefone;

	
	public LeadsVenda() {
		super();
	}

	public LeadsVenda(UUID idLead, String nome, String email, String ddi, String ddd, String telefone) {
		super();
		this.idLead = idLead;
		this.nome = nome;
		this.email = email;
		this.ddi = ddi;
		this.ddd = ddd;
		this.telefone = telefone;
	}




	public UUID getIdLead() {
		return idLead;
	}

	public void setIdLead(UUID idLead) {
		this.idLead = idLead;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
	
	
	
	
}
