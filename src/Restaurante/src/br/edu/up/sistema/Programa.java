package br.edu.up.sistema;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Cardapio;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;
import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Pedido;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		Cardapio cardapio = new Cardapio();
		
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		
		
		
		cardapio.inicializarCardapio();
		
		
		menuInicial(cardapio, listaPedidos);
		
		//cardapio.imprimirPratos();
		//cardapio.imprimirBebidas();
		//cardapio.imprimirPratos();
				

	}
	
public static String getTotalFormatado(double totalValor) {
		
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);
		return nf.format(totalValor);
	}
	
	public static void menuInicial(Cardapio cardapio, List<Pedido> listaPedidos) throws IOException {
		
		Scanner leitor = new Scanner(System.in);
        int opcao = -1;
        
        while(opcao != 0) {
        	
        	System.out.println("DIGITE A OPÇÃO DESEJADA: ");
    		System.out.println("INCLUIR ITEM NO CARDAPIO: 1");
    		System.out.println("FAZER PEDIDO: 2");
    		System.out.println("VIZUALIZAR PEDIDOS: 3");
    		System.out.println("SAIR DO PROGRAMA: 0");
    		opcao = leitor.nextInt();

    		//leitor.close();
    		
    		switch(opcao) {
    		case 1:
    			incluirItemCardapio(cardapio, listaPedidos);
    			break;
    		case 2:
    			escolherCardapio(cardapio, listaPedidos);
    			break;
    		case 3:
    			vizualizarPedidos(listaPedidos);
    			break;
    		case 0:
    			arquivoPedido(listaPedidos);
    			return;
    		default:
            	System.out.println("Opção invalida!");
            	menuInicial(cardapio, listaPedidos);
            	break; 
    		}
        }		
	}
	
	public static void escolherCardapio(Cardapio cardapio, List<Pedido> listaPedidos) throws IOException {
		
		Pedido pedido = new Pedido();
		
		Scanner leitor = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao != 4) {
	        System.out.println("DIGITE A OPÇÃO DESEJADA: ");
	        System.out.println("ESCOLHER PRATO: 1");
	        System.out.println("ESCOLHER BEBIDA: 2");
	        System.out.println("ESCOLHER VINHO: 3");
	        System.out.println("FINALIZAR PEDIDO: 4");
	        System.out.println("VOLTAR PARA O MENU INICIAL: 0");
	        opcao = leitor.nextInt();
	
	        //leitor.close();
	        
	        switch(opcao) {
	        case 1:
	        	pedido = selecionarPrato(cardapio, listaPedidos, pedido);
	        	break;
	        case 2:
	        	pedido = selecionarBebida(cardapio, listaPedidos, pedido);
	        	break;
	        case 3:
	        	pedido = selecionarVinho(cardapio, listaPedidos, pedido);
	        	break;
	        case 4:
	        	finalizarPedido(pedido, listaPedidos);
	        	//menuInicial(cardapio, listaPedidos);
	        	//break;
	        	return;
	        case 0:
	        	//menuInicial(cardapio, listaPedidos);
	        	//break;
	        	return;
	        default:
	        	System.out.println("Opção invalida!");
	        	//escolherCardapio(cardapio, listaPedidos);
	        	break;        	        		
	        }
        }
        
        //escolherCardapio(cardapio, listaPedidos);
                
	}
	
	public static Pedido selecionarPrato(Cardapio cardapio, List<Pedido> listaPedidos, Pedido pedido) throws IOException{
		
		cardapio.imprimirPratos(); 	
		
		Scanner leitor = new Scanner(System.in);
        int opcao;
        String observacao;
        Prato prato = null;
        while(prato == null) {
			System.out.println("ESCOLHA O PRATO DESEJADO OU DIGITE 0 PARA VOLTAR AO MENU INICIAL");
			opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao <= cardapio.listaPratos.size() && opcao >= 1) {
				
				prato = cardapio.listaPratos.get(opcao-1);
				
				System.out.println("DIGITE 'S' SE DESEJA ADICIONAR OBSERVAÇÃO OU 'N' PARA CONTINUAR");
				observacao = leitor.nextLine();
				
				if((int)observacao.charAt(0) == (int)'s') {
					System.out.println("DIGITE A SUA OBSERVAÇÃO: ");
					observacao = leitor.nextLine();
					prato.observacao = observacao;
				}else {
					prato.observacao = "Nenhuma";
				}				
				
				pedido.listaPratos.add(prato);
				
			}
			if(opcao == 0) {
				return pedido;
			}			
        }
        return pedido;
        //leitor.close();
	}
	
	public static Pedido selecionarBebida(Cardapio cardapio, List<Pedido> listaPedidos, Pedido pedido) throws IOException {
		
		cardapio.imprimirBebidas(); 	
		
		Scanner leitor = new Scanner(System.in);
        int opcao;
        String observacao = "";
        Bebida bebida = null;
        while(bebida == null) {
			System.out.println("ESCOLHA A BEBIDA DESEJADA OU DIGITE 0 PARA VOLTAR AO MENU INICIAL");
			opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao <= cardapio.listaBebidas.size() && opcao >= 1) {
				
				bebida = cardapio.listaBebidas.get(opcao-1);
				
				System.out.println("DIGITE 'S' SE DESEJA ADICIONAR OBSERVAÇÃO OU 'N' PARA CONTINUAR");
				observacao = leitor.nextLine();
				
				if((int)observacao.charAt(0) == (int)'s') {
					System.out.println("DIGITE A SUA OBSERVAÇÃO: ");
					observacao = leitor.nextLine();
					bebida.observacao = observacao;
				}else {
					bebida.observacao = "Nenhuma";
				}
				
				pedido.listaBebidas.add(bebida);
			}
			if(opcao == 0) {
				return pedido;
			}
        }
        return pedido;
        
        //leitor.close();
	}
	
	public static Pedido selecionarVinho(Cardapio cardapio, List<Pedido> listaPedidos, Pedido pedido) throws IOException{
		
		cardapio.imprimirVinhos(); 	
		
		Scanner leitor = new Scanner(System.in);
        int opcao;
        String observacao;
        Vinho vinho = null;
        while(vinho == null) {
			System.out.println("ESCOLHA O VINHO DESEJADO OU DIGITE 0 PARA VOLTAR AO MENU INICIAL");
			opcao = leitor.nextInt();
			leitor.nextLine();
			
			if(opcao <= cardapio.listaVinhos.size() && opcao >= 1) {
				
				vinho = cardapio.listaVinhos.get(opcao-1);
				
				System.out.println("DIGITE 'S' SE DESEJA ADICIONAR OBSERVAÇÃO OU 'N' PARA CONTINUAR");
				observacao = leitor.nextLine();
				
				if((int)observacao.charAt(0) == (int)'s') {
					System.out.println("DIGITE A SUA OBSERVAÇÃO: ");
					observacao = leitor.nextLine();
					vinho.observacao = observacao;
				}else {
					vinho.observacao = "Nenhuma";
				}
				
				pedido.listaVinhos.add(vinho);				
				
			}
			if(opcao == 0) {
				return pedido;
			}
        }
        return pedido;        
        
        //leitor.close();
	}
	
	public static void finalizarPedido(Pedido pedido, List<Pedido> listaPedidos) {
		
		pedido.getTotalFormatado();
		pedido.imprimirPedido();
		
		listaPedidos.add(pedido);
		
	}
	
	public static void vizualizarPedidos(List<Pedido> listaPedidos) {
		
		double valorTotal = 0;
		for(int i = 0; i < listaPedidos.size(); i++) {
			valorTotal += listaPedidos.get(i).total;
			System.out.println("PEDIDO " + (i+1));
			listaPedidos.get(i).imprimirPedido();
		}
		
		System.out.println("O VALOR TOTAL É DE: R$" + getTotalFormatado(valorTotal));
	}
	
	public static void incluirItemCardapio(Cardapio cardapio, List<Pedido> listaPedidos) throws IOException {
		
		Scanner leitor = new Scanner(System.in);
        int opcao = -1;
        
		while(opcao != 0) {
			
			System.out.println("DIGITE A OPÇÃO DESEJADA");
	        System.out.println("INCLUIR PRATO NO CARDAPIO: 1");
	        System.out.println("INCLUIR BEBIDA NO CARDAPIO: 2");
	        System.out.println("INCLUIR VINHO NO CARDAPIO: 3");
	        System.out.println("VOLTAR PARA O MENU INICIAL: 0");
	        opcao = leitor.nextInt();
	        
	        //leitor.close();
	        
	        switch(opcao) {
	        case 1:
	        	cardapio.incluirPrato();
	        	break;
	        case 2:
	        	cardapio.incluirBebida();
	        	break;
	        case 3:
	        	cardapio.incluirVinho();
	        	break;
	        case 0:
	        	//menuInicial(cardapio, listaPedidos);
	        	//break;
	        	return;
	        default:
	        	System.out.println("Opção invalida!");
	        	//incluirItemCardapio(cardapio, listaPedidos);
	        	break;
	        }
		}

    	//incluirItemCardapio(cardapio, listaPedidos);
		
	}
	
	public static void arquivoPedido(List<Pedido> listaPedidos) throws IOException {
		
		//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out1, true), "UTF-8"));
		Path arquivoPedido = Paths.get("C:\\Users\\Bigulinha\\Desktop\\arquivoPedidos.txt");
		BufferedWriter gravadorPedido = Files.newBufferedWriter(arquivoPedido, StandardCharsets.UTF_8);
		
		double valorTotal = 0;
		for(int i = 0; i < listaPedidos.size(); i++) {
			valorTotal += listaPedidos.get(i).total;
			gravadorPedido.write("PEDIDO " + (i+1) + "\r\n");
			listaPedidos.get(i).gravarPedido(gravadorPedido);
		}
		
		gravadorPedido.write("O VALOR TOTAL É DE: R$" + getTotalFormatado(valorTotal));
		
		gravadorPedido.close();
	}

}
