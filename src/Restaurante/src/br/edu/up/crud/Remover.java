package br.edu.up.crud;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Cardapio;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Remover {

	public static void removerPrato(Cardapio cardapio){
		System.out.println("DIGITE O NOME DO PRATO PARA REMOVER: ");
		Scanner leitor = new Scanner(System.in);

		String pratoRemover = leitor.nextLine();
		for (int i = cardapio.listaPratos.size() - 1; i >= 0; i--) {
			if (cardapio.listaPratos.get(i).getNome().contains(pratoRemover)) {
				System.out.println("Prato encontrado: " + cardapio.listaPratos.get(i).getNome() + "\t" + "VALOR: "
						+ cardapio.listaPratos.get(i).getPreco());
				cardapio.listaPratos.remove(i);
			}
		}
		
		File file = new File("..\\Restaurante\\src\\arquivos\\pratos.csv");
		BufferedWriter gravadorPedido;
		try {
			gravadorPedido = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()), // Append
							// arquivo
							StandardCharsets.UTF_8 // Set encoding
					));
			gravadorPedido.write("PRATO;PRECO");
			for (Prato listaPrato : cardapio.listaPratos) {
				
				gravadorPedido.write("\n" + listaPrato.getNome() + ";" + listaPrato.getPreco());
			}
			gravadorPedido.close();
		} catch (IOException e) {
			System.out.println("Erro na chamada da função 'FileOutputStream ou Write'");
		}


	}

	public static void removerBebida(Cardapio cardapio){
		System.out.println("DIGITE O NOME DA BEBIDA PARA REMOVER: ");
		Scanner leitor = new Scanner(System.in);

		String bebidaRemover = leitor.nextLine();
		for (int i = cardapio.listaBebidas.size() - 1; i >= 0; i--) {
			if (cardapio.listaBebidas.get(i).getNome().contains(bebidaRemover)) {
				System.out.println("BEBIDA ENCONTRADA: " + cardapio.listaBebidas.get(i).getNome() + "\t" + "VALOR: "
						+ cardapio.listaBebidas.get(i).getPreco());
				cardapio.listaBebidas.remove(i);
			}
		}
		File file = new File("..\\Restaurante\\src\\arquivos\\bebidas-tabuladas.txt");
		BufferedWriter gravadorPedido;
		try {
			gravadorPedido = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()), // Append
							StandardCharsets.UTF_8 // Set encoding
					));
			gravadorPedido.write("PREÇO;BEBIDA");
			for (Bebida listaBebida : cardapio.listaBebidas) {
				gravadorPedido.write("\n" + listaBebida.getPreco() + "\t" + listaBebida.getNome());
			}
			gravadorPedido.close();
		} catch (IOException e) {
			System.out.println("Erro na chamada da função 'FileOutputStream ou Write'");
		}


	}

	public static void removerVinho(Cardapio cardapio){
		System.out.println("DIGITE O NOME DO VINHO PARA REMOVER: ");
		Scanner leitor = new Scanner(System.in);

		String vinhoRemover = leitor.nextLine();
		for (int i = cardapio.listaVinhos.size() - 1; i >= 0; i--) {
			if (cardapio.listaVinhos.get(i).getNome().contains(vinhoRemover)) {
				System.out.println("VINHO ENCONTRADO: " + cardapio.listaVinhos.get(i).getNome() + "\t" + "VALOR: "
						+ cardapio.listaVinhos.get(i).getPreco());
				cardapio.listaVinhos.remove(i);
			}
		}
		File file = new File("..\\Restaurante\\src\\arquivos\\vinhos-tabulados.txt");
		BufferedWriter gravadorPedido;
		try {
			gravadorPedido = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()), // Append
							// arquivo
							StandardCharsets.UTF_8 // Set encoding
					));
			gravadorPedido.write("PRECO;VINHO");
			for (Vinho listaVinho : cardapio.listaVinhos) {
				gravadorPedido.write("\n" + listaVinho.getPreco() + "\t" + listaVinho.getNome());
			}
			gravadorPedido.close();
		} catch (IOException e) {
			System.out.println("Erro na chamada da função 'FileOutputStream ou Write'");
		}


	}

}
