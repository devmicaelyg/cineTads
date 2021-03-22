import java.awt.Color;
import java.util.*;

import javax.swing.JOptionPane;

public class ControleCadeiras {

	// Mensagem inicial
	public static void msgBemVindo() {
		JOptionPane.showMessageDialog(null, "Cine Tads - O melhor do Brasil");
	}

	// Guardar nome
	public static String getNome() {
		String str;
		while (true) {
			str = JOptionPane.showInputDialog("Informe o seu nome:");
			if (!str.matches("[A-z ]*")) {
				JOptionPane.showMessageDialog(null, "Nome inv�lido, somente letras.");

			} else {
				return str;
			}
		}
	}

	// Guardar filme
	public static String getFilme() {
		String str;

		while (true) {
			str = JOptionPane.showInputDialog(
					"Escolha o filme:\n[1] Star Wars\n[2] Jumanji\n[3] A tran�a dos carecas\n[4] Cancelar compra");
			switch (str) {
			case "1":
				return "Star Wars";
			case "2":
				return "Jumanji";
			case "3":
				return "A tran�a dos carecas";
			case "4":
				JOptionPane.showMessageDialog(null, "Compra cancelada com sucesso!");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Escolha uma op��o v�lida!");
			}
		}
	}

	// Guardar assentos
	public static void getAssentos(String nome) {
		Boolean continuar = true; // Para sair do while sem usar continue
		String assentos[][][] = new String[5][5][3], 
				fileira[] = { "A", "B", "C", "D", "E" }, 
				exibir = "", 
				op = "";
		int x = -1, y = -1;
		int lotacao = 0;

		// Gerar Matriz Assentos
		for (int i = 0; i < assentos.length; i++) {
			for (int j = 0; j < assentos[i].length; j++) {
				for (int k = 0; k < 3; k++) {
					assentos[i][j][0] = fileira[i]; // Posi��o X
					assentos[i][j][1] = j + 1 + ""; // Posi��o Y
					assentos[i][j][2] = "1"; // [1] Dispon�vel; [0] Indispon�vel
				}
			}
		}

		while (continuar) {
			// Exibir Matriz
			exibir = "";
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (assentos[i][j][2] == "0") {
						exibir += "[XX]    ";
					} else {
						exibir += "[" + assentos[i][j][0] + assentos[i][j][1] + "]    ";
					}
				}
				exibir += "\n";
			}

			exibir += "Escolha uma cadeira:";
			op = JOptionPane.showInputDialog(exibir);

			// Verifica��es
			try {
				x = Arrays.asList(fileira).indexOf(op.charAt(0) + ""); // LETRA+NUMERO (A2)
				y = Integer.parseInt(op.charAt(1) + "") - 1;
			} catch (Exception err) {
				JOptionPane.showMessageDialog(null, "Insira um assento v�lido!");
			}

			if (x < 0 || (y < 0 || y > 4)) { // Letra ou numero inv�lido
				JOptionPane.showMessageDialog(null, "Insira um assento v�lido!");
			}

			// Reservando cadeira
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (assentos[i][j][0].equals(op.charAt(0) + "")) { // A1
						if (assentos[i][j][1].equals(op.charAt(1) + "")) {
							if (assentos[i][j][2].equals("1")) {
								JOptionPane.showMessageDialog(null, "Reservado com sucesso!");
								assentos[i][j][2] = "0";
							} else {
								JOptionPane.showMessageDialog(null, "Assento j� reservado!");
							}
						}
					}

				}
			}

			// Verificando lota��o
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (assentos[i][j][2] == "0") {
						lotacao++;
						if (lotacao == 25) {
							JOptionPane.showMessageDialog(null, "Infelizmente todos os assentos ja foram reservados");
							continuar = false;
						}
					}
				}
			}
			
			if (continuar == true) {

				op = JOptionPane.showInputDialog("Digite [S] para continuar ou qualquer outra tecla para finalizar...");

				switch (op) {
				case "S":
				case "s":
					continuar = true;
					break;
				default:
					continuar = false;
				}
			}
		}

		// Resultado
		double valor_reserva = 15;
		int qtde_reservas = 0;
		int tot = 0;
		exibir = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (assentos[i][j][2] == "0") {
					tot += valor_reserva;
					qtde_reservas++;
					exibir += "[XX]    ";
				} else {
					exibir += "[" + assentos[i][j][0] + assentos[i][j][1] + "]    ";
				}
			}
			exibir += "\n\n";
		}

		exibir += "\nObrigado " + nome + ".\nQuantidade Reservas: " + qtde_reservas + "x\nValor Total: R$ " + tot
				+ "\n\nCine Tads Agradece!";
		JOptionPane.showMessageDialog(null, exibir);

	}

	// Execu��o do codigo principal

	public static void main(String[] args) {
		String nomeCliente, filme;

		// Mensagem de boas vindas
		msgBemVindo();

		// Nome do cliente
		nomeCliente = getNome();

		// Filme escolhido
		filme = getFilme();

		// Reservar assentos
		getAssentos(nomeCliente);
	}
}