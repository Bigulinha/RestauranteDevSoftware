package br.edu.up.sistema;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Pedido;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Armazenamento {
	public static void arquivoPedido(List<Pedido> listaPedidos) throws IOException {

		int idPedido = 0;
		double totalVendas = 0.00;
		File arquivoPedido = new File("d:\\Eclipse\\atv3\\arquivoPedidos.txt");
		BufferedWriter gravadorPedido = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(arquivoPedido, true), // Append arquivo
						StandardCharsets.UTF_8 									 // Set encoding
				));

		File arquivoIndexUltimoPedido = new File("d:\\Eclipse\\atv3\\indexUltimoPedido.txt");
		BufferedWriter gravadorUltimoIndex = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(arquivoIndexUltimoPedido, true), // Append arquivo
						StandardCharsets.UTF_8 												// Set encoding
				));

		Scanner leitorIndex = new Scanner(arquivoIndexUltimoPedido);
		
		while (leitorIndex.hasNext()) {
			String ultimoIndex = leitorIndex.nextLine();
			idPedido = Integer.parseInt(ultimoIndex);
			String ultimoValorTotal = leitorIndex.nextLine();
			totalVendas = Double.parseDouble(ultimoValorTotal);
		}

		double valorTotal = 0;
		for (int i = 0; i < listaPedidos.size(); i++) {
			valorTotal += listaPedidos.get(i).total;
			gravadorPedido.write("PEDIDO " + (idPedido + 1) + "\r\n");
			listaPedidos.get(i).gravarPedido(gravadorPedido);
			idPedido++;
		}

		totalVendas += valorTotal;
		gravadorPedido.write("O VALOR TOTAL DESTA SESSÃO É DE: R$" + Pedido.getTotalFormatado(valorTotal) + "\n");
		gravadorPedido.write("=================================================================");
		gravadorPedido.write("\nO VALOR TOTAL DE TODOS OS PEDIDOS ANTERIORES É DE: R$"
				+ Pedido.getTotalFormatado(totalVendas) + "\n");
		gravadorPedido.write("=================================================================\n");

		File arquivoGravacao = new File("d:\\Eclipse\\atv3\\indexUltimoPedido.txt");
		PrintWriter gravadorIndex = new PrintWriter(arquivoGravacao);

		gravadorIndex.println(idPedido);
		gravadorIndex.println(totalVendas);

		gravadorIndex.close();
		gravadorPedido.close();

	}

	public static void salvarPrato(Prato prato) throws IOException {
		File file = new File("D:\\Eclipse\\atv3\\pratos.csv");
		BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file, true), // Append arquivo
						StandardCharsets.UTF_8                  // Set encoding
						)
				);	
		out.write("\n" + prato.nome + ";" +  prato.getPrecoFormatado().replaceAll(",", "."));
		out.close();
		
	}

	public static void salvarBebida(Bebida bebida) throws IOException {
		File file = new File("D:\\Eclipse\\atv3\\bebidas-tabuladas.txt");
		BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file, true), // Append arquivo
						StandardCharsets.UTF_8                  // Set encoding
						)
				);	
		out.write("\n" + bebida.getPrecoFormatado() + "\t" +  bebida.nome);
		out.close();
		
	}
	
	public static void salvarVinho(Vinho vinho) throws IOException {
		File file = new File("D:\\Eclipse\\atv3\\vinhos-tabulados.txt");
		BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file, true), // Append arquivo
						StandardCharsets.UTF_8                  // Set encoding
						)
				);	
		out.write("\n" + vinho.getPrecoFormatado().replaceAll(",", ".") + "\t" + vinho.nome);
		out.close();
		
	}
}
