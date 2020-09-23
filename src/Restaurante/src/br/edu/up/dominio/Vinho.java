package br.edu.up.dominio;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

public class Vinho {

	public String nome;
	public double preco;
	public String observacao;
	
	public Vinho() {
	}
	public Vinho(double preco, String nome) {
		this.preco = preco;
		this.nome = nome;
	}


	public String getPrecoFormatado() {
		
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);
		return nf.format(preco);
	}
	
	public static void Incluir(List<Vinho> listaVinhos, Vinho vinho) {
		listaVinhos.add(vinho);
	}
}
