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
		
		
		UUID notaId = UUID.fromString("F372E975-C635-472C-96D1-43F8D109A658");
		
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
	
		NotaFiscal  nf = em.find(NotaFiscal.class, notaId );
		
		System.out.println(nf);
		
		
	}
	
	
	public static void inserir() {
		
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		//Definindo o cliente 
		ClienteBase clienteGov = em.find(ClienteGov.class, UUID.fromString("FBAC84C6-0636-4509-9D92-0EFEBBC830D4") );
		
		
		em.getTransaction().begin();

		NotaFiscal nf = new NotaFiscal();
		nf.setIdNota(UUID.randomUUID());
		nf.setValorTotal(1213.2);
		nf.setCliente(clienteGov);

		em.persist(nf);
		
		em.getTransaction().commit();
		
	}
	
	
}
