package br.com.fiap.smartcities.domain;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class NotaFiscal {

	
	@Id
	private UUID idNota;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEmissao;
	
	
	private double valorTotal;
	
	
	@JoinColumn(name = "idCliente")
	@ManyToOne
	private ClienteBase cliente;

	
	

	public NotaFiscal() {
		super();
	}


	public NotaFiscal(UUID idNota, Calendar dataEmissao, ClienteBase cliente) {
		super();
		this.idNota = idNota;
		this.dataEmissao = dataEmissao;
		this.cliente = cliente;
	}

	public UUID getIdNota() {
		return idNota;
	}


	public void setIdNota(UUID idNota) {
		this.idNota = idNota;
	}


	public Calendar getDataEmissao() {
		return dataEmissao;
	}


	public void setDataEmissao(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
	}


	public ClienteBase getCliente() {
		return cliente;
	}


	public void setCliente(ClienteBase cliente) {
		this.cliente = cliente;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	@Override
	public String toString() {
		return "NotaFiscal [idNota=" + idNota 
				+ ", valorTotal=" + valorTotal
				+ ", cliente=" + cliente + "]";
	}
	
	
	
	
	

}
