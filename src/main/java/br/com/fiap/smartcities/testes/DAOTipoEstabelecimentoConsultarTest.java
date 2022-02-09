package br.com.fiap.smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.com.fiap.smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class DAOTipoEstabelecimentoConsultarTest {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

			TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);
			TipoEstabelecimento entidade = dao.buscar(1);
			
			if (entidade == null) {
				System.out.println("Não existe tipo de estabelecimento para a chave 1");
			} else {
				System.out.println(" > " + entidade.getId() + " - " + entidade.getNome());
			}

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
