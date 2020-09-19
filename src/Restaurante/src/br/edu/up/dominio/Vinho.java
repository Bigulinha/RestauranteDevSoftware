package br.edu.up.dominio;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Vinho {

	public String nome;
	public double preco;
	public String observacao;
	
	public String getPrecoFormatado() {
		
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);
		return nf.format(preco);
	}
}
