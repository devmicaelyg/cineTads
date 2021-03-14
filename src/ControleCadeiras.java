import java.util.Scanner;

import javax.swing.JOptionPane;

public class ControleCadeiras {

	public static void main(String[] args) {

		String nomeCliente;
		String escolhaMenuFilme = ""; 
		String filmes[] = {"Star Wars", "Jogos Vorazes", "A Volta Dos Que Não Foram"};
		
		int[][] assentos = new int[5][5]; 
//		assentos[0][0] = 1; 
//		assentos[0][1] = 2; 
//		assentos[0][2] = 3;
//		assentos[0][3] = 4;
//		assentos[0][4] = 5;
//		assentos[1][1] = 6;
//		assentos[2][2] = 7;
		
		 for( int linha = 0; linha < assentos.length; linha++) {
		      for( int coluna = 0; coluna < assentos[linha].length; coluna++) {
		        //Gera um numero qualquer para a matriz
		        assentos[linha][coluna] = linha + coluna;
		        JOptionPane.showMessageDialog(null, assentos[linha][coluna]);
		      }
		    }
		
		
		final String CANCEL_COMPRA = "Cancelar compra";
		
		Scanner input = new Scanner(System.in);
		
		JOptionPane.showMessageDialog(null, "Seja bem-vindo ao CineTads");
		nomeCliente = JOptionPane.showInputDialog("Infome o seu nome:");
		
		while(escolhaMenuFilme.isEmpty() && escolhaMenuFilme != filmes[0] || escolhaMenuFilme != filmes[1]
				|| escolhaMenuFilme != filmes[2]) {}
		
		escolhaMenuFilme = JOptionPane.showInputDialog(nomeCliente + ", informe o filme que deseja assistir:" 
				+ "\n" + filmes[0] + "\n" + filmes[1] + "\n" +  filmes[2] + "\n" + CANCEL_COMPRA);
		
		if(escolhaMenuFilme.equals(CANCEL_COMPRA)) {
			JOptionPane.showMessageDialog(null, "Compra de ingressos cancelada");
		} else if(escolhaMenuFilme.equals(filmes[0])){
			JOptionPane.showMessageDialog(null, "Filme 1");
		} else if(escolhaMenuFilme.equals(filmes[1])){
			JOptionPane.showMessageDialog(null, "Filme 2");
		} else if(escolhaMenuFilme.equals(filmes[2])){
			JOptionPane.showMessageDialog(null, "Filme 3");
		}
		
	}
	
}
