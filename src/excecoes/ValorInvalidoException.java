package excecoes;

import javax.swing.JOptionPane;

public class ValorInvalidoException extends Exception {

	public static float correcao(String metodo, float alvo) {
		int count = 3;
		float retorno = 1.0f;
		if (metodo.intern() == "menorIgual".intern()) {
			do {
				JOptionPane.showMessageDialog(null, "O valor nao pode ser menor ou igual a " + alvo,
						"ValorInvalidoException", JOptionPane.ERROR_MESSAGE);
				retorno = Float.parseFloat(
						JOptionPane.showInputDialog("Digite um valor valido. Voce tem " + count + " chances"));
				count--;
				if (count == 0) {
					retorno = 4444.0f;
					break;
				}
			} while (retorno <= alvo);
		} else if (metodo.intern() == "menor") {
			do {
				JOptionPane.showMessageDialog(null, "O valor nao pode ser menor que " + alvo, "ValorInvalidoException",
						JOptionPane.ERROR_MESSAGE);
				retorno = Float.parseFloat(
						JOptionPane.showInputDialog("Digite um valor valido. Voce tem " + count + " chances"));
				count--;
				if (count == 0) {
					retorno = 4444.0f;
					break;
				}
			} while (retorno < alvo);
		}
		return retorno;
	}

}
