import java.util.Scanner;

import javax.swing.JOptionPane;

public class ControleCadeiras {

	private static int[][] assentos = new int[5][5];

	public static void main(String[] args) {

		preencherMatriz();

		int assentoEscolhido, escolherCadeira;
		boolean erro = false; 
		boolean respostaFinalizacao = false; 
		String nomeCliente;
		String escolhaMenuFilme = "";
		String filmes[] = { "1- Star Wars", "2- Jogos Vorazes", "3- A Volta Dos Que Não Foram" };
		String saida = escreverMatriz();

		JOptionPane.showMessageDialog(null, "Seja bem-vindo ao CineTads");

		do {
			nomeCliente = JOptionPane.showInputDialog("Infome o seu nome:");

			if (!nomeCliente.matches("[A-z]*")) {
				JOptionPane.showMessageDialog(null, "Digite um nome válido, somente com letras.");
			}
		} while (!nomeCliente.matches("[A-z]*"));

		// Escolha do filme

		do {
			escolhaMenuFilme = JOptionPane.showInputDialog(
					nomeCliente + ", Informe o número do filme que deseja assistir:" + "\n" + filmes[0] + "\n2-"
							+ filmes[1] + "\n" + filmes[2] + "\n" + "Caso queira cancelar a compra, digite: 4");

			escolherCadeira = conversorInt(escolhaMenuFilme);

			switch (escolherCadeira) {
			case 1:
				escolherAssento();
				respostaFinalizacao = isFinalizar();
				
				if(respostaFinalizacao) {
					escolherAssento();		
					respostaFinalizacao = isFinalizar();
				} else {
					System.out.print("Finaliza esse caraio");
				}
				break;

			case 2:
				assentoEscolhido = conversorInt(
						JOptionPane.showInputDialog(null, "Escolha a cadeira desejada: " + saida));
				atualizarAssentos(assentoEscolhido);
				saida = escreverMatriz();

				JOptionPane.showMessageDialog(null, "Modificada " + saida);
				break;
			case 3:
				assentoEscolhido = conversorInt(
						JOptionPane.showInputDialog(null, "Escolha a cadeira desejada: " + saida));
				atualizarAssentos(assentoEscolhido);
				saida = escreverMatriz();

				JOptionPane.showMessageDialog(null, "Modificada " + saida);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Compra de ingressos cancelada!", "", JOptionPane.CANCEL_OPTION);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Você precisa digitar uma opção válida." , "Atenção",
						  JOptionPane.ERROR_MESSAGE);
				erro = true;
			}
		} while (erro);
	}

	public static Boolean atualizarAssentos(int assentoEscolhido) {
		int coluna = 0;
		int linha = 0;
		boolean encontrado = false;

		do {
			do {
				if (assentos[linha][coluna] == assentoEscolhido) {
					assentos[linha][coluna] = 0;
					encontrado = true;
				}

				coluna++;
			} while (coluna < assentos[linha].length && !encontrado);

			linha++;
		} while (linha < assentos.length && !encontrado);
		return encontrado;
	}

	public static String escreverMatriz() {
		String saida = "";

		for (int linha = 0; linha < assentos.length; linha++) {
			for (int coluna = 0; coluna < assentos[linha].length; coluna++) {
				saida += "| " + assentos[linha][coluna];
			}
		}
		return saida;
	}

	public static void preencherMatriz() {
		int contador = 1;

		for (int linha = 0; linha < assentos.length; linha++) {
			for (int coluna = 0; coluna < assentos[linha].length; coluna++) {
				assentos[linha][coluna] = contador++;
			}
		}
	}
	
	public static String escolherAssento() {
		String saida = escreverMatriz();
		int assentoEscolhido; 
		
		assentoEscolhido = conversorInt(
				JOptionPane.showInputDialog(null, "Escolha a cadeira desejada: " + saida));
		atualizarAssentos(assentoEscolhido);
		return saida; 
	}

	public static boolean isFinalizar() {
		int escolhaFinal;
		escolhaFinal = conversorInt(JOptionPane.showInputDialog(null, "Se você deseja reservar mais uma cadeira digite 1, senão 2 para finalização da compra"));
		if(escolhaFinal == 1) {
			return true; 
		}
		return false;
	}
	
	public static int conversorInt(String entrada) {
		return Integer.parseInt(entrada);
	}

}