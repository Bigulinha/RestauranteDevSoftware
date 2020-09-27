package br.edu.up.dominio;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

public class Vinho {

	private String nome;
	private double preco;
	private String observacao;
	
	public Vinho() {
	}
	public Vinho(double preco, String nome) {
		this.setPreco(preco);
		this.setNome(nome);
	}


	public String getPrecoFormatado() {
		
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);
		return nf.format(getPreco());
	}
	
	public static void Incluir(List<Vinho> listaVinhos, Vinho vinho) {
		listaVinhos.add(vinho);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
