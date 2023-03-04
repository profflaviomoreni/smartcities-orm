package br.com.fiap.smartcities.testes.heranca;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.ClienteBase;
import br.com.fiap.smartcities.domain.ClienteBaseEnum;


public class ClienteGeralTest {

	public static void main(String[] args) {

		inserir();
		//consultar();
	}

	
	
	public static void consultar() {
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

		UUID clienteId = UUID.fromString("FBAC84C6-0636-4509-9D92-0EFEBBC830D4");
		
		ClienteBase cliente = em.find(ClienteBase.class,clienteId );
		
		System.out.println(cliente);
	}
	
	
	
	public static void inserir() {
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		em.getTransaction().begin();

		ClienteBase clienteDoTipoGov = new ClienteBase();
		clienteDoTipoGov.setIdCliente(UUID.randomUUID());
		clienteDoTipoGov.setNome("Ministério Transporte");
		clienteDoTipoGov.setTipoCliente(ClienteBaseEnum.GOV);
		clienteDoTipoGov.setPartidoPolitico("Partido X");
		clienteDoTipoGov.setNomeMinistro("Jose Silva");
		
		em.persist(clienteDoTipoGov);
		
		em.getTransaction().commit();
	}
	
	
	
	
}
