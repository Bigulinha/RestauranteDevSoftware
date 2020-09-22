package br.edu.up.dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardapio {

	public List<Prato> listaPratos = new ArrayList<Prato>();
	public List<Bebida> listaBebidas = new ArrayList<Bebida>();
	public List<Vinho> listaVinhos = new ArrayList<Vinho>();

	public void inicializarPratos() throws IOException {

		File arquivo = new File("d:\\Eclipse\\atv3\\pratos.csv");

		BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));

		String linha = null;
		leitor.readLine();
		while ((linha = leitor.readLine()) != null) {
			String[] partes = linha.split(";");

			Prato prato = new Prato();
			prato.nome = partes[0];
			prato.preco = Double.parseDouble(partes[1].replaceAll(",", "."));

			listaPratos.add(prato);

		}

		// leitor.close();

	}

	public void imprimirPratos() {

		System.out.println("PRATOS");
		for (int i = 0; i < listaPratos.size(); i++) {

			System.out.println("PRATO " + (i + 1));
			System.out.println("NOME: " + listaPratos.get(i).nome);
			System.out.println("PREÇO: R$" + listaPratos.get(i).getPrecoFormatado());
			System.out.println("-------------------");

		}
	}

	public void inicializarBebidas() throws IOException {

		File arquivo = new File("d:\\Eclipse\\atv3\\bebidas-tabuladas.txt");

		BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));

		String linha = null;
		leitor.readLine();
		while ((linha = leitor.readLine()) != null) {
			String[] partes = linha.split("\t");

			Bebida bebida = new Bebida();
			bebida.preco = Double.parseDouble(partes[0].replaceAll(",", "."));
			bebida.nome = partes[1];

			listaBebidas.add(bebida);

		}

		// leitor.close();

	}

	public void imprimirBebidas() {

		System.out.println("BEBIDAS");
		for (int i = 0; i < listaBebidas.size(); i++) {

			System.out.println("BEBIDA " + (i + 1));
			System.out.println("NOME: " + listaBebidas.get(i).nome);
			System.out.println("PREÇO: R$" + listaBebidas.get(i).getPrecoFormatado());
			System.out.println("-------------------");

		}
	}

	public void inicializarVinhos() throws IOException {

		File arquivo = new File("d:\\Eclipse\\atv3\\vinhos-tabulados.txt");

		BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));

		String linha = null;
		leitor.readLine();
		while ((linha = leitor.readLine()) != null) {
			String[] partes = linha.split("\t");

			Vinho vinho = new Vinho();
			vinho.preco = Double.parseDouble(partes[0].replaceAll(",", "."));
			vinho.nome = partes[1];

			listaVinhos.add(vinho);

		}

//		leitor.close();

	}

	public void imprimirVinhos() {

		System.out.println("VINHOS");
		for (int i = 0; i < listaVinhos.size(); i++) {

			System.out.println("VINHO " + (i + 1));
			System.out.println("NOME: " + listaVinhos.get(i).nome);
			System.out.println("PREÇO: R$" + listaVinhos.get(i).getPrecoFormatado());
			System.out.println("-------------------");

		}
	}

	public void inicializarCardapio() throws IOException {

		inicializarPratos();
		inicializarBebidas();
		inicializarVinhos();

	}

	public void incluirPrato() throws IOException {

		Prato prato = new Prato();

		Scanner leitor = new Scanner(System.in);

		System.out.println("DIGITE O NOME DO PRATO QUE DESEJA ADICIONAR NO CARDAPIO");
		prato.nome = leitor.nextLine();
		System.out.println("DIGITE O PREÇO DO PRATO INCLUIDO");
		prato.preco = Double.parseDouble(leitor.nextLine().replaceAll(",", "."));

		listaPratos.add(prato);

		// leitor.close();

	}

	public void incluirBebida() throws IOException {

		Bebida bebida = new Bebida();

		Scanner leitor = new Scanner(System.in);

		System.out.println("DIGITE O NOME DA BEBIDA QUE DESEJA ADICIONAR NO CARDAPIO");
		bebida.nome = leitor.nextLine();
		System.out.println("DIGITE O PREÇO DA BEBIDA INCLUIDA");
		bebida.preco = Double.parseDouble(leitor.nextLine().replaceAll(",", "."));

		listaBebidas.add(bebida);

		// leitor.close();

	}

	public void incluirVinho() throws IOException {

		Vinho vinho = new Vinho();

		Scanner leitor = new Scanner(System.in);

		System.out.println("DIGITE O NOME DO VINHO QUE DESEJA ADICIONAR NO CARDAPIO");
		vinho.nome = leitor.nextLine();
		System.out.println("DIGITE O PREÇO DO VINHO INCLUIDO");
		vinho.preco = Double.parseDouble(leitor.nextLine().replaceAll(",", "."));

		listaVinhos.add(vinho);

		// leitor.close();

	}

	public static Pedido selecionarPrato(Cardapio cardapio, List<Pedido> listaPedidos, Pedido pedido)
			throws IOException {

		cardapio.imprimirPratos();

		Scanner leitor = new Scanner(System.in);
		int opcao;
		String observacao;
		Prato prato = null;
		while (prato == null) {
			System.out.println("ESCOLHA O PRATO DESEJADO OU DIGITE 0 PARA VOLTAR AO MENU INICIAL");
			opcao = leitor.nextInt();
			leitor.nextLine();

			if (opcao <= cardapio.listaPratos.size() && opcao >= 1) {

				prato = cardapio.listaPratos.get(opcao - 1);

				System.out.println("DIGITE 'S' SE DESEJA ADICIONAR OBSERVAÇÃO OU 'N' PARA CONTINUAR");
				observacao = leitor.nextLine();

				if ((int) observacao.charAt(0) == (int) 's') {
					System.out.println("DIGITE A SUA OBSERVAÇÃO: ");
					observacao = leitor.nextLine();
					prato.observacao = observacao;
				} else {
					prato.observacao = "Nenhuma";
				}

				pedido.listaPratos.add(prato);

			}
			if (opcao == 0) {
				return pedido;
			}
		}
		return pedido;
		// leitor.close();
	}

	public static Pedido selecionarBebida(Cardapio cardapio, List<Pedido> listaPedidos, Pedido pedido)
			throws IOException {

		cardapio.imprimirBebidas();

		Scanner leitor = new Scanner(System.in);
		int opcao;
		String observacao = "";
		Bebida bebida = null;
		while (bebida == null) {
			System.out.println("ESCOLHA A BEBIDA DESEJADA OU DIGITE 0 PARA VOLTAR AO MENU INICIAL");
			opcao = leitor.nextInt();
			leitor.nextLine();

			if (opcao <= cardapio.listaBebidas.size() && opcao >= 1) {

				bebida = cardapio.listaBebidas.get(opcao - 1);

				System.out.println("DIGITE 'S' SE DESEJA ADICIONAR OBSERVAÇÃO OU 'N' PARA CONTINUAR");
				observacao = leitor.nextLine();

				if ((int) observacao.charAt(0) == (int) 's') {
					System.out.println("DIGITE A SUA OBSERVAÇÃO: ");
					observacao = leitor.nextLine();
					bebida.observacao = observacao;
				} else {
					bebida.observacao = "Nenhuma";
				}

				pedido.listaBebidas.add(bebida);
			}
			if (opcao == 0) {
				return pedido;
			}
		}
		return pedido;

		// leitor.close();
	}

	public static Pedido selecionarVinho(Cardapio cardapio, List<Pedido> listaPedidos, Pedido pedido)
			throws IOException {

		cardapio.imprimirVinhos();

		Scanner leitor = new Scanner(System.in);
		int opcao;
		String observacao;
		Vinho vinho = null;
		while (vinho == null) {
			System.out.println("ESCOLHA O VINHO DESEJADO OU DIGITE 0 PARA VOLTAR AO MENU INICIAL");
			opcao = leitor.nextInt();
			leitor.nextLine();

			if (opcao <= cardapio.listaVinhos.size() && opcao >= 1) {

				vinho = cardapio.listaVinhos.get(opcao - 1);

				System.out.println("DIGITE 'S' SE DESEJA ADICIONAR OBSERVAÇÃO OU 'N' PARA CONTINUAR");
				observacao = leitor.nextLine();

				if ((int) observacao.charAt(0) == (int) 's') {
					System.out.println("DIGITE A SUA OBSERVAÇÃO: ");
					observacao = leitor.nextLine();
					vinho.observacao = observacao;
				} else {
					vinho.observacao = "Nenhuma";
				}

				pedido.listaVinhos.add(vinho);

			}
			if (opcao == 0) {
				return pedido;
			}
		}
		return pedido;

		// leitor.close();
	}

}
