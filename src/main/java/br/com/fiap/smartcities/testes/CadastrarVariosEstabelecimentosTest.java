package br.com.fiap.smartcities.testes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.dao.EstabelecimentoDAO;
import br.com.fiap.smartcities.domain.Estabelecimento;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class CadastrarVariosEstabelecimentosTest {

	public static void main(String[] args) {

		EntityManager em = null;
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar calendario1 = Calendar.getInstance();
		Calendar calendario2 = Calendar.getInstance();
		
		
		try {
			
			calendario1.setTime(formatador.parse("01/01/2000"));
			calendario2.setTime(formatador.parse("20/01/2020"));

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

			EstabelecimentoDAO dao = new EstabelecimentoDAO(em);

			TipoEstabelecimento tipoBar = new TipoEstabelecimento(1);
			TipoEstabelecimento tipoLanchonete = new TipoEstabelecimento(2);
			TipoEstabelecimento tipoFastFood = new TipoEstabelecimento(3);
			TipoEstabelecimento tipoCozinha = new TipoEstabelecimento(4);
			TipoEstabelecimento tipoGalpao = new TipoEstabelecimento(5);
			
			Estabelecimento estab1 = new Estabelecimento("Cozinha Fiap", calendario1 , tipoCozinha );
			Estabelecimento estab2 = new Estabelecimento("MC", calendario1 , tipoFastFood);
			Estabelecimento estab3 = new Estabelecimento("Bar da esquina", calendario1 , tipoBar );
			Estabelecimento estab4 = new Estabelecimento("Galpao FEDEX", calendario2 , tipoGalpao);
			Estabelecimento estab5 = new Estabelecimento("Lancheteria", calendario2 , tipoLanchonete);
			
			dao.cadastrar(estab1);
			dao.cadastrar(estab2);
			dao.cadastrar(estab3);
			dao.cadastrar(estab4);
			dao.cadastrar(estab5);
			
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
