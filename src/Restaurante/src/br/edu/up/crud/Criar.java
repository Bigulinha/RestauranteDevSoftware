package br.edu.up.crud;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Criar {

	public void incluirPrato(List<Prato> listaPratos) throws IOException {

		Prato prato = new Prato();

		Scanner leitor = new Scanner(System.in);

		System.out.println("DIGITE O NOME DO PRATO QUE DESEJA ADICIONAR NO CARDAPIO");
		prato.nome = leitor.nextLine();
		System.out.println("DIGITE O PREÇO DO PRATO INCLUIDO");
		prato.preco = Double.parseDouble(leitor.nextLine().replaceAll(",", "."));

		listaPratos.add(prato);

		// leitor.close();

	}

	public void incluirBebida(List<Bebida> listaBebidas) throws IOException {

		Bebida bebida = new Bebida();

		Scanner leitor = new Scanner(System.in);

		System.out.println("DIGITE O NOME DA BEBIDA QUE DESEJA ADICIONAR NO CARDAPIO");
		bebida.nome = leitor.nextLine();
		System.out.println("DIGITE O PREÇO DA BEBIDA INCLUIDA");
		bebida.preco = Double.parseDouble(leitor.nextLine().replaceAll(",", "."));

		listaBebidas.add(bebida);

		// leitor.close();

	}

	public void incluirVinho(List<Vinho> listaVinhos) throws IOException {
		
		Vinho vinhos = new Vinho();
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("DIGITE O NOME DO VINHO QUE DESEJA ADICIONAR NO CARDAPIO");
		vinhos.nome = leitor.nextLine();
		System.out.println("DIGITE O PREÇO DO VINHO INCLUIDO");
		vinhos.preco = Double.parseDouble(leitor.nextLine().replaceAll(",", "."));
		
		Vinho vinho = new Vinho(vinhos.preco, vinhos.nome);
		Vinho.Incluir(listaVinhos, vinho);
		
//		Armazenamento.salvarVinho();

		
//		listaVinhos.add(vinhos);
		

		// leitor.close();

	}
	


}
