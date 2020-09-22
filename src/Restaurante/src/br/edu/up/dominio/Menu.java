package br.edu.up.dominio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Menu {

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
				arquivoPedido(listaPedidos);
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
				cardapio.incluirPrato();
				break;
			case 2:
				cardapio.incluirBebida();
				break;
			case 3:
				cardapio.incluirVinho();
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

	public static void arquivoPedido(List<Pedido> listaPedidos) throws IOException {
		
		int idPedido = 0;
		double totalVendas = 0.00;
		// BRUNO EM BAIXO -------------
		// BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream(out1, true), "UTF-8"));
		File arquivoPedido = new File("d:\\Eclipse\\atv3\\arquivoPedidos.txt");
		BufferedWriter gravadorPedido = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(arquivoPedido, true), // Append arquivo
						StandardCharsets.UTF_8 // Set encoding
				));
		
		
		File arquivoIndexUltimoPedido = new File("d:\\Eclipse\\atv3\\indexUltimoPedido.txt");
		BufferedWriter gravadorUltimoIndex = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("d:\\Eclipse\\atv3\\indexUltimoPedido.txt", true), // Append arquivo
						StandardCharsets.UTF_8 // Set encoding
				));
		
		Scanner leitorIndex = new Scanner(arquivoIndexUltimoPedido);
//		System.out.println(leitorIndex.nextLine());
		while (leitorIndex.hasNext()) {
			String ultimoIndex = leitorIndex.nextLine();
			idPedido = Integer.parseInt(ultimoIndex);
			String ultimoValorTotal = leitorIndex.nextLine();
			totalVendas = Double.parseDouble(ultimoValorTotal);
		}
		
		double valorTotal = 0;
		for (int i = 0; i < listaPedidos.size(); i++) {
			valorTotal += listaPedidos.get(i).total;
			gravadorPedido.write("PEDIDO " + (idPedido + 1) + "\r\n");
			listaPedidos.get(i).gravarPedido(gravadorPedido);
			idPedido++;			
		}
		
		
		totalVendas += valorTotal;
		gravadorPedido.write("O VALOR TOTAL É DE: R$" + Pedido.getTotalFormatado(totalVendas) + "\n");
		File arquivoGravacao = new File("d:\\Eclipse\\atv3\\indexUltimoPedido.txt");
		PrintWriter gravadorIndex = new PrintWriter (arquivoGravacao);
		
		gravadorIndex.println(idPedido);
		gravadorIndex.println(totalVendas);
		
		gravadorIndex.close();
		gravadorPedido.close();
		
	}

	// BRUNO EM BAIXO ------------- ORIGINAL FUNFANDO
	// BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
	// FileOutputStream(out1, true), "UTF-8"));
//			Path arquivoPedido = Paths.get("d:\\Eclipse\\atv3\\arquivoPedidos.txt");
//			BufferedWriter gravadorPedido = Files.newBufferedWriter(arquivoPedido, StandardCharsets.UTF_8);
//			
//			double valorTotal = 0;
//			for(int i = 0; i < listaPedidos.size(); i++) {
//				valorTotal += listaPedidos.get(i).total;
//				gravadorPedido.write("PEDIDO " + (i+1) + "\r\n");
//				listaPedidos.get(i).gravarPedido(gravadorPedido);
//			}
//			
//			gravadorPedido.write("O VALOR TOTAL É DE: R$" + Pedido.getTotalFormatado(valorTotal));
//			
//			gravadorPedido.close();
//		}

}
