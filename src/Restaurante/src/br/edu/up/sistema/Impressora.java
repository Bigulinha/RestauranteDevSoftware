package br.edu.up.sistema;

import java.util.List;

import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Impressora {

	public void imprimirPratos(List<Prato> listaPratos) {

		System.out.println("PRATOS");
		for (int i = 0; i < listaPratos.size(); i++) {
			System.out.println("PRATO " + (i + 1));
			System.out.println("NOME: " + listaPratos.get(i).getNome());
			System.out.println("PREÇO: R$" + listaPratos.get(i).getPrecoFormatado());
			System.out.println("=================================================================");
		}
	}

	public void imprimirBebidas(List<Bebida> listaBebidas) {

		System.out.println("BEBIDAS");
		for (int i = 0; i < listaBebidas.size(); i++) {
			System.out.println("BEBIDA " + (i + 1));
			System.out.println("NOME: " + listaBebidas.get(i).getNome());
			System.out.println("PREÇO: R$" + listaBebidas.get(i).getPrecoFormatado());
			System.out.println("=================================================================");
		}
	}

	public void imprimirVinhos(List<Vinho> listaVinhos) {

		System.out.println("VINHOS");
		for (int i = 0; i < listaVinhos.size(); i++) {
			System.out.println("VINHO " + (i + 1));
			System.out.println("NOME: " + listaVinhos.get(i).getNome());
			System.out.println("PREÇO: R$" + listaVinhos.get(i).getPrecoFormatado());
			System.out.println("=================================================================");
		}
	}

}
