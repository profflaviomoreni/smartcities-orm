package br.com.fiap.smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.dao.EstabelecimentoDAO;
import br.com.fiap.smartcities.domain.Estabelecimento;

public class DAOEstabelecimentoListarTest {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

			EstabelecimentoDAO dao = new EstabelecimentoDAO(em);

			System.out.println("\nEstabelecimento:"); 
			for (Estabelecimento entidade : dao.listar()) { 
				System.out.println(" " + entidade); 
			}

			dao.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}

	}

}
