package br.com.fiap.smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Estabelecimento;

public class EstabConsultarIdTest {

	public static void main(String[] args) {

		
		EntityManager em = null;

		try { 
			
			int idProcurado = 1;
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			Estabelecimento estab = em.find(Estabelecimento.class, idProcurado);

			System.out.println("Estabelecimento encontrado: " + estab);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
