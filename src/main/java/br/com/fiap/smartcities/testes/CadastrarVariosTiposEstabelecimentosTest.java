package br.com.fiap.smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class CadastrarVariosTiposEstabelecimentosTest {

	public static void main(String[] args) {
		
		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

			TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);

			TipoEstabelecimento tipo = new TipoEstabelecimento(); 
			tipo.setNome("Bar e Restaurante"); 
			dao.cadastrar(tipo); 
			
			tipo = new TipoEstabelecimento(); 
			tipo.setNome("Lanchonete");
			dao.cadastrar(tipo); 
			
			tipo = new TipoEstabelecimento(); 
			tipo.setNome("Fast Food");
			dao.cadastrar(tipo); 
			
			tipo = new TipoEstabelecimento(); 
			tipo.setNome("Cozinha fantasma");
			dao.cadastrar(tipo); 
			
			tipo = new TipoEstabelecimento(); 
			tipo.setNome("Galpão");
			dao.cadastrar(tipo); 
			

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
