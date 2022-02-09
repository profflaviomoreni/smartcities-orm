package br.com.fiap.smartcities.testes;

import javax.persistence.EntityManager; 
import javax.persistence.Persistence; 
import br.com.fiap.smartcities.dao.TipoEstabelecimentoDAO; 
import br.com.fiap.smartcities.domain.TipoEstabelecimento; 

public class DAOTipoEstabelecimentoExcluirTest {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

			TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);
			dao.excluir(1);	 
			dao.commit(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}

	}

}
