package br.edu.up.crud;


import java.io.IOException;
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

	public static void editarPrato(Cardapio cardapio){
		System.out.println("DIGITE O NOME DO PRATO PARA ALTERAR: ");
		Scanner leitor = new Scanner(System.in);
//		leitor.nextLine();
		String pratoEditar = leitor.nextLine();
		int index = 1;
		String modificar;

		for (Prato itemPrato : cardapio.listaPratos) {
			if (itemPrato.getNome().contains(pratoEditar)) {

				System.out.println("Prato encontrado: " + itemPrato.getNome() + "\t" + "VALOR: " + itemPrato.getPreco());
				System.out.println("DIGITE 'S' PARA MODIFICAR O NOME OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();

				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O NOME DESEJADO PARA O PRATO: ");
					String novoNomeItem = leitor.nextLine();
					itemPrato.setNome(novoNomeItem);
				}
				System.out.println("DIGITE 'S' PARA MODIFICAR O PREÇO OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();
				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O PRECO DESEJADO PARA O PRATO: ");
					double novoPrecoItem = leitor.nextDouble();
					itemPrato.setPreco(novoPrecoItem);
				}
					atualizarPratoArquivo(itemPrato, index);
			}
			index++;
		}

	}

	public static void atualizarPratoArquivo(Prato itemPrato, int index){
		// NECESSITA PADRONIZAR COMO AS INFORMAÇÕES IRÃO SAIR NO ARQUIVO.
		Path path = Paths.get("..\\Restaurante\\src\\arquivos\\pratos.csv");
		List<String> lines;
		try {
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			lines.set(index, itemPrato.getNome() + ";" + itemPrato.getPreco());
			Files.write(path, lines, StandardCharsets.UTF_8);
			System.out.println("PRATO ATUALIZADO COM SUCESSO\n");
		} catch (IOException e) {
			System.out.println("Erro no processamento do comando 'write'!");
		}
	}

	public static void editarBebida(Cardapio cardapio){

		System.out.println("DIGITE O NOME DA BEBIDA PARA ALTERAR: ");
		Scanner leitor = new Scanner(System.in);
//		leitor.nextLine();
		String bebidaEditar = leitor.nextLine();
		int index = 1;
		String modificar;

		for (Bebida itemBebida : cardapio.listaBebidas) {
			if (itemBebida.getNome().contains(bebidaEditar)) {

				System.out.println("BEBIDA ENCONTRADA: " + itemBebida.getNome() + "\t" + "VALOR: " + itemBebida.getPreco());
				System.out.println("DIGITE 'S' PARA MODIFICAR O NOME OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();

				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O NOME DESEJADO PARA A BEBIDA: ");
					String novoNomeItem = leitor.nextLine();
					itemBebida.setNome(novoNomeItem);
				}
				System.out.println("DIGITE 'S' PARA MODIFICAR O PREÇO OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();
				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O PRECO DESEJADO PARA A BEBIDA: ");
					double novoPrecoItem = leitor.nextDouble();
					itemBebida.setPreco(novoPrecoItem);
				}
				atualizarBebidaArquivo(itemBebida, index);
				

			}
			index++;
		}
	}

	public static void atualizarBebidaArquivo(Bebida itemBebida, int index){

		// NECESSITA PADRONIZAR PARA O ARQUIVO FINAL.
		Path path = Paths.get("..\\Restaurante\\src\\arquivos\\bebidas-tabuladas.txt");
		List<String> lines;
		try {
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			lines.set(index, itemBebida.getPreco() + "\t" + itemBebida.getNome());
			Files.write(path, lines, StandardCharsets.UTF_8);
			System.out.println("BEBIDA ATUALIZADA COM SUCESSO\n");
		} catch (IOException e) {
			System.out.println("Erro na chamada da função 'write'!");
		}
	}

	public static void editarVinho(Cardapio cardapio){

		System.out.println("DIGITE O NOME DO VINHO PARA ALTERAR: ");
		Scanner leitor = new Scanner(System.in);
//		leitor.nextLine();
		String vinhoEditar = leitor.nextLine();
		int index = 1;
		String modificar;

		for (Vinho itemVinho : cardapio.listaVinhos) {
			if (itemVinho.getNome().contains(vinhoEditar)) {

				System.out.println("VINHO ENCONTRADO: " + itemVinho.getNome() + "\t" + "VALOR: " + itemVinho.getPreco());
				System.out.println("DIGITE 'S' PARA MODIFICAR O NOME OU 'N' PARA CONTINUAR");
//				leitor.nextLine();
				modificar = leitor.nextLine();

				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O NOME DESEJADO PARA O VINHO: ");
					String novoNomeItem = leitor.nextLine();
					itemVinho.setNome(novoNomeItem);
				}
				System.out.println("DIGITE 'S' PARA MODIFICAR O PREÇO OU 'N' PARA CONTINUAR");
				modificar = leitor.nextLine();
				if ((int) modificar.charAt(0) == (int) 's') {
					System.out.println("DIGITE O PRECO DESEJADO PARA O VINHO: ");
					double novoPrecoItem = leitor.nextDouble();
					itemVinho.setPreco(novoPrecoItem);
				}
				atualizarVinhoArquivo(itemVinho, index);

			}
			index++;
		}
	}

	public static void atualizarVinhoArquivo(Vinho itemVinho, int index){

		Path path = Paths.get("..\\Restaurante\\src\\arquivos\\vinhos-tabulados.txt");
		List<String> lines;
		try {
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			lines.set(index, itemVinho.getPreco() + "\t" + itemVinho.getNome());
			Files.write(path, lines, StandardCharsets.UTF_8);
			System.out.println("VINHO ATUALIZADO COM SUCESSO\n");
		} catch (IOException e) {
			System.out.println("Erro na chamada da função 'write'");
		}

	}

}
