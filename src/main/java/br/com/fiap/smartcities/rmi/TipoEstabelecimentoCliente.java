package br.com.fiap.smartcities.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import br.com.fiap.smartcities.service.TipoEstabelecimentoService;

public class TipoEstabelecimentoCliente {

	public static void main(String[] args) {

		try {

			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 7777);
			TipoEstabelecimentoService stub = (TipoEstabelecimentoService) registry
					.lookup("TipoEstabelecimentoService");

			System.out.print("Digite o código de Tipo de estabelecimento: ");
			
			int codigoPesquisa = new Scanner(System.in).nextInt();

			String resultado = stub.pesquisar(codigoPesquisa);
			if (resultado != null) {
				System.out.println("Registro encontrado: " + resultado);
			} else {
				System.out.println("Tipo de estabelecimento não encontrado");
			}

		} catch (RemoteException | NotBoundException e) {

			System.out.println("Erro ao tentar chamada para o servidor");
			e.printStackTrace();

		}

	}

}
