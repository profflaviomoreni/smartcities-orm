package br.com.fiap.smartcities.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class TipoEstabelecimentoDAO extends GenericDAO<TipoEstabelecimento, Integer> {

	public TipoEstabelecimentoDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	@Override 
	public List<TipoEstabelecimento> listar() { 
		return this.em.createQuery("from TipoEstabelecimento")
				.getResultList(); 
	} 
	
	@SuppressWarnings("unchecked")
	public List<TipoEstabelecimento> listarOrdenadoNome() { 
		return this.em.createQuery("from TipoEstabelecimento order by nome")
				.getResultList();
	} 
	
	@SuppressWarnings("unchecked")
	public List<TipoEstabelecimento> listarOrdenadoNomeAndId() { 
		return this.em.createQuery("from TipoEstabelecimento order by nome, id desc")
				.getResultList();
	} 
	
	
	@SuppressWarnings("unchecked")
	public List<TipoEstabelecimento> listarTresUltimos() { 
		return this.em.createQuery("from TipoEstabelecimento order by id desc")
				.setMaxResults(3).getResultList(); 
	} 
	
	@SuppressWarnings("unchecked")
	public List<TipoEstabelecimento>  listarPaginado(int itensPorPagina, int pagina) { 
		int primeiro = (pagina - 1) * itensPorPagina; 

		return this.em.createQuery("from TipoEstabelecimento order by nome")
				.setMaxResults(itensPorPagina) 
				.setFirstResult(primeiro) 
				.getResultList(); 
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TipoEstabelecimento> listarPorNome(String nome)   
    { 
		String jpqlQuery =  "select e from TipoEstabelecimento e where e.nome = :n";
		return this.em.createQuery(jpqlQuery).setParameter("n", nome).getResultList(); 

    } 
	
}
