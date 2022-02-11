package br.com.fiap.smartcities.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.com.fiap.smartcities.service.TipoEstabelecimentoService;
import br.com.fiap.smartcities.service.TipoEstabelecimentoServiceImpl;

public class TipoEstabelecimentoServidor {

	public static void main(String[] args) {

		try {

			TipoEstabelecimentoService service = new TipoEstabelecimentoServiceImpl();
			TipoEstabelecimentoService skeleton = (TipoEstabelecimentoService) UnicastRemoteObject.exportObject(service, 0);

			Registry registry = LocateRegistry.createRegistry(7777);
			registry.bind("TipoEstabelecimentoService", skeleton);

			System.out.println("TipoEstabelecimentoService registrado e pronto para aceitar solicitações.");

		} catch (RemoteException | AlreadyBoundException e) {
			System.out.println("Não foi possível iniciar o Servidor RMI!");
			e.printStackTrace();
		}

	}

}