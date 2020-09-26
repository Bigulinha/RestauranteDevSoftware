package br.edu.up.crud;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Bebida;

//import com.sun.tools.javac.util.List;

import br.edu.up.dominio.Cardapio;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;



// FALTA CORRIGIR BUG DE MODIFICAR DEPOIS DE INCLUIR  // NECESSITA PADRONIZAR COMO AS INFORMAÇÕES IRÃO SAIR NO ARQUIVO.

public class Atualizar {

	public static void editarPrato(Cardapio cardapio) throws IOException {
		System.out.println("DIGITE O NOME DO PRATO PARA ALTERAR: ");
		Scanner leitor = new Scanner(System.in);
//		leitor.nextLine();
		String pratoEditar = leitor.nextLine();
		int index = 1;
		String modificar;

		for (Prato itemPrato : cardapio.listaPratos) {
			if (itemPrato.nome.contains(pratoEditar)) {

				System.out.println("Prato encontrado: " + itemPrato.nome + "\t" + "VALOR: " + itemPrato.preco);
				System.out.println("DIGITE 'S' PARA MODIFICAR O NOME OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();

				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O NOME DESEJADO PARA O PRATO: ");
					String novoNomeItem = leitor.nextLine();
					itemPrato.nome = novoNomeItem;
				}
				System.out.println("DIGITE 'S' PARA MODIFICAR O PREÇO OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();
				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O PRECO DESEJADO PARA O PRATO: ");
					double novoPrecoItem = leitor.nextDouble();
					itemPrato.preco = novoPrecoItem;
				}
				atualizarPratoArquivo(itemPrato, index);

			}
			index++;
		}

	}

	public static void atualizarPratoArquivo(Prato itemPrato, int index) throws IOException {
		// NECESSITA PADRONIZAR COMO AS INFORMAÇÕES IRÃO SAIR NO ARQUIVO.
		Path path = Paths.get("d:\\Eclipse\\atv3\\pratos.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.set(index, itemPrato.nome + ";" + itemPrato.preco);
		Files.write(path, lines, StandardCharsets.UTF_8);
	}

	public static void editarBebida(Cardapio cardapio) throws IOException {

		System.out.println("DIGITE O NOME DA BEBIDA PARA ALTERAR: ");
		Scanner leitor = new Scanner(System.in);
//		leitor.nextLine();
		String bebidaEditar = leitor.nextLine();
		int index = 1;
		String modificar;

		for (Bebida itemBebida : cardapio.listaBebidas) {
			if (itemBebida.nome.contains(bebidaEditar)) {

				System.out.println("BEBIDA ENCONTRADA: " + itemBebida.nome + "\t" + "VALOR: " + itemBebida.preco);
				System.out.println("DIGITE 'S' PARA MODIFICAR O NOME OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();

				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O NOME DESEJADO PARA A BEBIDA: ");
					String novoNomeItem = leitor.nextLine();
					itemBebida.nome = novoNomeItem;
				}
				System.out.println("DIGITE 'S' PARA MODIFICAR O PREÇO OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();
				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O PRECO DESEJADO PARA A BEBIDA: ");
					double novoPrecoItem = leitor.nextDouble();
					itemBebida.preco = novoPrecoItem;
				}
				atualizarBebidaArquivo(itemBebida, index);

			}
			index++;
		}
	}

	public static void atualizarBebidaArquivo(Bebida itemBebida, int index) throws IOException {

		// NECESSITA PADRONIZAR PARA O ARQUIVO FINAL.
		Path path = Paths.get("d:\\Eclipse\\atv3\\bebidas-tabuladas.txt");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.set(index, itemBebida.preco + "\t" + itemBebida.nome);
		Files.write(path, lines, StandardCharsets.UTF_8);
	}

	public static void editarVinho(Cardapio cardapio) throws IOException {

		System.out.println("DIGITE O NOME DO VINHO PARA ALTERAR: ");
		Scanner leitor = new Scanner(System.in);
//		leitor.nextLine();
		String vinhoEditar = leitor.nextLine();
		int index = 1;
		String modificar;

		for (Vinho itemVinho : cardapio.listaVinhos) {
			if (itemVinho.nome.contains(vinhoEditar)) {

				System.out.println("VINHO ENCONTRADO: " + itemVinho.nome + "\t" + "VALOR: " + itemVinho.preco);
				System.out.println("DIGITE 'S' PARA MODIFICAR O NOME OU 'N' PARA CONTINUAR");
//				leitor.nextLine();
				modificar = leitor.nextLine();

				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O NOME DESEJADO PARA O VINHO: ");
					String novoNomeItem = leitor.nextLine();
					itemVinho.nome = novoNomeItem;
				}
				System.out.println("DIGITE 'S' PARA MODIFICAR O PREÇO OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();
				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O PRECO DESEJADO PARA O VINHO: ");
					double novoPrecoItem = leitor.nextDouble();
					itemVinho.preco = novoPrecoItem;
				}
				atualizarVinhoArquivo(itemVinho, index);

			}
			index++;
		}
	}

	public static void atualizarVinhoArquivo(Vinho itemVinho, int index) throws IOException {

		Path path = Paths.get("d:\\Eclipse\\atv3\\vinhos-tabulados.txt");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.set(index, itemVinho.preco + "\t" + itemVinho.nome);
		Files.write(path, lines, StandardCharsets.UTF_8);

	}

}
