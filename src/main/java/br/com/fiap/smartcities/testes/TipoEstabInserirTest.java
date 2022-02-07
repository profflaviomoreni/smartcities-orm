package br.com.fiap.smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class TipoEstabInserirTest {

	public static void main(String[] args) {
		EntityManager em = null;

		try { 
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
			
			TipoEstabelecimento tipo1 = new TipoEstabelecimento();
			tipo1.setNome("Loja de Rua");
			em.persist(tipo1);
			
			TipoEstabelecimento tipo2 = new TipoEstabelecimento();
			tipo2.setNome("Loja de Shopping");
			em.persist(tipo2);
			
			TipoEstabelecimento tipo3 = new TipoEstabelecimento();
			tipo3.setNome("Kiosque");
			em.persist(tipo3);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
