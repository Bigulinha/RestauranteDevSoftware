package br.edu.up.sistema;
import java.io.BufferedWriter;
import java.io.File;
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
	public static void arquivoPedido(List<Pedido> listaPedidos){

		int idPedido = 0;
		double totalVendas = 0.00;
		File arquivoPedido = new File("..\\Restaurante\\src\\arquivos\\arquivoPedidos.txt");
		BufferedWriter gravadorPedido;
		try {
			gravadorPedido = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(arquivoPedido.getAbsolutePath(), true), // Append arquivo
							StandardCharsets.UTF_8 									 // Set encoding
					));
			File arquivoIndexUltimoPedido = new File("..\\Restaurante\\src\\arquivos\\indexUltimoPedido.txt");
			BufferedWriter gravadorUltimoIndex = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(arquivoIndexUltimoPedido.getAbsolutePath(), true), // Append arquivo
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

			File arquivoGravacao = new File("..\\Restaurante\\src\\arquivos\\indexUltimoPedido.txt");
			PrintWriter gravadorIndex = new PrintWriter(arquivoGravacao.getAbsolutePath());

			gravadorIndex.println(idPedido);
			gravadorIndex.println(totalVendas);

			gravadorIndex.close();
			gravadorPedido.close();

		} catch (IOException e) {
			System.out.println("Falha no caminho do arquivo 'arquivoPedidos'!");
			e.printStackTrace();
		}


	}

	public static void salvarPrato(Prato prato){
		File file = new File("..\\Restaurante\\src\\arquivos\\pratos.csv");
		BufferedWriter out;
		try {
			out = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(file.getAbsolutePath(), true), // Append arquivo
							StandardCharsets.UTF_8                  // Set encoding
							)
					);
			out.write("\n" + prato.getNome() + ";" +  prato.getPrecoFormatado().replaceAll(",", "."));
			out.close();
		} catch (IOException e) {
			System.out.println("Falha no caminho do arquivo 'pratos.csv'!");
		}	
		
	}

	public static void salvarBebida(Bebida bebida){
		File file = new File("..\\Restaurante\\src\\arquivos\\bebidas-tabuladas.txt");
		BufferedWriter out;
		try {
			out = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(file.getAbsolutePath(), true), // Append arquivo
							StandardCharsets.UTF_8                  // Set encoding
							)
					);
			out.write("\n" + bebida.getPrecoFormatado() + "\t" +  bebida.getNome());
			out.close();
			
		} catch (IOException e) {
			System.out.println("Falha no caminho do arquivo 'bebidas-tabuladas.txt'!");
		}	

	}
	
	public static void salvarVinho(Vinho vinho){
		File file = new File("..\\Restaurante\\src\\arquivos\\vinhos-tabulados.txt");
		BufferedWriter out;
		try {
			out = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(file.getAbsolutePath(), true), // Append arquivo
							StandardCharsets.UTF_8                  // Set encoding
							)
					);
			out.write("\n" + vinho.getPrecoFormatado().replaceAll(",", ".") + "\t" + vinho.getNome());
			out.close();
			
			
		} catch (IOException e) {
			System.out.println("Falha no caminho do arquivo 'vinhos-tabuladas.txt'!");
		}	

	}
}
