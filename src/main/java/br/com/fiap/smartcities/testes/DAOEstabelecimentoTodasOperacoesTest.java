package br.com.fiap.smartcities.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.dao.EstabelecimentoDAO;
import br.com.fiap.smartcities.domain.Estabelecimento;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class DAOEstabelecimentoTodasOperacoesTest {
	
	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

			EstabelecimentoDAO dao = new EstabelecimentoDAO(em);

			listarPorNome(dao);
			
			listarPorTipo(dao);
			
			listarPorNomeCriacaoApos(dao);
			
			alterarTipoTodosComContador(dao);
			
			excluirAntesDeContador(dao);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}

	}

	
	private static void listarPorNome(EstabelecimentoDAO dao) {
		
		System.out.println("\n\n\n");
		System.out.println("\nPor nome:"); 
		
		for (Estabelecimento entidade : dao.listarPorNome( "Galpao FEDEX"))  { 
			System.out.println("     " + entidade ); 
		}
	}
	
	
	private static void listarPorTipo(EstabelecimentoDAO dao) {
		
		System.out.println("\n\n\n");
		System.out.println("\nPor tipo:"); 
		TipoEstabelecimento tipo = new TipoEstabelecimento(4); 
		
		for (Estabelecimento entidade : dao.listarPorTipo(tipo))  { 
			System.out.println("     " + entidade ); 
		}
	}
	
	private static void listarPorNomeCriacaoApos(EstabelecimentoDAO dao) throws ParseException {
		
		System.out.println("\n\n\n");
		System.out.println("\nPor nome e data:"); 
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(formatador.parse("19/01/2020"));
		
		for (Estabelecimento entidade : dao.listarPorNomeCriacaoApos( "Galpao FEDEX" , calendario))  { 
			System.out.println("     " + entidade ); 
		}
		
	}
	
	
	private static void alterarTipoTodosComContador(EstabelecimentoDAO dao) {
		
		System.out.println("\n\n\n");
		System.out.println("\nAlterar Tipo:"); 
		
		TipoEstabelecimento tipo = new TipoEstabelecimento(4); 
		int total = dao.alterarTipoTodosComContador(tipo);
		
		System.out.println("Total de linha alteradas: " + total);
		
	}
	
	private static void excluirAntesDeContador(EstabelecimentoDAO dao) throws ParseException {
		
		System.out.println("\n\n\n");
		System.out.println("\nExcluir por data:"); 
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(formatador.parse("10/02/2022"));
		
		int total = dao.excluirAntesDeContador(calendario);
		
		System.out.println("Total de linha excluidos: " + total);
		
	}
	
	
	/*
	excluirAntesDeContador
alterarTipoTodosComContador

	
	*/
	
	
}
