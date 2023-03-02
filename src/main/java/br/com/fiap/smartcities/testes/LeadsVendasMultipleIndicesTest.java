package br.com.fiap.smartcities.testes;

import java.util.Random;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.com.fiap.smartcities.domain.LeadsVenda;

public class LeadsVendasMultipleIndicesTest {

	public static void main(String[] args) {
		
		String ddi = "+55";
		String telefone = "999998888";
		String ddd = "" + new Random().nextInt(99);
		
		EntityManager em = null;
		em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		
		// SUCESSO
		em.getTransaction().begin();
		LeadsVenda leadCorreto = new LeadsVenda( UUID.randomUUID() , "Flavio Moreni", "fmoreni@fiap.com", ddi, ddd, telefone);
		em.persist(leadCorreto);
		em.getTransaction().commit();

		
		// FALHA PELO INDICE ÚNICO
		em.getTransaction().begin();
		LeadsVenda leadFalha   = new LeadsVenda( UUID.randomUUID() , "Eduardo Moreni", "emoreni@fiap.com", ddi, ddd, telefone);
		em.persist(leadFalha);
		em.getTransaction().commit();
		
		

	}

}
