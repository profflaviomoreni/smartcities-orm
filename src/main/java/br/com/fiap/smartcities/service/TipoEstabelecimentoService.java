package br.com.fiap.smartcities.service;

import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface TipoEstabelecimentoService extends Remote {

	public String pesquisar(Integer idPesquisa) throws RemoteException;
	
}
