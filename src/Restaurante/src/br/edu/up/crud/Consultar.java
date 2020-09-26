package br.edu.up.crud;

import java.util.List;

import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Cardapio;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Consultar {

	
	public static void listarProdutos(Cardapio cardapio) {
		System.out.println("=================================================================\nPRATOS:");
		
		for (Prato pratos : cardapio.listaPratos) {
			System.out.println(pratos.nome + "\t" + pratos.preco);
		}
		System.out.println("=================================================================\nBEBIDAS:");
		
		for (Bebida bebidas : cardapio.listaBebidas) {
			System.out.println(bebidas.nome + "\t" + bebidas.preco);
		}
		System.out.println("=================================================================\nVINHOS: ");
		for (Vinho vinhos : cardapio.listaVinhos) {
			System.out.println(vinhos.nome + "\t" + vinhos.preco);
		}
		System.out.println("\n");
	}
}