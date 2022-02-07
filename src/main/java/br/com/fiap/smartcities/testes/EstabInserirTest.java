package br.com.fiap.smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Estabelecimento;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class EstabInserirTest {

	public static void main(String[] args) {
		
		EntityManager em = null;

		try { 
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
			
			TipoEstabelecimento tipo = new TipoEstabelecimento(1,null);
			
			Estabelecimento estab = new Estabelecimento();
			estab.setNome("Escolinha 1");
			estab.setTipo(tipo);
			em.persist(estab);
			
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
