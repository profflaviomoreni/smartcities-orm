package br.com.fiap.smartcities.dao;

import javax.persistence.EntityManager;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class TipoEstabelecimentoDAO extends GenericDAO<TipoEstabelecimento, Integer> {

	public TipoEstabelecimentoDAO(EntityManager em) {
		super(em);
	}

}
