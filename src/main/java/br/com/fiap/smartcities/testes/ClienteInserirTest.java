package br.com.fiap.smartcities.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Cliente;
import br.com.fiap.smartcities.domain.Estabelecimento;

public class ClienteInserirTest {

	public static void main(String[] args) {

		EntityManager em = null;

		try { 
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
			
			
			// TODO Cuidado com o ID dos Estabelecimento - pode ser que o ID da sua tabela seja diferente de 21 e 22;
			List<Estabelecimento> listaEstab = new ArrayList<>();
			listaEstab.add(new Estabelecimento(21));
			listaEstab.add(new Estabelecimento(22));
			
			Cliente cliente = new Cliente("Fiap", listaEstab);
			em.persist(cliente);
			
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
