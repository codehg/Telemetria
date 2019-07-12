package excecoes;

import javax.swing.JOptionPane;

public class CombustivelInvalidoException extends Exception {
	static String combustivel;
	static String tipo;
	static String retorno;
	static int saida =0;

	public CombustivelInvalidoException(String combustivel, String tipo) {
		super();
		CombustivelInvalidoException.retorno = combustivel;
		CombustivelInvalidoException.tipo = tipo;
	}

	public static String correcao() {
		int count = 3;
		do {
			JOptionPane.showMessageDialog(null, CombustivelInvalidoException.retorno + " nao e compativel com " + CombustivelInvalidoException.tipo, "Combust�velIncompativelException", JOptionPane.ERROR_MESSAGE);
			CombustivelInvalidoException.retorno = JOptionPane.showInputDialog("Digite um combustivel valido. Voce ainda tem "+count+" chances");
			if(CombustivelInvalidoException.retorno.intern() == CombustivelInvalidoException.tipo.intern() || (CombustivelInvalidoException.tipo.intern() == "flex".intern() && CombustivelInvalidoException.retorno.intern() == "gasolina".intern()) || (CombustivelInvalidoException.tipo.intern() == "flex".intern() && CombustivelInvalidoException.retorno.intern() == "alcool".intern())){
				saida = 1;
			}
			count--;
			if(count == 0) {
				retorno = "cancelar";
				break;
			}
		}while (saida != 1);
		return retorno;
	}
	
}
