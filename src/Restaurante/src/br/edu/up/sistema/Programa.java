package br.edu.up.sistema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.crud.Consultar;
import br.edu.up.dominio.Cardapio;
import br.edu.up.dominio.Pedido;
import br.edu.up.dominio.Menu;

public class Programa {

	public static void main(String[] args) throws IOException {
		
//		File arquivo = new File ("../arquivo/pratos.csv");
//		System.out.println(arquivo.getAbsolutePath());
		
		
		Cardapio cardapio = new Cardapio();

		List<Pedido> listaPedidos = new ArrayList<Pedido>();

		cardapio.inicializarCardapio();

		Menu.menuInicial(cardapio, listaPedidos);

	}
}