package br.edu.up.dominio;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.edu.up.crud.Criar;
import br.edu.up.sistema.Armazenamento;

public class Menu {

	static Criar criar = new Criar();
	
	public static void menuInicial(Cardapio cardapio, List<Pedido> listaPedidos) throws IOException {

		Scanner leitor = new Scanner(System.in);
		int opcao = -1;

		while (opcao != 0) {

			System.out.println("DIGITE A OPÇÃO DESEJADA: ");
			System.out.println("INCLUIR ITEM NO CARDAPIO: 1");
			System.out.println("FAZER PEDIDO: 2");
			System.out.println("VIZUALIZAR PEDIDOS: 3");
			System.out.println("SAIR DO PROGRAMA: 0");
			opcao = leitor.nextInt();

			// leitor.close();

			switch (opcao) {
			case 1:
				incluirItemCardapio(cardapio, listaPedidos);
				break;
			case 2:
				escolherCardapio(cardapio, listaPedidos);
				break;
			case 3:
				Pedido.vizualizarPedidos(listaPedidos);
				break;
			case 0:
				Armazenamento.arquivoPedido(listaPedidos);
				return;
			default:
				System.out.println("Opção invalida!");
				menuInicial(cardapio, listaPedidos);
				break;
			}
		}
	}

	public static void escolherCardapio(Cardapio cardapio, List<Pedido> listaPedidos) throws IOException {

		Pedido pedido = new Pedido();

		Scanner leitor = new Scanner(System.in);
		int opcao = -1;

		while (opcao != 4) {
			System.out.println("DIGITE A OPÇÃO DESEJADA: ");
			System.out.println("ESCOLHER PRATO: 1");
			System.out.println("ESCOLHER BEBIDA: 2");
			System.out.println("ESCOLHER VINHO: 3");
			System.out.println("FINALIZAR PEDIDO: 4");
			System.out.println("VOLTAR PARA O MENU INICIAL: 0");
			opcao = leitor.nextInt();

			// leitor.close();

			switch (opcao) {
			case 1:
				pedido = Cardapio.selecionarPrato(cardapio, listaPedidos, pedido);
				break;
			case 2:
				pedido = Cardapio.selecionarBebida(cardapio, listaPedidos, pedido);
				break;
			case 3:
				pedido = Cardapio.selecionarVinho(cardapio, listaPedidos, pedido);
				break;
			case 4:
				Pedido.finalizarPedido(pedido, listaPedidos);

				return;
			case 0:

				return;
			default:
				System.out.println("Opção invalida!");

				break;
			}
		}

		// escolherCardapio(cardapio, listaPedidos);

	}

	public static void incluirItemCardapio(Cardapio cardapio, List<Pedido> listaPedidos) throws IOException {

		Scanner leitor = new Scanner(System.in);
		int opcao = -1;

		while (opcao != 0) {

			System.out.println("DIGITE A OPÇÃO DESEJADA");
			System.out.println("INCLUIR PRATO NO CARDAPIO: 1");
			System.out.println("INCLUIR BEBIDA NO CARDAPIO: 2");
			System.out.println("INCLUIR VINHO NO CARDAPIO: 3");
			System.out.println("VOLTAR PARA O MENU INICIAL: 0");
			opcao = leitor.nextInt();

			// leitor.close();

			switch (opcao) {
			case 1:
				criar.incluirPrato(cardapio.listaPratos);
				break;
			case 2:
				criar.incluirBebida(cardapio.listaBebidas);
				break;
			case 3:
				criar.incluirVinho(cardapio.listaVinhos);
				break;
			case 0:
				// menuInicial(cardapio, listaPedidos);
				// break;
				return;
			default:
				System.out.println("Opção invalida!");
				// incluirItemCardapio(cardapio, listaPedidos);
				break;
			}
		}
		// incluirItemCardapio(cardapio, listaPedidos);
	}

	
}
