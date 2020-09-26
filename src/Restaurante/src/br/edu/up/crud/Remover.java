package br.edu.up.crud;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Cardapio;
import br.edu.up.dominio.Prato;

public class Remover {

	public static void removerPrato(Cardapio cardapio) throws IOException {
		System.out.println("DIGITE O NOME DO PRATO PARA REMOVER: ");
		Scanner leitor = new Scanner(System.in);
//		leitor.nextLine();
		String pratoRemover = leitor.nextLine();
//		int index = 0;
		for (int i=cardapio.listaPratos.size() -1 ; i>=0; i--) {
			if (cardapio.listaPratos.get(i).nome.contains(pratoRemover)) {
				System.out.println("Prato encontrado: " + cardapio.listaPratos.get(i).nome + "\t" + "VALOR: " + cardapio.listaPratos.get(i).preco);
				cardapio.listaPratos.remove(i);
			}
//			index++;
		}

//		for (Prato itemPrato : cardapio.listaPratos) {

			

//		}
		File file = new File("d:\\Eclipse\\atv3\\pratos.csv");
		BufferedWriter gravadorPedido = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), // Append
																												// arquivo
				StandardCharsets.UTF_8 // Set encoding
		));
		
		gravadorPedido.write("PRATO;PRECO\n");
		for (Prato listaPrato : cardapio.listaPratos) {
			gravadorPedido.write(listaPrato.nome + ";" + listaPrato.preco + "\n");
		}
		gravadorPedido.close();
		
	}

	public static void removerBebida(Cardapio cardapio) {
		// TODO Auto-generated method stub

	}

	public static void removerVinho(Cardapio cardapio) {
		// TODO Auto-generated method stub

	}

}
