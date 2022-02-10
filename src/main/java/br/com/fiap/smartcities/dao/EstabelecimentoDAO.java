package br.com.fiap.smartcities.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.smartcities.domain.Estabelecimento;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class EstabelecimentoDAO extends GenericDAO<Estabelecimento, Integer> {

	public EstabelecimentoDAO(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Estabelecimento> listarPorNome(String nome) {
		String jpqlQuery = "select e from Estabelecimento e where e.nome = :n";
		return this.em.createQuery(jpqlQuery).setParameter("n", nome).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Estabelecimento> listarPorNomeCriacaoApos(String nome, Calendar criacaoApos) {

		String jpqlQuery = "select e from Estabelecimento e where e.nome = :n and e.dataCriacao > :criacao";

		return this.em.createQuery(jpqlQuery).setParameter("n", nome).setParameter("criacao", criacaoApos)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Estabelecimento> listarPorTipo(TipoEstabelecimento tipo) {
		return this.em.createQuery("select e from Estabelecimento e  where e.tipo = :t").setParameter("t", tipo)
				.getResultList();
	}

	public void alterarTipoTodos(TipoEstabelecimento tipo) {

		em.getTransaction().begin();

		this.em.createQuery("update Estabelecimento e set e.tipo = :tipo").setParameter("tipo", tipo).executeUpdate();

		em.getTransaction().commit();

	}

	public int alterarTipoTodosComContador(TipoEstabelecimento tipo) {

		em.getTransaction().begin();

		int total = this.em.createQuery("update Estabelecimento e set e.tipo = :tipo").setParameter("tipo", tipo)
				.executeUpdate();

		em.getTransaction().commit();

		return total;

	}

	public void excluirAntesDe(Calendar data) {
		em.getTransaction().begin();

		this.em.createQuery("delete from Estabelecimento e where dataCriacao < :data")
			.setParameter("data", data)
			.executeUpdate();

		em.getTransaction().commit();
	}

	
	public int excluirAntesDeContador(Calendar data) {
		em.getTransaction().begin();

		int total = this.em.createQuery("delete from Estabelecimento e where dataCriacao < :data")
			.setParameter("data", data)
			.executeUpdate();

		em.getTransaction().commit();
		
		return total;
	}
	
	
}
