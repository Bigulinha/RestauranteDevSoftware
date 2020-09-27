package br.edu.up.crud;
import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Cardapio;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Consultar {

	
	public static void listarProdutos(Cardapio cardapio) {
		System.out.println("=================================================================\nPRATOS:");
		
		for (Prato pratos : cardapio.listaPratos) {
			System.out.println(pratos.getPreco() + "\t" + pratos.getNome());
		}
		System.out.println("=================================================================\nBEBIDAS:");
		
		for (Bebida bebidas : cardapio.listaBebidas) {
			System.out.println( bebidas.getPreco() + "\t" + bebidas.getNome());
		}
		System.out.println("=================================================================\nVINHOS: ");
		for (Vinho vinhos : cardapio.listaVinhos) {
			System.out.println(vinhos.getPreco() + "\t" +vinhos.getNome() );
		}
		System.out.println("\n");
	}
}