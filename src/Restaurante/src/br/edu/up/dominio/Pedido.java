package br.edu.up.dominio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


public class Pedido {

	public double total = 0;

	public List<Prato> listaPratos = new ArrayList<Prato>();
	public List<Bebida> listaBebidas = new ArrayList<Bebida>();
	public List<Vinho> listaVinhos = new ArrayList<Vinho>();

	public String getTotalFormatado() {

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);
		return nf.format(total);
	}

	public void imprimirPratos() {

		if (listaPratos.size() > 0) {
			System.out.println("PRATO(S)");
			for (int i = 0; i < listaPratos.size(); i++) {

				System.out.println("PRATO " + (i + 1));
				System.out.println("NOME: " + listaPratos.get(i).nome);
				System.out.println("OBSERVAÇÃO: " + listaPratos.get(i).observacao);
				System.out.println("PREÇO: R$" + listaPratos.get(i).getPrecoFormatado());
				System.out.println("=================================================================");

			}
		}
	}

	public void imprimirBebidas() {

		if (listaBebidas.size() > 0) {
			System.out.println("BEBIDA(S)");
			for (int i = 0; i < listaBebidas.size(); i++) {

				System.out.println("BEBIDA " + (i + 1));
				System.out.println("NOME: " + listaBebidas.get(i).nome);
				System.out.println("OBSERVAÇÃO: " + listaBebidas.get(i).observacao);
				System.out.println("PREÇO: R$" + listaBebidas.get(i).getPrecoFormatado());
				System.out.println("=================================================================");

			}
		}
	}

	public void imprimirVinhos() {

		if (listaVinhos.size() > 0) {
			System.out.println("VINHO(S)");
			for (int i = 0; i < listaVinhos.size(); i++) {

				System.out.println("VINHO " + (i + 1));
				System.out.println("NOME: " + listaVinhos.get(i).nome);
				System.out.println("OBSERVAÇÃO: " + listaVinhos.get(i).observacao);
				System.out.println("PREÇO: R$" + listaVinhos.get(i).getPrecoFormatado());
				System.out.println("=================================================================");

			}
		}
	}

	public void setTotal() {
		total = 0;
		for (int i = 0; i < listaPratos.size(); i++) {
			total += listaPratos.get(i).preco;
		}

		for (int i = 0; i < listaBebidas.size(); i++) {
			total += listaBebidas.get(i).preco;
		}

		for (int i = 0; i < listaVinhos.size(); i++) {
			total += listaVinhos.get(i).preco;
		}
	}

	public void imprimirPedido() {

		imprimirPratos();
		imprimirBebidas();
		imprimirVinhos();
		setTotal();

		System.out.println("O VALOR TOTAL FOI DE: R$" + getTotalFormatado());

		System.out.println("=================================================================");

	}

	public void gravarPratos(BufferedWriter gravadorPedido) {

		try {
			if (listaPratos.size() > 0) {
				gravadorPedido.write("PRATO(S) \r\n");
				for (int i = 0; i < listaPratos.size(); i++) {

					gravadorPedido.write("PRATO " + (i + 1) + "\r\n");
					gravadorPedido.write("NOME: " + listaPratos.get(i).nome + "\r\n");
					gravadorPedido.write("OBSERVAÇÃO: " + listaPratos.get(i).observacao + "\r\n");
					gravadorPedido.write("PREÇO: R$" + listaPratos.get(i).getPrecoFormatado() + "\r\n");
					gravadorPedido.write("=================================================================" + "\r\n");
				}
			}

		} catch (IOException e) {
			System.out.println("Problema nas atribuições do comando 'write'!");
		}

	}

	public void gravarBebidas(BufferedWriter gravadorPedido) {

		try {
			if (listaBebidas.size() > 0) {
				gravadorPedido.write("BEBIDA(S) \r\n");
				for (int i = 0; i < listaBebidas.size(); i++) {

					gravadorPedido.write("BEBIDA " + (i + 1) + "\r\n");
					gravadorPedido.write("NOME: " + listaBebidas.get(i).nome + "\r\n");
					gravadorPedido.write("OBSERVAÇÃO: " + listaBebidas.get(i).observacao + "\r\n");
					gravadorPedido.write("PREÇO: R$" + listaBebidas.get(i).getPrecoFormatado() + "\r\n");
					gravadorPedido.write("=================================================================" + "\r\n");

				}
			}

		} catch (IOException e) {
			System.out.println("Problema nas atribuições do comando 'write'!");
		}
	}

	public void gravarVinhos(BufferedWriter gravadorPedido) {

		try {
			if (listaVinhos.size() > 0) {
				gravadorPedido.write("VINHO(S) \r\n");
				for (int i = 0; i < listaVinhos.size(); i++) {

					gravadorPedido.write("VINHO " + (i + 1) + "\r\n");
					gravadorPedido.write("NOME: " + listaVinhos.get(i).nome + "\r\n");
					gravadorPedido.write("OBSERVAÇÃO: " + listaVinhos.get(i).observacao + "\r\n");
					gravadorPedido.write("PREÇO: R$" + listaVinhos.get(i).getPrecoFormatado() + "\r\n");
					gravadorPedido.write("=================================================================" + "\r\n");

				}
			}
		} catch (IOException e) {
			System.out.println("Problema nas atribuições do comando 'write'!");

		}
	}

	public void gravarPedido(BufferedWriter gravadorPedido){

		gravarPratos(gravadorPedido);
		gravarBebidas(gravadorPedido);
		gravarVinhos(gravadorPedido);
		setTotal();

		try {
			gravadorPedido.write("O VALOR TOTAL FOI DE: R$" + getTotalFormatado() + "\r\n");
			gravadorPedido.write("=================================================================" + "\r\n");
		} catch (IOException e) {
			System.out.println("Problema nas atribuições do comando 'write'!");

		}


	}

	public static void finalizarPedido(Pedido pedido, List<Pedido> listaPedidos) {

		pedido.getTotalFormatado();
		pedido.imprimirPedido();

		listaPedidos.add(pedido);

	}

	public static void vizualizarPedidos(List<Pedido> listaPedidos) {

		double valorTotal = 0;
		for (int i = 0; i < listaPedidos.size(); i++) {
			valorTotal += listaPedidos.get(i).total;
			System.out.println("PEDIDO " + (i + 1));
			listaPedidos.get(i).imprimirPedido();
		}

		System.out.println("O VALOR TOTAL É DE: R$" + getTotalFormatado(valorTotal));
	}

	public static String getTotalFormatado(double totalValor) {

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);
		return nf.format(totalValor);
	}

}
