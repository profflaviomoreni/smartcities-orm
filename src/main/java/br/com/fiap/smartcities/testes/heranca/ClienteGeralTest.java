package br.com.fiap.smartcities.testes.heranca;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.ClienteBase;
import br.com.fiap.smartcities.domain.ClienteGov;


public class ClienteGeralTest {

	public static void main(String[] args) {

		inserir();
		//consultar();
	}

	
	public static void consultar() {
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

		UUID clienteId = UUID.fromString("FBAC84C6-0636-4509-9D92-0EFEBBC830D4");
		
		ClienteGov clienteGov = em.find(ClienteGov.class,clienteId );
		
		System.out.println(clienteGov);
	}
	
	
	public static void inserir() {
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		em.getTransaction().begin();

		ClienteBase clienteGov = 
				new ClienteGov(
						UUID.randomUUID(),
						"Ministério Transporte",
						"Partido X",
						"Jose Silva");

		em.persist(clienteGov);
		
		em.getTransaction().commit();
	}
	
	
	
	
}
