package br.com.fiap.smartcities.service;

import java.rmi.RemoteException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.com.fiap.smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class TipoEstabelecimentoServiceImpl implements TipoEstabelecimentoService {

	public TipoEstabelecimentoServiceImpl() {
		super();
	}

	public String pesquisar(Integer idPesquisa) throws RemoteException {

		EntityManager em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

		TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);
		TipoEstabelecimento tipoEstabelecimento = dao.buscar(idPesquisa);

		if (tipoEstabelecimento != null) {
			return tipoEstabelecimento.getNome();
		} else {
			return null;
		}

	}
	
	
}