package br.com.fiap.smartcities.testes.heranca;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.ClienteBase;
import br.com.fiap.smartcities.domain.NotaFiscal;

public class NotaFiscalTest {

	public static void main(String[] args) {
		//inserir();
		pesquisar();
	}

	
	public static void pesquisar() {
		
		UUID notaId = UUID.fromString("3E391F49-F6D6-41FE-A84C-61721995E9A0");
		
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
	
		NotaFiscal  nf = em.find(NotaFiscal.class, notaId );
		
		System.out.println("Todos os dados: " + nf);
		System.out.print("Tipo do Cliente: " + nf.getCliente().getTipoCliente().name());
		
	}
	
	
	public static void inserir() {
		
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		//Definindo o cliente 
		ClienteBase cliente = em.find(ClienteBase.class, UUID.fromString("AB320469-C84E-47C0-8955-61547D9CD2EB") );
		
		
		em.getTransaction().begin();

		NotaFiscal nf = new NotaFiscal();
		nf.setIdNota(UUID.randomUUID());
		nf.setValorTotal(1213.2);
		nf.setCliente(cliente);

		em.persist(nf);
		
		em.getTransaction().commit();
		
	}
	
	
}
