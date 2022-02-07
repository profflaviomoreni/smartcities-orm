package br.com.fiap.smartcities.test;

import javax.persistence.Persistence;

public class BancoTeste {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
	}
	
}