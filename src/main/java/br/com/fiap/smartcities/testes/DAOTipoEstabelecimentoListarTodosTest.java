package br.com.fiap.smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.com.fiap.smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class DAOTipoEstabelecimentoListarTodosTest {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

			TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);

			listarOrdenadoNome(dao);
			
			listarOrdenadoNomeAndId(dao);
			
			listarTresUltimos(dao);
			
			listarPaginado(dao);
			
			listarPorNome(dao);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}

	}
	
	private static void listarOrdenadoNome(TipoEstabelecimentoDAO dao) {
		System.out.println("\n\n\n");
		System.out.println("\nOrdenado por nome:"); 
		for (TipoEstabelecimento entidade : dao.listarOrdenadoNome()) { 
			System.out.println("     " + entidade ); 
		}
	}
	
	
	private static void listarOrdenadoNomeAndId(TipoEstabelecimentoDAO dao) {
		System.out.println("\n\n\n");
		System.out.println("\nOrdenado por nome e id:"); 
		for (TipoEstabelecimento entidade : dao.listarOrdenadoNomeAndId()) { 
			System.out.println("     " + entidade ); 
		}
	}
	
	private static void listarTresUltimos(TipoEstabelecimentoDAO dao) {
		System.out.println("\n\n\n");
		System.out.println("\nÚltimos três:"); 
		for (TipoEstabelecimento entidade : dao.listarTresUltimos()) { 
			System.out.println("     " + entidade ); 
		}
	}
	
	
	private static void listarPaginado(TipoEstabelecimentoDAO dao) {
		System.out.println("\n\n\n");
		System.out.println("\nPaginado:"); 
		
		int quantidadeItens = 2;
		int paginaAtual = 2;
		
		for (TipoEstabelecimento entidade : dao.listarPaginado(quantidadeItens, paginaAtual)) { 
			System.out.println("     " + entidade ); 
		}
	}
	
	
	private static void listarPorNome(TipoEstabelecimentoDAO dao) {
		System.out.println("\n\n\n");
		System.out.println("Por Nome:"); 
		
		String nome = "Galpão";
		
		for (TipoEstabelecimento entidade : dao.listarPorNome(nome)) { 
			System.out.println("     " + entidade ); 
		}
	}
	
}
