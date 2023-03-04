package br.com.fiap.smartcities.testes.heranca;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.ClienteBase;
import br.com.fiap.smartcities.domain.ClienteGov;
import br.com.fiap.smartcities.domain.NotaFiscal;

public class NotaFiscalTest {

	public static void main(String[] args) {
		//inserir();
		pesquisar();
	}

	
	public static void pesquisar() {
		
		UUID notaId = UUID.fromString("7BC742B0-D40E-4CBF-88E3-62C5D2A3B088");
		
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
	
		NotaFiscal  nf = em.find(NotaFiscal.class, notaId );
		
		System.out.println(nf);
		
		
	}
	
	
	public static void inserir() {
		
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		//Definindo o cliente 
		ClienteBase clienteGov = em.find(ClienteGov.class, UUID.fromString("D639208D-347F-413F-BB1B-DC469961E1D0") );
		
		
		em.getTransaction().begin();

		NotaFiscal nf = new NotaFiscal();
		nf.setIdNota(UUID.randomUUID());
		nf.setValorTotal(1213.2);
		nf.setCliente(clienteGov);

		em.persist(nf);
		
		em.getTransaction().commit();
		
	}
	
	
}
