import java.util.Scanner;

import javax.swing.JOptionPane;

public class ControleCadeiras {

	private static int[][] assentos = new int[5][5];
	
	public static void main(String[] args) {

		preencherMatriz();

		int assentoEscolhido;
		String nomeCliente;
		String escolhaMenuFilme = "";
		String filmes[] = { "S", "Jogos Vorazes", "A Volta Dos Que Não Foram" };
		String saida = escreverMatriz();

		final String CANCEL_COMPRA = "Cancelar compra";

		
		JOptionPane.showMessageDialog(null, "Seja bem-vindo ao CineTads");

		do {
			nomeCliente = JOptionPane.showInputDialog("Infome o seu nome:");

			if (!nomeCliente.matches("[A-z]*")) {
				JOptionPane.showMessageDialog(null, "Digite um nome válido, somente com letras.");
			}
		} while (!nomeCliente.matches("[A-z]*"));

		// Escolha do filme
		
		escolhaMenuFilme = JOptionPane.showInputDialog(
				nomeCliente + ", informe o filme que deseja assistir:" + "\n1-" + filmes[0] + "\n2-" + filmes[1] + "\n3-"
						+ filmes[2] + "\n" + "Caso queira cancelar a compra, digite: 4");
		

		do {
			escolhaMenuFilme = JOptionPane.showInputDialog(
					nomeCliente + ", informe o filme que deseja assistir:" + "\n" + filmes[0] + "\n" + filmes[1] + "\n"
							+ filmes[2] + "\n" + "Caso queira cancelar a compra, digite: " + CANCEL_COMPRA);

			if (escolhaMenuFilme.equals(CANCEL_COMPRA)) {
				JOptionPane.showMessageDialog(null, "Compra de ingressos cancelada!");
				return;

			} else if (escolhaMenuFilme.equals(filmes[0])) {
				assentoEscolhido = conversorInt(
						JOptionPane.showInputDialog(null, "Escolha a cadeira desejada: " + saida));
				atualizarAssentos(assentoEscolhido);
				saida = escreverMatriz();
				JOptionPane.showMessageDialog(null, "Modificada " + saida);

			} else if (escolhaMenuFilme.equals(filmes[1])) {
				JOptionPane.showMessageDialog(null, "Filme 2");
				return;

			} else if (escolhaMenuFilme.equals(filmes[2])) {
				JOptionPane.showMessageDialog(null, "Filme 3");
				return;
			}

			if (escolhaMenuFilme.isEmpty() && escolhaMenuFilme != filmes[0] || escolhaMenuFilme != filmes[1]
					|| escolhaMenuFilme != filmes[2]) {
				JOptionPane.showMessageDialog(null, "Digite o nome do filme ou a opção de cancelar!");
			}

		} while (escolhaMenuFilme.isEmpty() && escolhaMenuFilme != filmes[0] || escolhaMenuFilme != filmes[1]
				|| escolhaMenuFilme != filmes[2]);

	}

	public static void atualizarAssentos(int assentoEscolhido) {
		int coluna = 0;
		int linha = 0;
		boolean encontrado = false; 
		
		do {
			do {
				if(assentos[linha][coluna] == assentoEscolhido) {
					assentos[linha][coluna] = 0;
					encontrado = true; 
				} 
				
				coluna++;
			} while (coluna < assentos[linha].length && !encontrado);
		
			linha++;
		} while (linha < assentos.length && !encontrado);
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
	
	
	public static int conversorInt(String entrada) {
		return Integer.parseInt(entrada);
	}

}