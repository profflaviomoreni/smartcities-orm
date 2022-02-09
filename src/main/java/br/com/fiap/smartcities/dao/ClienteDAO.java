package br.com.fiap.smartcities.dao;

import javax.persistence.EntityManager;
import br.com.fiap.smartcities.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Integer>  {

	public ClienteDAO(EntityManager em) {
		super(em);
	}
	
}
